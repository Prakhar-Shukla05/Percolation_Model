package com.prakhar.Percolation_Model.model;
/*
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import src.main.assignments.IllegalArgumentException;
import src.main.assignments.Percolation;
import src.main.assignments.String;
*/
import com.prakhar.Percolation_Model.refrenced.*;

public class Percolation 
{
	private int [][] grid;
    final private int top;
    final private int bottom;
	final private int twoDimension;
    final private int dimension;
    private WeightedQuickUnionFindUF wq;
    private int openSites;
    
    public Percolation(int n)
    {
    	if(n<=0)
    		throw new IllegalArgumentException();
    	
    	twoDimension = n*n;
    	dimension=n;
    	grid= new int[n+1][n+1];
    	for(int i=1;i<=n;i++)
    	{
    		for(int j=1;j<=n;j++)
    		{
    			grid[i][j]=0;
    			
    		}
    	}
    	wq= new WeightedQuickUnionFindUF(twoDimension+2);
        top=twoDimension;
        bottom=twoDimension+1;
        openSites=0;
    }
    
    private boolean validate(int index1, int index2)
    {
    	if(index1<1 || index1>dimension || index2<1 || index2>dimension)
    		throw new IllegalArgumentException("Index is out of bound");
    	else
    		return true;
    	
    }
    
    private int getIndex(int row, int col)
    {
        return (((row-1)*dimension)+col-1); 	
    }
    
    public void open(int row, int col)
    {
    	validate(row,col);
    	if (isOpen(row,col))
    	{
    		return ;
    	}
    	
    	grid[row][col]=1;
    	openSites++;
    	if(row==1)
    	{
    		wq.union(top,getIndex(row,col));
    	}
    	if(row==dimension)
    	{
    		wq.union(bottom,getIndex(row,col));
    	}
    	
    	if(row>1) {
    	if(validate(row-1,col))
    	{
    		if (isOpen(row-1,col)) 
    		{
    			wq.union(getIndex(row-1,col),getIndex(row,col));
    		}
    	}
    	}
    	if(row<dimension) {
    	if(validate(row+1,col))
    	{
    		if (isOpen(row+1,col)) 
    		{
    			wq.union(getIndex(row+1,col),getIndex(row,col));
    		}
    	}
    	}
    	if(col>1) {
    		if(validate(row,col-1))
        	{
        		if (isOpen(row,col-1)) 
        		{
        			wq.union(getIndex(row,col-1),getIndex(row,col));
        		}
        	}
    	}
    	if(col<dimension)
    	{
    		if(validate(row,col+1))
        	{
        		if (isOpen(row,col+1)) 
        		{
        			wq.union(getIndex(row,col+1),getIndex(row,col));
        		}
        	}
    	}

    }
    
    public boolean isOpen(int row,int col)
    {
        validate(row,col);	
    	return grid[row][col]==1;
    }
    
    public boolean isFull(int row, int col)
    {
    	validate(row,col);
    	return wq.find(top)==wq.find(getIndex(row,col));
    }
    
    public int numberOfOpenSites()
    {
    	return openSites;
    }
    
    public boolean percolates()
    {
    	return wq.find(top)==wq.find(bottom);
    }

	public static void main(String[] args) 
	{
		InputReader in = new InputReader(System.in);
		OutputWriter out = new OutputWriter(System.out);
		int n= in.readInt();
		Percolation p= new Percolation(n);
		int [] arr= IOUtils.readIntArray(in, n);
		for(int i=0;i<arr.length;i+=2)
		{
			p.open(arr[i],arr[i+1]);
			if(p.percolates())
			{
				out.printLine("System is percolating");
				return ;
			}
		}
		out.printLine("System doesn't percolate");
		out.close();

	}

}

