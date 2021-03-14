package com.leetcode.strings;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Given two strings s and t, verifies whether t is an anagram of s.
 * 
 * Three approaches I can think of:
 * 1) Sort characters of both strings and then verify if they're equal.
 * 2) Store the count of each character in two separate hash sets for each string, and then verify if they match in length and character counts.
 * 3) For each character removed from string s, remove the same character in string t, if any character is not found in string t, then it's not an anagram. 
 * 	  When string s is empty, string t should be empty, too.
 */
public class ValidAnagram {
	// Sorting approach - O(n log n) because we use quicksort
	public boolean isValidAnagramSort(String s, String t) {
		if (s.length() != t.length()) return false;
		
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		
		Arrays.sort(sArray);
		Arrays.sort(tArray);
		
		return Arrays.equals(sArray, tArray);
	}
	
	// Swapping approach - O(n^2)
	public boolean isValidAnagramSwap(String s, String t) {
		if (s.length() != t.length()) return false;
		
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		
		for (int i = 0; i < sArray.length; i++) {
			for (int j = i; j < tArray.length; j++) {
				if (tArray[j] == sArray[i]) {
					char temp = tArray[i];
					tArray[i] = tArray[j];
					tArray[j] = temp;
					break;
				}
			}
			if (sArray[i] != tArray[i]) return false;
		}
		
		return true;
	}
	
	// Hash table approach - we can actually use only one hash table and iterate over both strings at the same time - incrementing for characters in first string, 
	// and decrementing for characters in the second string. In the end all counts must be zero for it to be an anagram.
	// Time complexity is O(n) but space complexity is also O(n) because of the hash table
	public boolean isValidAnagramHash(String s, String t) {
		if (s.length() != t.length()) return false;
		
		HashMap<Character, Integer> map = new HashMap<>();
		
		for (int i = 0; i < s.length(); i++) {
			map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
			map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
		}
		
		for (char c : map.keySet()) {
			if (map.get(c) != 0) return false;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		ValidAnagram va = new ValidAnagram();
		
		String s = "aaaaab";
		String t = "baaaaa";
		
		System.out.println("Sorting: " + va.isValidAnagramSort(s, t));
		System.out.println("Swapping: " + va.isValidAnagramSwap(s, t));
		System.out.println("Swapping: " + va.isValidAnagramHash(s, t));
	}

}
