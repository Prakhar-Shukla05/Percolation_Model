package com.prakhar.Percolation_Model.refrenced;

import java.util.Random;

public class StdStats {

	 public static double max(double[] a) {
	        validateNotNull(a);

	        double max = Double.NEGATIVE_INFINITY;
	        for (int i = 0; i < a.length; i++) {
	            if (Double.isNaN(a[i])) return Double.NaN;
	            if (a[i] > max) max = a[i];
	        }
	        return max;
	    }

	     
	    public static double max(double[] a, int lo, int hi) {
	        validateNotNull(a);
	        validateSubarrayIndices(lo, hi, a.length);

	        double max = Double.NEGATIVE_INFINITY;
	        for (int i = lo; i < hi; i++) {
	            if (Double.isNaN(a[i])) return Double.NaN;
	            if (a[i] > max) max = a[i];
	        }
	        return max;
	    }

	    public static int max(int[] a) {
	        validateNotNull(a);

	        int max = Integer.MIN_VALUE;
	        for (int i = 0; i < a.length; i++) {
	            if (a[i] > max) max = a[i];
	        }
	        return max;
	    }

	     
	    public static double min(double[] a) {
	        validateNotNull(a);

	        double min = Double.POSITIVE_INFINITY;
	        for (int i = 0; i < a.length; i++) {
	            if (Double.isNaN(a[i])) return Double.NaN;
	            if (a[i] < min) min = a[i];
	        }
	        return min;
	    }

	  
	     
	    public static double min(double[] a, int lo, int hi) {
	        validateNotNull(a);
	        validateSubarrayIndices(lo, hi, a.length);

	        double min = Double.POSITIVE_INFINITY;
	        for (int i = lo; i < hi; i++) {
	            if (Double.isNaN(a[i])) return Double.NaN;
	            if (a[i] < min) min = a[i];
	        }
	        return min;
	    }

	     
	    public static int min(int[] a) {
	        validateNotNull(a);

	        int min = Integer.MAX_VALUE;
	        for (int i = 0; i < a.length; i++) {
	            if (a[i] < min) min = a[i];
	        }
	        return min;
	    }

	   
	    public static double mean(double[] a) {
	        validateNotNull(a);

	        if (a.length == 0) return Double.NaN;
	        double sum = sum(a);
	        return sum / a.length;
	    }

	  
	    public static double mean(double[] a, int lo, int hi) {
	        validateNotNull(a);
	        validateSubarrayIndices(lo, hi, a.length);

	        int length = hi - lo;
	        if (length == 0) return Double.NaN;

	        double sum = sum(a, lo, hi);
	        return sum / length;
	    }

	     
	    public static double mean(int[] a) {
	        validateNotNull(a);

	        if (a.length == 0) return Double.NaN;
	        int sum = sum(a);
	        return 1.0 * sum / a.length;
	    }

	    public static double var(double[] a) {
	        validateNotNull(a);

	        if (a.length == 0) return Double.NaN;
	        double avg = mean(a);
	        double sum = 0.0;
	        for (int i = 0; i < a.length; i++) {
	            sum += (a[i] - avg) * (a[i] - avg);
	        }
	        return sum / (a.length - 1);
	    }

	    
	    public static double var(double[] a, int lo, int hi) {
	        validateNotNull(a);
	        validateSubarrayIndices(lo, hi, a.length);

	        int length = hi - lo;
	        if (length == 0) return Double.NaN;

	        double avg = mean(a, lo, hi);
	        double sum = 0.0;
	        for (int i = lo; i < hi; i++) {
	            sum += (a[i] - avg) * (a[i] - avg);
	        }
	        return sum / (length - 1);
	    }

	 
	    public static double var(int[] a) {
	        validateNotNull(a);
	        if (a.length == 0) return Double.NaN;
	        double avg = mean(a);
	        double sum = 0.0;
	        for (int i = 0; i < a.length; i++) {
	            sum += (a[i] - avg) * (a[i] - avg);
	        }
	        return sum / (a.length - 1);
	    }

	    
	    public static double varp(double[] a) {
	        validateNotNull(a);
	        if (a.length == 0) return Double.NaN;
	        double avg = mean(a);
	        double sum = 0.0;
	        for (int i = 0; i < a.length; i++) {
	            sum += (a[i] - avg) * (a[i] - avg);
	        }
	        return sum / a.length;
	    }

	   
	    public static double varp(double[] a, int lo, int hi) {
	        validateNotNull(a);
	        validateSubarrayIndices(lo, hi, a.length);

	        int length = hi - lo;
	        if (length == 0) return Double.NaN;

	        double avg = mean(a, lo, hi);
	        double sum = 0.0;
	        for (int i = lo; i < hi; i++) {
	            sum += (a[i] - avg) * (a[i] - avg);
	        }
	        return sum / length;
	    }

	  
	    public static double stddev(double[] a) {
	        validateNotNull(a);
	        return Math.sqrt(var(a));
	    }

	 
	    public static double stddev(int[] a) {
	        validateNotNull(a);
	        return Math.sqrt(var(a));
	    }

	  
	    public static double stddev(double[] a, int lo, int hi) {
	        validateNotNull(a);
	        validateSubarrayIndices(lo, hi, a.length);

	        return Math.sqrt(var(a, lo, hi));
	    }


	  
	    public static double stddevp(double[] a) {
	        validateNotNull(a);
	        return Math.sqrt(varp(a));
	    }

	  
	    public static double stddevp(double[] a, int lo, int hi) {
	        validateNotNull(a);
	        validateSubarrayIndices(lo, hi, a.length);

	        return Math.sqrt(varp(a, lo, hi));
	    }

	    
	    private static double sum(double[] a) {
	        validateNotNull(a);
	        double sum = 0.0;
	        for (int i = 0; i < a.length; i++) {
	            sum += a[i];
	        }
	        return sum;
	    }

	 
	    private static double sum(double[] a, int lo, int hi) {
	        validateNotNull(a);
	        validateSubarrayIndices(lo, hi, a.length);

	        double sum = 0.0;
	        for (int i = lo; i < hi; i++) {
	            sum += a[i];
	        }
	        return sum;
	    }

	   
	    private static int sum(int[] a) {
	        validateNotNull(a);
	        int sum = 0;
	        for (int i = 0; i < a.length; i++) {
	            sum += a[i];
	        }
	        return sum;
	    }

	    public static int uniform(int a, int b) {
	        if ((b <= a) || ((long) b - a >= Integer.MAX_VALUE)) {
	            throw new IllegalArgumentException("invalid range: [" + a + ", " + b + ")");
	        }
	        return a + uniform(b - a);
	    }
	    
	    public static int uniform(int n) {
	        if (n <= 0) throw new IllegalArgumentException("argument must be positive: " + n);
	        Random random= new Random();
	        return random.nextInt(n);
	    }
	   
	    private static void validateNotNull(Object x) {
	        if (x == null)
	            throw new IllegalArgumentException("argument is null");
	    }

	    
	    private static void validateSubarrayIndices(int lo, int hi, int length) {
	        if (lo < 0 || hi > length || lo > hi)
	            throw new IllegalArgumentException("subarray indices out of bounds: [" + lo + ", " + hi + ")");
	    }


	    public static void main(String[] args) {
	    
	    }
}
