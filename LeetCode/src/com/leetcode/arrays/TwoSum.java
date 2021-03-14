package com.leetcode.arrays;

import java.util.HashMap;
import java.util.HashSet;

public class TwoSum {

	public int[] twoSumHashSet(int[] nums, int target) {
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 0; i < nums.length; i++) {
			int n = target - nums[i];
			if (set.contains(n)) {
				for (int j = i; j >= 0; j--) {
					if (nums[j] == n) {
						return new int[] {j, i};
					}
				}
			}
			set.add(nums[i]);
		}
		
		return new int[] {};
	}
	
	public int[] twoSumHashMap(int[] nums, int target) {
		HashMap<Integer, Integer> set = new HashMap<>();
		
		for (int i = 0; i < nums.length; i++) {
			int n = target - nums[i];
			if (set.keySet().contains(n)) {
				return new int[] {set.get(n), i};
			}
			set.put(nums[i], i);
		}
		
		return new int[] {};
	}
	
	public int[] twoSumBrute(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					return new int[] {i, j};
				}
			}
		}
		
		return new int[] {};
	}
	
	public void print(int[] nums) {
		System.out.print("[");
		for (int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
			if (i < nums.length - 1) System.out.print(", ");
		}
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		TwoSum ts = new TwoSum();
		int[] example1 = {2, 7, 11, 15};
		int[] example2 = {3, 2, 4};
		int[] example3 = {2, 6, 3, -5, 7};

		ts.print(ts.twoSumHashSet(example1, 9));
		ts.print(ts.twoSumHashSet(example2, 6));
		ts.print(ts.twoSumHashSet(example3, 1));
		
		System.out.println();
		
		ts.print(ts.twoSumHashMap(example1, 9));
		ts.print(ts.twoSumHashMap(example2, 6));
		ts.print(ts.twoSumHashMap(example3, 1));
		
		System.out.println();
		
		ts.print(ts.twoSumBrute(example1, 9));
		ts.print(ts.twoSumBrute(example2, 6));
		ts.print(ts.twoSumBrute(example3, 1));
	}

}
