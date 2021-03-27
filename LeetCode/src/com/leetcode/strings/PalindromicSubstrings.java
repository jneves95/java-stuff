package com.leetcode.strings;

public class PalindromicSubstrings {

    // Verifies whether a substring is a palindrome
    static boolean isPalindrome(String s, int left, int right) {
        for (int i = left, j = right; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) return false;
        }
        return true;
    }

    // Brute-force approach: Check if every substring is a palindrome
    static int countPalindromesBrute(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (isPalindrome(s, j, i)) count++;
            }
        }

        return count;
    }

    // Dynamic programming approach - start by establishing the base cases for smaller palindromes:
    // A single character is automatically a palindrome, and 2 equal characters are palindromes as well.
    // These two cases can be the center for any other larger palindrome, as long as the end characters are equal.
    // We will use a DP matrix to store whether or not a substring starting from I and ending in J is a palindrome or not, and build from there.
    static int countPalindromes(String s) {
        int count = 0;
        int n = s.length();
        if (n == 0) return 0;

        boolean[][] dp = new boolean[n][n];

        // Single character palindromes
        for (int i = 0; i < n; i++, count++) {
            dp[i][i] = true;
        }

        // Double character palindromes
        for (int i = 0; i < n - 1; i++) {
            dp[i][i+1] = (s.charAt(i) == s.charAt(i+1));
            if (dp[i][i+1]) count++;
        }

        // All other substrings - from length 3 and up
        for (int len = 3; len <= n; len++) {
            for (int i = 0, j = i + len - 1; j < n; i++, j++) {
                dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
                if (dp[i][j]) count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(countPalindromesBrute("aaa"));
        System.out.println(countPalindromesBrute("abc"));
        System.out.println(countPalindromesBrute("aabccbaa"));

        System.out.println(countPalindromes("aaa"));
        System.out.println(countPalindromes("abc"));
        System.out.println(countPalindromes("aabccbaa"));
    }
}
