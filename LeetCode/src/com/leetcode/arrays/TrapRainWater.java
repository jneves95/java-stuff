package com.leetcode.arrays;

/*
 * LeetCode 42
 * Given n non-negative integers representing an elevation map, where each bar is width 1, calculates how many units of water it can trap.
 */
public class TrapRainWater {
	
	// My makeshift method
	public int trap(int[] height) {
		int water = 0, possibleWater = 0;
		int wall = 0, floor = 0;
		
		for (int i = 0; i < height.length; i++) {
			// If we are climbing down from our most recent wall, store corresponding water height
			if (height[i] < wall) {
				possibleWater += wall - height[i];
			}
			
			// If we climb up, save permanently part of the water we got so far
			if (height[i] > floor) {
				// To calculate the amount of water we can save, we have to look back until we climb up again, until we reach the height of this new column
				for (int j = i - 1; j >= 0; j--) {
					if (height[j] > floor) {
						// Calculate volume of water to add
						int w = (i - j - 1) * (Math.min(height[j], height[i]) - floor);
						
						// Take volume from water stored so far and save it permanently
						if (w > possibleWater) {
							water += possibleWater;
							possibleWater = 0;
						}
						else {
							water += w;
							possibleWater -= w;
						}
						
						// If we hit our wall, we don't need to check further back
						if (height[j] >= height[i]) break;
						
						// Update floor
						floor = height[j];
					}
				}
			}
			
			// If we find a bigger wall, update wall and remove any stored water
			if (height[i] > wall) {
				wall = height[i];
				possibleWater = 0;
			}
			
			// Update floor
			floor = height[i];
		}
		
		return water;
	}
	
	// Easier brute force method
	// 		-> Because we can calculate water for each column by finding out the minimum height of the maximum heights to the left and right and subtracting the floor
	public int trapBrute(int[] height) {
		int water = 0;
		
		for (int i = 0; i < height.length; i++) {
			int leftMax = 0;
			int rightMax = 0;
			for (int left = i - 1; left >= 0; left--) {
				if (height[left] > leftMax) leftMax = height[left];
			}
			
			for (int right = i + 1;  right < height.length; right++) {
				if (height[right] > rightMax) rightMax = height[right];
			}
			
			int w = Math.min(leftMax, rightMax) - height[i];
			if (w > 0) water += w;
		}
		
		return water;
	}
	
	// Easier dynamic programming, mounting on the brute force concept
	// 		-> Because we can calculate all maximum heights to the left and right of any point ahead of calculating the trapped water, 
	// 		this allows for 3 simple iterations over the array.
	public int trapDynamic(int[] height) {
		int[] leftMax = new int[height.length];
		int[] rightMax = new int[height.length];
		int water = 0;
		
		for (int i = 0, max = 0; i < height.length; i++) {
			if (height[i] > max) max = height[i];
			rightMax[i] = max;
		}
		
		for (int i = height.length - 1, max = 0; i >= 0; i--) {
			if (height[i] > max) max = height[i];
			leftMax[i] = max;
		}
		
		for (int i = 0; i < height.length; i++) {
			int w = Math.min(leftMax[i], rightMax[i]) - height[i];
			if (w > 0) water += w;
		}
		
		return water;
	}

	public static void main(String[] args) {
		TrapRainWater trw = new TrapRainWater();
		int[] height = {5,4,3,2,1,1,1,3,4,4,5};
		
		System.out.println("My dumb method: " + trw.trap(height));
		System.out.println("Brute force simple: " + trw.trapBrute(height));
		System.out.println("Dynamic programming: " + trw.trapDynamic(height));
	}

}
