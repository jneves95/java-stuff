package com.leetcode.arrays;

import java.util.Arrays;

public class AdvantageShuffle {

	static int[] advantageShuffle(int[] A, int[] B) {
		int[] ans = new int[A.length];
		
		
		// Initialize an index array to sort the indices of B with respect to the values in B
		Integer[] bSorted = new Integer[B.length];
		for (int i = 0; i < B.length; i++) {
			bSorted[i] = i;
		}
		
		// Sort A and B-indices
		Arrays.sort(A);
		Arrays.sort(bSorted, (i, j) -> {	// In descending order
			return B[j] - B[i];
		});
		
		// Iterate over the sorted indices of B and assign the larger A value if it's bigger, 
		// or the smallest A value if not. These values go directly to their correct position on the result array.
		int i = 0, j = A.length - 1;		
		for (int b : bSorted) {
			ans[b] = A[j] > B[b] ? A[j--] : A[i++];
		}
		
		return ans;
	}
		
	public static void main(String[] args) {
		int[] arr1 = {11, 8, 24, 3, 7, 15, 9};
		int[] arr2 = {13, 8, 22, 6, 14, 9, 2};
		
		int[] res = advantageShuffle(arr1, arr2);
		
		for (int i : res) {
			System.out.print(i + " ");
		}
		
		System.out.println();
	}

}
