package com.leetcode.arrays;

public class RemoveDuplicates {
	public int removeDuplicates(int nums[]) {
		if (nums.length == 0) return 0;
		int j = 0;
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[j]) {
				nums[++j] = nums[i];
			}
		}
		
		return ++j;
	}
	
	public static void main(String args[]) {
		int[] example0 = new int[] {0, 0, 1, 1, 1, 2, 3, 4, 4, 5, 6};
		int[] example1 = new int[] {3};
		int[] example2 = new int[] {-5000, 500, 5000};
		int[] example3 = new int[] {2, 2};
		int[] example4 = new int[] {};
		int[][] examples = new int[][] {example0, example1, example2, example3, example4};
		
		RemoveDuplicates solution = new RemoveDuplicates();
		
		for (int[] nums : examples) {
			int len = solution.removeDuplicates(nums);
			
			System.out.print(len + ", nums = [");
			
			for (int j = 0; j < len; j++) {
				System.out.print(nums[j]);
				if (j < len - 1) System.out.print(", ");
			}
			
			System.out.println("]");
		}
	}
}