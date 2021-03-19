package com.leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;

/*
 * LeetCode 01 March 2021 Challenge
 */
public class DistributeCandies {
	public int distributeCandies(int[] candyType) {
		Arrays.sort(candyType);
		
		int differentTypes = 1;
		for (int i = 1; i < candyType.length; i++) {
			if (candyType[i] != candyType[i-1]) differentTypes++;
		}
		
		return Math.min(differentTypes, candyType.length / 2);		
	}
	
	public int distributeCandiesHash(int[] candyType) {
		HashSet<Integer> set = new HashSet<>();
		
		for (int i = 0; i < candyType.length; i++) {
			set.add(candyType[i]);
		}
		
		return Math.min(candyType.length/2, set.size());
	}

	public static void main(String[] args) {
		DistributeCandies dc = new DistributeCandies();
		int[] candyType = {6,6,6,6};

		System.out.println(dc.distributeCandies(candyType));
		System.out.println(dc.distributeCandiesHash(candyType));
	}

}
