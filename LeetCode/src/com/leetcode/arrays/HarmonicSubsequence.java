package com.leetcode.arrays;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Given an array of numbers, this calculates the length of the longest subsequence of that array where the difference between the minimum and maximum values is exactly 1.
 * Example: input = [2, 1, 3, 2, 3, 4, 5, 4, 1, 1]
 * 			output =  5, and the subsequence is [2, 1, 2, 1, 1]
 * 
 * There are multiple ways to do this, and with increased difficulty in finding them comes also increased efficiency
 */
public class HarmonicSubsequence {
	/*
	 * Probably the easiest method to figure out, using no extra data structures or algorithms,
	 * pretty much just iterates over the array, and for every value k it checks the remainder of the array for extra k, k+1 or k-1, sums their counts and checks against
	 * longest subsequence length found so far.
	 */
	public int harmonicLengthBruteForce(int[] nums) {
		int maxlength = 0;
		
		for (int i = 0; i < nums.length && nums.length - i > maxlength; i++) {
			int kcount = 1;
			int kplus1count = 0;
			int kminus1count = 0;
			
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == nums[i]) kcount++;
				else if (nums[j] == nums[i] + 1) kplus1count++;
				else if (nums[j] == nums[i] - 1) kminus1count++;
			}
			
			if (kplus1count > 0 && kcount + kplus1count > maxlength) maxlength = kcount + kplus1count;
			if (kminus1count > 0 && kcount + kminus1count > maxlength) maxlength = kcount + kminus1count;
		}
		
		return maxlength;
	}
	
	/*
	 * First sorts the array, then just iterates over it once counting all the subsequences (which if valid, are consecutive) and if any satisfies the harmonic condition,
	 * sums the length of the previous one and the current one, then checks against the maximum length found so far.
	 */
	public int harmonicLengthSorting(int[] nums) {
		int maxlength = 0;
		int count = 1, prevCount = 0;
		
		Arrays.sort(nums);
		
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i-1]) count++;
			else {
				if (prevCount > 0) maxlength = Math.max(maxlength, count + prevCount);
				
				prevCount = nums[i] - nums[i-1] == 1 ? count : 0;
				count = 1;
			}
		}
		
		if (prevCount > 0) maxlength = Math.max(maxlength, count + prevCount);
		
		return maxlength;
	}
	
	/*
	 * Inserts each value into a map, along with their respective counts, then iterates over the map and sums the counts of each value pairs that satisfy the harmonic condition 
	 * and checks against the maximum length found so far.
	 */
	public int harmonicLengthHashMap(int[] nums) {
		int maxlength = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int num : nums)
			map.put(num, map.getOrDefault(num, 0) + 1);
		
		for (int key : map.keySet()) 
			if (map.containsKey(key+1)) maxlength = Math.max(maxlength, map.get(key) + map.get(key+1));
		
		return maxlength;
	}
	
	/*
	 * Same as the previous method, but checks for new maximum lengths at the same time as it inserts new values into the map, doing everything in just one single loop.
	 */
	public int harmonicLengthHashMapSingleLoop(int[] nums) {
		int maxlength = 0;
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
			if (map.containsKey(num+1)) maxlength = Math.max(maxlength, map.get(num) + map.get(num+1));
			if (map.containsKey(num-1)) maxlength = Math.max(maxlength, map.get(num) + map.get(num-1));
		}
		
		return maxlength;
	}
	
	// Driver method
	public static void main(String[] args) {
		int[] example = new int[] {2, 1, 3, 2, 3, 4, 5, 4, 1, 1};
		
		HarmonicSubsequence hs = new HarmonicSubsequence();

		System.out.println("Brute force: " + hs.harmonicLengthBruteForce(example));
		System.out.println("Sorting: " + hs.harmonicLengthSorting(example));
		System.out.println("Hash map: " + hs.harmonicLengthHashMap(example));
		System.out.println("Hash map single loop: " + hs.harmonicLengthHashMapSingleLoop(example));
	}
}
