package com.leetcode;

import java.util.*;

/*
LeetCode 13 March 2021 Challenge

Given an array of numbers that can be used multiple times to build binary trees, return the maximum number of trees that can be built where each non-leaf node is the product of its children.
 */
public class FactoredBinaryTrees {

    /*
    We know that for every non-leaf node, its children are of lower value, so we can sort the array in ascending order and iterate over it while calculating the number of trees possible for every value.
    For each new value I, the possible trees that can be made with it are itself (single-node tree) and every combination of subtree from values J and K where I = J * K.
    And since we can have 2 trees [I, J, K] and [I, K, J]: numTrees(i) = 1 + numTrees(j) * numTrees(k) + numTrees(k) * numTrees(j) = 1 + 2 * numTrees(j) * numTrees(k)
     */
    public int numFactoredBinaryTrees(int[] arr) {
        long total = 0; // Use long to avoid overflow errors
        Map<Integer, Long> treeCount = new HashMap<>();  // Keep a mapping for every value and its number of possible trees

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            treeCount.put(arr[i], (long) 1); // For every value, we can start by adding its single-node tree
            total++;

            for (int j = 0; j < i; j++) {
                // If I % J = 0, then left child is J and right child is K = I / J
                if (arr[i] % arr[j] == 0 && treeCount.containsKey(arr[i] / arr[j])) {
                    int k = arr[i] / arr[j];
                    long extra = treeCount.get(arr[j]) * treeCount.get(k);
                    treeCount.put(arr[i], treeCount.get(arr[i]) + extra);
                    total = (total + extra) % 1000000007;
                }
            }
        }

        return (int) total;
    }

    public static void main(String[] args) {
        FactoredBinaryTrees fbt = new FactoredBinaryTrees();
        int[] arr = {45,42,2,18,23,1170,12,41,40,9,47,24,33,28,10,32,29,17,46,11,759,37,6,26,21,49,31,14,19,8,13,7,27,22,3,36,34,38,39,30,43,15,4,16,35,25,20,44,5,48};

        System.out.println(fbt.numFactoredBinaryTrees(arr));
    }
}
