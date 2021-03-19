package com.leetcode.strings;

/**
 * Given a string composed of only lower-case english characters s and a character c, 
 * returns an array of the same length ans where ans[i] equals the distance to c.
 * 
 * Example: s = "somestring", c = 's'
 * 			ans = [0,1,2,1,0,1,2,3,4,5]
 */
public class ShortestDistanceString {

	public int[] shortestDistance(String s, char c) {
		if (s.length() == 0) return new int[] {};
		char[] chars = s.toCharArray();
		int[] answer = new int[s.length()];
		
		int first = 0;
		while (chars[first] != c && first < chars.length) first++;
		for (int i = first; i >= 0; i--) answer[i] = first - i;
		
		for (int i = first, l = 0; i < chars.length; i++, l++) {
			if (chars[i] == c) {
				for (int j = i - 1, k = 1; j >= 0 && k < answer[j]; j--, k++) {
					answer[j] = k;
				}
				answer[i] = l = 0;
			}
			else answer[i] = l;
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		String example = "loveleetcode";
		char c = 'e';
		
		ShortestDistanceString sds = new ShortestDistanceString();

		int[] answer = sds.shortestDistance(example, c);
		
		System.out.print("[");
		
		for (int i = 0; i < answer.length; i++) {
			System.out.print(answer[i]);
			if (i < answer.length - 1) System.out.print(", ");
		}
		
		System.out.println("]");
	}

}
