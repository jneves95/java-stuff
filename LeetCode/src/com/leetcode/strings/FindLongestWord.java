package com.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/* 
 * LeetCode February 22 2021 challenge
 * 
 * Given a string and a string dictionary, returns the longest string from the dictionary that can be found in the given string, by removing characters from said string, if needed.
 * 
 */
public class FindLongestWord {
	/*
	 * First we create a helper function that checks if a string S is a subsequence of another string T
	 */
	public boolean isSubsequence(String s, String t) {
		int i = 0, j = 0;
		while (i < t.length() && j < s.length()) {
			if (t.charAt(i) == s.charAt(j)) {
				j++;
			}
			i++;
		}
		
		return j == s.length();
	}
	
	public String findLongestWord(String s, List<String> d) {
		/*
		 * We can check for each string if it is a subsequence, and if true, check it against the previously matched strings to see if it's longer or comes before it
		 */
//		String result = "";
//		for (String str : d) {
//			if (isSubsequence(str, s) && (str.length() > result.length() || (str.length() == result.length() && str.compareTo(result) < 0))) {
//				result = str;
//			}
//		}
		
		/*
		 * Or even better, we can sort the list using a custom comparator, so we sort longer strings first, and then lexicographically, and then just return the first matched 
		 * subsequence
		 */
		d.sort((s1, s2) -> s1.length() != s2.length() ? s2.length() - s1.length() : s1.compareTo(s2));
		
		for (String str : d) {
			if (isSubsequence(str, s)) return str;
		}
		
		return "";
	}
	
	
	public String findLongestWord2(String s, List<String> d) {
		String ans = "";
		
		for (String str : d) {
			if (str.length() > ans.length()) {
				ans = str;
			}
			else if (str.length() == ans.length() && str.compareTo(ans) < 0) {
				ans = str;
			}
		}
		
		return "";
	}
	
	public static void main(String[] args) {
		FindLongestWord flw = new FindLongestWord();
		String s = "bab";
		List<String> dict = new ArrayList<>();
		dict.add("b");
		dict.add("ab");
		dict.add("ba");
		dict.add("a");
		
		System.out.println(flw.findLongestWord(s, dict));
	}

}
