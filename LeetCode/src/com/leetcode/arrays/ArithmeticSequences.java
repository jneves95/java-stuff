package com.leetcode.arrays;

/* 
 * LeetCode February 18 2021 Challenge
 * 
 * A sequence of numbers is called arithmetic if it consists of at least three elements and the difference between any two elements in that sequence is the same.
 * Given an array of integers, returns the total number of arithmetic subsequences found.
 * 
 * We know that for an arithmetic sequence of length N (N >= 3), the number of arithmetic subsequences is N(N+1)/2.
 * But we can also think that, since we are iterating over the sequence, for every additional number we find that increases the length of the sequence to M (M = N + 1), 
 * the additional number of subsequences will be M-2 (or N-1). So imagine we already have X subsequences for a sequence of length 5. When we find a 6th number, the additional
 * subsequences will be 6-2 = 5-1 = 4.
 * 
 * So starting with the minimum length 3, we know to add 1 sequence. Length 4 -> 2 more, length 5 -> 3 more. We can see the pattern here. If the difference changes, 
 * reset the count to 1.
 */
public class ArithmeticSequences {

	public int numSequences(int[] arr) {
		if (arr.length < 3) return 0;
		int ans = 0;
		
		for (int i = 2, count = 1; i < arr.length; i++) {
			if (arr[i] - arr[i-1] == arr[i-1] - arr[i-2]) {
					ans += count++;
			}
			else {
				count = 1;
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		ArithmeticSequences as = new ArithmeticSequences();
		int[] arr = {1, 2, 3, 4, 5, 6};
		
		System.out.println(as.numSequences(arr));
	}

}
