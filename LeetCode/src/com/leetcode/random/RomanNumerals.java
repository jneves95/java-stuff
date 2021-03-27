package com.leetcode.random;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {
	
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		
		int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
		String[] symb = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		
		while (num > 0) {
			for (int i = 0; i < nums.length; i++) {
				if (num >= nums[i]) {
					sb.append(symb[i]);
					num -= nums[i];
					break;
				}
			}
		}
		
		return sb.toString();
	}

	public int romanToInt(String s) {
		int result = 0;
		
		char[] arr = s.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {			
			switch(arr[i]) {
			case 'I':
				if (i < arr.length - 1) {
					switch(arr[i+1]) {
					case 'V':
						result += 4;
						i++;
						break;
					case 'X':
						result += 9;
						i++;
						break;
					default:
						result += 1;
					}
				}
				else {
					result += 1;
				}
				break;
			case 'V':
				result += 5;
				break;
			case 'X':
				if (i < arr.length - 1) {
					switch(arr[i+1]) {
					case 'L':
						result += 40;
						i++;
						break;
					case 'C':
						result += 90;
						i++;
						break;
					default:
						result += 10;
					}
				}
				else {
					result += 10;
				}
				break;
			case 'L':
				result += 50;
				break;
			case 'C':
				if (i < arr.length - 1) {
					switch(arr[i+1]) {
					case 'D':
						result += 400;
						i++;
						break;
					case 'M':
						result += 900;
						i++;
						break;
					default:
						result += 100;
					}
				}
				else {
					result += 100;
				}
				break;
			case 'D':
				result += 500;
				break;
			case 'M':
				result += 1000;
				break;
			default:
				
			}
		}
		
		return result;
	}
	
	public int romanToInt2(String s) {
		int result = 0;
		
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		
		char[] arr = s.toCharArray();
		int prev = 1;
				
		for (int i = arr.length - 1; i >= 0; i--) {
			int next = map.get(arr[i]);
			result += next < prev ? -next : next;
			prev = next;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		RomanNumerals rn = new RomanNumerals();
		
		String s1 = "IV";
		String s2 = "XVII";
		String s3 = "XIX";
		String s4 = "LVIII";
		String s5 = "MCMXCIV";
		
		String[] strs = {s1, s2, s3, s4, s5};
		
		for (String s : strs) {
			System.out.println(s + ": " + rn.romanToInt2(s));
		}
		
		System.out.println(rn.intToRoman(1994));
	}

}
