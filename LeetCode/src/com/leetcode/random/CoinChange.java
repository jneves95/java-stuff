package com.leetcode.random;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        if (amount <= 0) return 0;
        Arrays.sort(coins);
        return minChangeCached(coins, amount,  new int[amount]);
    }

    /**
     * For this brute-force approach we check every single combination possible until it just exceeds or matches the given amount, and returns the minimum coin count.
     * This generates an exponential amount of subproblems, so it is not very efficient.
     */
    public int minChange(int[] coins, int remaining, int count) {
        if (remaining < 0) return - 1;
        if (remaining == 0) return count;

        int min = Integer.MAX_VALUE;

        for (int i = coins.length - 1; i >= 0; i--) {
            int next = minChange(Arrays.copyOfRange(coins, 0, i + 1), remaining - coins[i], count + 1);
            if (next > 0 && next < min) min = next;
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    /**
     * For this approach we are going to similarly every combination possible but we cache our subproblems so we don't have to check them twice.
     */
    public int minChangeCached(int[] coins, int remaining, int[] count) {
        if (remaining < 0) return -1;
        if (remaining == 0) return 0;

        if (count[remaining - 1] != 0) return count[remaining - 1]; // Check if cached solution
        int min = Integer.MAX_VALUE;

        for (int i = coins.length - 1; i >= 0; i--) {
            int result = minChangeCached(coins, remaining - coins[i], count);
            if (result >= 0 && result < min) min = 1 + result;
        }

        count[remaining - 1] = min == Integer.MAX_VALUE ? -1 : min;
        return count[remaining - 1];
    }

    public static void main(String[] args) {
        CoinChange cc = new CoinChange();
        int[] coins = {186, 419, 83, 408};

        System.out.println(cc.coinChange(coins, 6249));
    }
}
