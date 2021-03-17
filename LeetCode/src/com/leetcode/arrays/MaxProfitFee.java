package com.leetcode.arrays;

/**
 * LeetCode 16 March 2021 Challenge
 *
 * Given an array of prices of a stock on a given day, returns the maximum profit one can make considering there's a transaction fee for every sell action.
 */
public class MaxProfitFee {
    public int maxProfit(int[] prices, int fee) {
        int profit = 0;
        int min = prices[0];
        int max = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < max - fee && max - min > fee) {
                // Take profit if price fall justifies the fee
                profit += max - min - fee;
                min = max = prices[i];
            }
            else if (prices[i] < min && max - min <= fee){
                // Better buying point
                min = max = prices[i];
            }
            else {
                min = Math.min(min, prices[i]);
                max = Math.max(max, prices[i]);
            }
        }

        // Take final profit if possible
        if (max - min > fee) profit += max - min - fee;

        return profit;
    }

    public static void main(String[] args) {
        MaxProfitFee mpf = new MaxProfitFee();

        int[] example0 = {1, 3, 2, 8, 4, 9};
        int[] example1 = {1, 2, 3, 4, 5, 6};
        int[] example2 = {5, 4, 3, 2, 1, 8};
        int[] example3 = {1};
        int[] example4 = {3, 4, 1, 5, 2, 6};
        int[] example5 = {1, 2};

        int[][] examples = {example0, example1, example2, example3, example4, example5};

        for (int[] example : examples) {
            System.out.println("0:" + mpf.maxProfit(example, 0));
            System.out.println("2:" + mpf.maxProfit(example, 2));
            System.out.println("3:" + mpf.maxProfit(example, 3));
        }
    }
}
