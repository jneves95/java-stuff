package com.leetcode.strings;

public class ReverseString {
	public void reverseString(char[] s) {
		for (int i = 0, j = s.length - 1; i < j; i++, j--) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
		}
	}

	public static void main(String[] args) {
		String example = "Hello";
		char[] s = example.toCharArray();
		
		ReverseString rs = new ReverseString();
		rs.reverseString(s);
		
		for (char c : s)
			System.out.print(c);
	}

}
