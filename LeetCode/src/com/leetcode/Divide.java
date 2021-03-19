package com.leetcode;

/*
 * LeetCode February 27 2021 challenge
 * Given two integers, dividend and divisor, return the quotient after dividing the dividend by 
 * the divisor without using multiplication, division or mod operators.
 */
public class Divide {

	public int divide(int dividend, int divisor) {
		// Edge case of overflow
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		
		// Compute sign of quotient
		boolean negative = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
						
		int a = Math.abs(dividend);
		int b = Math.abs(divisor);
		int quotient = 0;
		
		while (a - b >= 0) {
			int n = 1;
			int temp = b;
			
			// Find out how many powers of 2 we can multiply B for while still being able to take it away from A
			while (temp << 1 > 0 && temp << 1 <= a) {	// n can only be 31 because of overflow
				temp <<= 1;	// multiply by 2
				n <<= 1;	
			}
			
			// Add powers of 2 to the quotient
			quotient += n;
			
			// Take away B * 2^n from A
			a -= temp;
		}
		
		return negative ? -quotient : quotient;
	}
	
	public static void main(String[] args) {
		Divide d = new Divide();
		
		System.out.println(d.divide(Integer.MIN_VALUE, -1));
	}

}
