package com.leetcode.arrays;

public class MaxProfit {
	public int maxProfit(int[] prices) {
		int profit = 0;
		
		for (int i = 0; i < prices.length - 1; i++) 
			if (prices[i] < prices[i+1]) profit += prices[i+1] - prices[i];
		
		return profit;
	}
	
	public static void main(String args[]) {
		int[] example0 = new int[] {7, 1, 5, 3, 6, 4};
		int[] example1 = new int[] {0};
		int[] example2 = new int[] {};
		int[] example3 = new int[] {1, 2, 3, 4, 5};
		int[] example4 = new int[] {5, 4, 3, 2, 1};
		int[] example5 = new int[] {5, 4, 3, 2, 1, 6};
		int[] example6 = new int[] {5, 4, 3, 2, 1, 6, 7};
		int[][] examples = new int[][] {example0, example1, example2, example3, example4, example5, example6};
		
		MaxProfit solution = new MaxProfit();
		
		for (int[] example : examples) {
			System.out.print("[");
			
			for (int i = 0; i < example.length; i++) {
				System.out.print(example[i]);
				
				if(i < example.length - 1) System.out.print(", ");
			}
			
			System.out.println("] maxProfit: " + solution.maxProfit(example));
		}
	}
}
