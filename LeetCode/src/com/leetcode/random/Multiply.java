package com.leetcode.random;

public class Multiply {
	
	public int multiply(int a, int b) {
		// Compute sign of result
		boolean negative = (a < 0 && b > 0) || (a > 0 && b < 0);
		int result = 0;
		
		for (int i = 0; b > 0; i++) {
			if ((b & 1) > 0) {
				result += a << i;
			}
			b >>= 1;
		}
		
		return negative ? -result : result;
	}

	public static void main(String[] args) {
		Multiply m = new Multiply();
		
		System.out.println(m.multiply(0, -3));
	}

}
