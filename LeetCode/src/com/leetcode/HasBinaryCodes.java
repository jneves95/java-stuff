package com.leetcode;

import java.util.*;

/*
LeetCode 12 March 2021 challenge
 */
public class HasBinaryCodes {
    /*
    Generates a string for every possible code and checks, for each one (brute force), the whole binary string S for a match
     */
    public boolean hasAllCodesBrute(String s, int k) {
        int max = (int) Math.pow(2, k);
        int code = 0;

        while (code < max) {
            // Convert code from integer to binary string
            String temp = Integer.toBinaryString(code);

            // Add leading zeros if needed
            if (temp.length() < k) {
                temp = "0".repeat(k - temp.length()).concat(temp);
            }

            // Check if code is substring
            boolean found = false;
            for (int i = 0; i <= s.length() - k; i++) {
                if (s.substring(i, i+k).equals(temp)) {
                    found = true;
                    break;
                }
            }

            // If we couldn't find this code in string, fail
            if (!found) return false;

            code++;
        }

        return true;
    }

    /*
    Initializes a set of binary strings for each possible code, and for every substring of length K in S, removes it from the set, if it exists.
    Finally it checks if the set is empty, meaning every possible code was found in S.
     */
    public boolean hasAllCodesStringSet(String s, int k) {
        int max = (int) Math.pow(2, k);
        Set<String> codes = new HashSet<>();

        // Initializing string codes
        for (int i = 0; i < max; i++) {
            String code = Integer.toBinaryString(i);

            // Add leading zeros if needed
            if (code.length() < k) {
                code = "0".repeat(k - code.length()).concat(code);
            }

            codes.add(code);
        }

        // Main loop - for every substring of length k, try to match it with one of the codes
        for (int i = 0; i <= s.length() - k; i++) {
            codes.remove(s.substring(i, i+k));
        }

        return codes.isEmpty();
    }

    /*
    For every substring of length K in S, inserts the corresponding integer into a hash set.
    Finally, checks if the set contains all possible binary codes. (2 ^ k)
     */
    public boolean hasAllCodesSet(String s, int k) {
        int max = (int) Math.pow(2, k);
        Set<Integer> subs = new HashSet<>();

        for (int i = 0; i <= s.length() - k; i++) {
            subs.add(Integer.parseInt(s.substring(i, i+k), 2));
        }

        return subs.size() == max;
    }

    /*
    Using an auxiliary boolean table of size 2^k, with a position for every binary code possible, we count down the substrings of length K in S that match a binary code not yet found
    and check it as true on our table.
    Finally, we check that we found all possible binary codes.
     */
    public boolean hasAllCodesBoolTable(String s, int k) {
        int need = 1 << k;
        boolean[] found = new boolean[need];

        for (int i = 0; i <= s.length() - k; i++) {
            int code = Integer.parseInt(s.substring(i, i+k), 2);
            if (!found[code]) {
                found[code] = true;
                need--;
            }
        }

        return need == 0;
    }

    public static void main(String[] args) {
        HasBinaryCodes hbc = new HasBinaryCodes();
        System.out.println(hbc.hasAllCodesSet("1110001011", 3));
        System.out.println(hbc.hasAllCodesBoolTable("1110001011", 3));
    }
}
