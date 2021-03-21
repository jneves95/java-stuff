package com.leetcode.arrays;

/*
 * LeetCode 18 March 2021 Challenge
 * 
 * Given an array of positive integers, determine the length of the longest wiggle subsequence.
 * 
 * A wiggle sequence is one in which the difference between two consecutive integers 
 * alternates between negative and positive (not zero).
 */
public class WiggleSequence {

	public int wiggleMaxLength(int[] nums) {
		if (nums.length <= 1) return nums.length;
		
		int len = 1;
		int alt = 0;
		
		for (int i = 1; i < nums.length; i++) {
			if (alt == 0 && nums[i] != nums[i-1]) {
				alt = nums[i] - nums[i-1];
				len++;
			}
			else if (alt > 0 && nums[i] < nums[i-1] || alt < 0 && nums[i] > nums[i-1]) {
				alt *= -1;
				len++;
			}
		}
				
		return len;
	}
	
	public static void main(String[] args) {
		WiggleSequence ws = new WiggleSequence();
		int[] nums1 = {3, 2, 5, 4, 18, 3};
		int[] nums2 = {1, 2};
		int[] nums3 = {1, 1};
		int[] nums4 = {1, 2, 3, 4, 3, 5, 6, 7};
		int[] nums5 = {3, 2, 5, 4, 18, 18};
		
		int[][] nums = {nums1, nums2, nums3, nums4, nums5};
		
		for (int[] arr : nums) {
			System.out.println(ws.wiggleMaxLength(arr));
		}
	}

}
