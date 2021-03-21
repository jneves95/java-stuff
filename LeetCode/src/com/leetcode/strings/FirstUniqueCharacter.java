package com.leetcode.strings;

/*
 * Given a string, finds the first unique character (non-repeating) and returns its index, 
 * or -1 if it doesn't exist.
 */
public class FirstUniqueCharacter {

	public static int firstUniqueCharacter(String s) {
		int[] indices = new int[26];	// Indices for every character
		
		// Traverse string, save first occurrence of character or invalidate it
		for (int i = 0; i < s.length(); i++) {
			int x = s.charAt(i) -'a';
			indices[x] = indices[x] == 0 ? i + 1 : -1;
		}
		
		int res = Integer.MAX_VALUE;
		
		// Get minimum index
		for (int i = 0; i < 26; i++) {
			if (indices[i] > 0) {
				res = Math.min(res, indices[i]);
			}
		}
		
		return res == Integer.MAX_VALUE ? -1 : res - 1;
	}
	
	public static int firstUniqueCharacter2N(String s) {
		int[] count = new int[26];
		int len = s.length();
		
		for (int i = 0; i < len; i++) {
			count[s.charAt(i) - 'a']++;
		}
		
		for (int i = 0; i < len; i++) {
			if (count[s.charAt(i) - 'a'] == 1) return i;
		}
		
		return -1;
	}
	
	public static void main(String[] args) {
		String s1 = "leetcode";	// 0
		String s2 = "loveleetcode";	// 2
		String s3 = "a";	// 0
		String s4 = "aab";	// 2
		String s5 = "aabb";	// -1
		
		String[] examples = {s1, s2, s3, s4, s5};
		
		for (String s : examples) {
			System.out.println(firstUniqueCharacter2N(s));
		}
	}
}
