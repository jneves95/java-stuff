package com.leetcode.arrays;

/*
 * For an array of numbers representing the price of a stock over consecutive days, this calculates the maximum profit of a single buy and sell transaction
 */
public class SingleMaxProfit {
	public int maxProfit(int[] prices) {
		int min = Integer.MAX_VALUE;
		int profit = 0;
		
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) 
            	min = prices[i];
            else if (prices[i] - min > profit)
            	profit = prices[i] - min;
        }
        
        return profit;
	}
	
	public static void main(String[] args) {
		int[] example0 = new int[] {7, 1, 5, 3, 6, 4}; // 5
		int[] example1 = new int[] {7, 1, 6, 3, 5, 4}; // 5
		int[] example2 = new int[] {7, 3, 6, 1, 4, 5}; // 4
		int[] example3 = new int[] {7, 6, 5, 4, 3, 2}; // 0
		int[] example4 = new int[] {7, 7, 5, 4, 3, 1}; // 0
		int[] example5 = new int[] {7}; // 0
		
		int[][] examples = new int[][] {example0, example1, example2, example3, example4, example5};
		
		SingleMaxProfit smp = new SingleMaxProfit();
		
		for (int[] example : examples) {
			System.out.println(smp.maxProfit(example));
		}
	}

}
