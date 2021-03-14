package com.leetcode.arrays;

import java.util.HashSet;

/*
 * LeetCode 02 March 2021 Challenge
 */
public class SetMismatch {
	public int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int dup = 0;
        int total = 0;
        
        // Sum all numbers and find duplicate
        for (int i = 0; i < nums.length; i++) {
        	if (set.contains(nums[i])) {
        		dup = nums[i];
        	}
        	set.add(nums[i]);
        	total += nums[i];
        }
        
        // Having the duplicate value and the total sum, we can compare it with the expected sum and find out the missing number
        int expected = nums.length * (nums.length + 1) / 2;
        int missing = expected - (total - dup);
        
        return new int[] {dup, missing};
    }

	public static void main(String[] args) {
		
	}

}
