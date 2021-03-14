package com.leetcode.arrays;

/*
 * February 17 2021 challenge 
 * 
 * For an array of N non-negative integers representing the heights of lines that can form between each other a container to store water, returns the maximum volume of water 
 * that can be stored.
 * 
 */
public class ContainerMostWater {
	// The naive brute-force approach is to find, for every line I, every line J where J > I that can store the most water. This takes O(n^2) time.
	public int maxAreaNaive(int[] height) {
		int max = 0;
		
		for (int i = 0; i < height.length; i++) {
			for (int j = i + 1; j < height.length; j++) {
				int area = Math.min(height[i], height[j]) * (j - i);
				max = Math.max(max, area);
			}
		}
		
		return max;
	}
	
	// The dynamic approach is to have two iterators, one starting at the beginning of the array and the other at the end, and then have them go in until they meet each other, 
	// updating the max volume in between.
	public int maxAreaDynamic(int[] height) {
		int max = 0;
		
		for (int i = 0, j = height.length - 1; i < j;) {
			int area = Math.min(height[i], height[j]) * (j - i);
			max = Math.max(max, area);
			
			if (height[i] > height[j]) {
				j--;
			}
			else {
				i++;
			}
		}
		
		return max;
	}

	public static void main(String[] args) {
		ContainerMostWater cmw = new ContainerMostWater();
		
		int[] height = new int[] {1,8,6,2,5,4,8,3,7};

		System.out.println("Naive: " + cmw.maxAreaNaive(height));
		System.out.println("Dynamic: " + cmw.maxAreaDynamic(height));
	}

}
