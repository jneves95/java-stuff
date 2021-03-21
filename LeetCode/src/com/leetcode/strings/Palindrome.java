package com.leetcode.strings;

/*
 * Given a string S, determines if it's a valid palindrome considering only 
 * alphanumeric characters and ignoring case.
 */
public class Palindrome {
	
	public static boolean validPalindrome(String s) {
		for (int i = 0, j = s.length() - 1; i < j; ) {
			if (!Character.isLetterOrDigit(s.charAt(i))) {
				i++;
				continue;
			}
			else if (!Character.isLetterOrDigit(s.charAt(j))) {
				j--;
				continue;
			}
			else if (Character.toLowerCase(s.charAt(i)) == Character.toLowerCase(s.charAt(j))) {
				i++;
				j--;
			}
			else return false;
		}
		
		return true;
	}

	public static boolean validPalindromeStringBuilder(String s) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < s.length(); i++) {
			if (Character.isLetterOrDigit(s.charAt(i))) {
				sb.append(Character.toLowerCase(s.charAt(i)));
			}
		}
		
		String a = sb.toString();
		String b = sb.reverse().toString();
		
		return a.equals(b);
	}
	
	public static void main(String[] args) {
		String test1 = "A man, a plan, a canal: Panama";
		String test2 = "., ''b,  e.e,>:_ b,";

		System.out.println(validPalindrome(test1));
		System.out.println(validPalindrome(test2));
	}

}
