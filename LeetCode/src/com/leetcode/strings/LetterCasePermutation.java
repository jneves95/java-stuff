package com.leetcode.strings;

/*
 * Given a string S, containing either letters or numbers, returns the total permutations possible for a string where each letter can be lower-case or upper-case.
 * Example:
 * S = "a1b", output = ["a1b", "A1b", "a1B", "A1B"]
 * 
 * We do this by iterating over the original string, and for every string that we have already formed, we change every new character to lower/upper-case, forming a new string.
 * 
 * The number of strings in the result will be 2^n, for n = number of letter characters in S.
 */

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
	public List<String> letterCasePermutation(String s) {
		List<String> strings = new ArrayList<>();
		strings.add(s);
		
		char[] sArray = s.toCharArray();
		
		for (int i = 0; i < sArray.length; i++) {
			if ((sArray[i] >= 'A' && sArray[i] <= 'Z') || (sArray[i] >= 'a' && sArray[i] <= 'z')) {
				List<String> newStrings = new ArrayList<>();
				
				for (String str : strings) {
					StringBuilder sb = new StringBuilder(str);
					
					// We only need to change case on this specific char and add this string, the other permutation is already on the list
					char c = sArray[i] <= 'Z' ? (char) (sArray[i] + 32) : (char) (sArray[i] - 32);
					sb.setCharAt(i, c);
					
					newStrings.add(sb.toString());
				}
				
				strings.addAll(newStrings);
			}
		}
		
		return strings;
	}
	
	public static void main(String[] args) {
		LetterCasePermutation lcp = new LetterCasePermutation();
		
		List<String> strings = lcp.letterCasePermutation("");
		
		for (String s : strings) {
			System.out.println("\"" + s + "\"");
		}
	}
}
	