package com.prakhar.Percolation_Model.model;

import com.prakhar.Percolation_Model.model.Percolation;
/*
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
*/
import com.prakhar.Percolation_Model.refrenced.*;
public class PercolationStats {
      
	final private int dimension;
	final private int trials;
	private double [] threshold;
	private int open;
	final double CONFIDENCE= 1.96;
	private double mean,stddev;
	
	public PercolationStats(int n, int trials)
	{ 
		if(n<=0 || trials<=0)
			throw new IllegalArgumentException();
	    Percolation per;
		dimension=n;
		this.trials=trials;
		threshold=new double[trials];
		for(int i=0;i<trials;i++)
		{
			per=new Percolation(dimension);
			while(!per.percolates())
			{
				int row=StdStats.uniform(1,n+1);
				int col=StdStats.uniform(1,n+1);
				per.open(row, col);
			}
			open=per.numberOfOpenSites();
			threshold[i]=(double)open/(double)(dimension*dimension);
		}
		
		
		
	}
	
	
	
	public double mean()
	{
		if(mean==0.0)
		return StdStats.mean(threshold);
		else
			return mean;
			
	}
	
	public double stddev()
	{
	    if(stddev==0.0)
		return StdStats.stddev(threshold);
	    else
	    	return stddev;
	}
	
	
	public double confidenceLo()
	{
		return (mean-((CONFIDENCE*stddev)/Math.sqrt(trials)));
	}
	
	public double confidenceHi() 
	{
		return (mean+((CONFIDENCE*stddev))/Math.sqrt(trials));	
	}
	public static void main(String[] args) 
	{
		 InputReader in = new InputReader(System.in);
		 OutputWriter out = new OutputWriter(System.out);
		 out.printLine("Give the value for n i.e. the size of the model :");
         int n=in.readInt();
         out.printLine("Give the value for t i.e. the number of trials :");
         int t=in.readInt();
         PercolationStats p = new PercolationStats(n,t);
         double mean,stddev,lo,high;
        mean=p.mean();
         stddev=p.stddev();
         lo=p.confidenceLo();
         high=p.confidenceHi();
         out.printLine("Mean                    = ");
         out.printLine(mean+"\n");
         out.printLine("stddev                  = ");
         out.printLine(stddev+"\n");
         out.printLine("95% confidence interval = ["+lo+", "+high+"]");
         out.close();
         
         
         
         
     }

}

