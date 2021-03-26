package com.leetcode.strings;

import java.util.ArrayList;
import java.util.List;


/**
 * LeetCode 26 March 2021 challenge
 *
 * A word 's' is a subset of another word 't' if all characters of 's' occur in 't'.
 * Given a list of words A and a list of words B, a word is considered Universal if all words in B are subsets of it.
 * Return all universal words.
 */
public class WordSubsets {

    // The brute-force approach would be to check, for every word in A, if all words in B are subsets of it.
    // A more efficient approach is to traverse through all words in B and keep a count of all characters that occur, not accumulating overlaps.
    // Then we can traverse through all words in A and just match them against this counter.

    public List<String> wordSubsets(List<String> A, List<String> B) {
        List<String> univ = new ArrayList<>();

        int[] univCount = new int[26];  // Keeps the maximum number of times a letter occurs in a word of B
        int total = 0;  // The total number of letters needed to match against a word of A

        for (String b : B) {
            int[] bCount = new int[26];

            for (char c : b.toCharArray()) {
                int i = c - 'a';
                if (++bCount[i] > univCount[i]) {
                    univCount[i]++;
                    total++;
                }
            }
        }

        // For word in A to be universal, it has to contain all characters in our universal counter
        for (String a : A) {
            int[] aCount = new int[26];
            int matches = 0;

            for (char c : a.toCharArray()) {
                int i = c - 'a';
                if (univCount[i] > aCount[i]) {
                    aCount[i]++;
                    matches++;
                }

                if (matches == total) {     // Found a universal word, don't need to check the rest of the string
                    univ.add(a);
                    break;
                }
            }
        }

        return univ;
    }

    public static void main(String[] args) {

    }
}
