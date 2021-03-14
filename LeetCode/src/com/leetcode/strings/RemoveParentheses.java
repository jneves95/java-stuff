package com.leetcode.strings;


/*
 * LeetCode February 19 2021 challenge
 * 
 * Given a string S, removes the minimum number of parentheses to make it a valid string, that is, with valid nesting only,
 * no opening parentheses without corresponding closing parentheses.
 */
public class RemoveParentheses {

	public String minRemove(String s) {
		StringBuilder sb = new StringBuilder(s);
		
		// Number of opening parentheses without a corresponding closing parentheses so far
		int open = 0; 
		
		// Iterate over the string and calculate number of open parentheses that weren't closed
		for (int i = 0; i < sb.length(); i++) {
			char c = sb.charAt(i);
			if (c == ')' && open == 0) {
				sb.deleteCharAt(i);	// Also removes invalid closing parentheses
				i--;
			}
			else if (c == '(') {
				open++;
			}
			else if (c == ')') {
				open--;
			}
		}
		
		// If there were any parentheses that weren't closed, iterate backwards to find and remove them until the string is valid
		for (int i = sb.length() - 1; i >= 0 && open > 0; i--) {
			if (sb.charAt(i) == '(') {
				sb.deleteCharAt(i);
				open--;
			}
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		RemoveParentheses rp = new RemoveParentheses();
		
		String s0 = "(a(b(c)d)";
		String s1 = "))((";
		String s2 = ")leet(co(d)))()e)";
		String[] strs = {s0, s1, s2};
		
		for (String s : strs) {
			System.out.println(rp.minRemove(s));
		}
	}

}
