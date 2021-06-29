package com.prakhar.Percolation_Model.refrenced;


public class IOUtils {
	public static int[] readIntArray(InputReader in, int n) {
		int[] array = new int[n];
		for (int i = 0; i < n; i++)
			array[i] = in.readInt();
		return array;
	}

	public static long[] readLongArray(InputReader in, int n) {
		long[] array = new long[n];
		for (int i = 0; i < n; i++)
			array[i] = in.readLong();
		return array;
	}
}