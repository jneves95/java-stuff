package com.leetcode.arrays;

import java.util.Arrays;

public class ContainsDuplicate {
	// Takes O(n^2) time
	public boolean containsDuplicate(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] == nums[j]) return true;
			}
		}
		
		return false;
	}
	
	// For better time complexity, sort the array first and then verify only consecutive numbers in the array
	// (using heapsort, for example, makes it so that it takes O(n log n) )
	public boolean containsDuplicateSort(int[] nums) {
		Arrays.sort(nums);
		
		for(int i = 0; i < nums.length - 1; i++) 
			if (nums[i] == nums[i+1]) return true;
		
		return false;
	}
	
	public static void main(String[] args) {
		int[] example0 = new int[] {1, 2, 3, 4, 5};
		int[] example1 = new int[] {1, 1, 3, 4, 5};
		int[] example2 = new int[] {1, 2, 3, 4, 2};
		int[] example3 = new int[] {};
		int[] example4 = new int[] {1, 1};
		int[][] examples = new int[][] {example0, example1, example2, example3, example4};
		
		ContainsDuplicate cd = new ContainsDuplicate();
		
		for (int[] example : examples)
			System.out.println(cd.containsDuplicate(example));
	}
}
