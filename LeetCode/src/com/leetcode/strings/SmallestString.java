package com.leetcode.strings;/*
 * For a given length "n" and a given number "k", returns the lexicographically 
 * smallest lower-case string with length "n" where to each letter corresponds a number 
 * according to its position in the alphabet ('a' = 1, 'b' = 2, ..., 'z' = 26) and 
 * the sum of all letters equals "k".
 * 
 * Example: n = 5, k = 56, result = "aabzz"
 *
 */

/**
 * Given a length N and an integer K, returns an encoding of said integer with length N and where the sum of the character values is K.
 *
 * Examples:
 * n = 1, k = 22 -> ans = "v"
 * n = 5, k = 22 -> ans = "aaaar"
 * n = 5, k = 73 -> ans = "aaszz"
 */
public class SmallestString {
	public String getSmallestString(int n, int k) {
		if (n > k || k > n * 26) return "";
		
		StringBuilder sb = new StringBuilder();
		k -= n;

		while (n > 0) {
			if (k >= 26) {
				sb.append((char) ('a' + 25));
				k -= 25;
			}
			else if (k > 0) {
				sb.append((char) ('a' + k));
				k = 0;
			} 
			else sb.append('a');
			
			n--;
		}

		return sb.reverse().toString();
	}
	
	public static void main(String[] args) {
		int n = 5, k = 73;
		SmallestString ss = new SmallestString();
		
		System.out.println(ss.getSmallestString(n, k));
	}

}
