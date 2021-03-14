package com.leetcode.arrays;

public class SingleNumber {
	// my solution
	public int singleNumber(int[] nums) {
		int k = 0;
		
		while (k < nums.length / 2) {
			int i = k, j = nums.length - 1 - k;
			while (i <= j) {
				if (i == j) return nums[i];
				if (nums[i] == nums[j]) {
					int temp1, temp2;
					temp1 = nums[k];
					temp2 = nums[nums.length-1-k];
					nums[k] = nums[i];
					nums[nums.length-1-k] = nums[j];
					nums[i] = temp1;
					nums[j] = temp2;
					k++;
					break;
				}
				else if (nums[i] < nums[j]) i++;
				else j--;
			}
		}
		
		return nums[k];
	}
	
	// genious way - bit manipulation (a xor 0 = a, a xor a = 0)
	public int singleNumberXor(int[] nums) {
		int a = 0;
		
		for (int i : nums) 
			a ^= i;
		
		return a;
	}
	
	public static void main(String args[]) {
		int[] example = new int[] {4, 1, 2, 1, 2};
		
		SingleNumber sn = new SingleNumber();
		
		System.out.println(sn.singleNumber(example));
	}
}
