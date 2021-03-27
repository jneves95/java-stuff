package com.leetcode.random;

/*
 * Given two integers, calculates the number of bits that differ from one another in their bit representation.
 * Example: a = 5 (0 1 0 1)
 * 			b = 2 (0 0 1 0)
 * 				     ^ ^ ^
 * 			output = 3 because they differ in 3 bits
 * 
 * The easiest way to do this is by doing a XOR b, and counting the number of 1 bits in the result
 */
public class HammingDistance {
	public int hammingDistance(int a, int b) {
		int c = a ^ b;
		int count = 0;
		int mask = 1;
		for (int i = 0; i < 32; i++) {
			if ((mask & c) != 0) {
				count++;
				mask <<= 1;
			}
		}
			
		return count;
	}
	
	// Driver method
	public static void main(String[] args) {
		int a = 5, b = 2;
		
		HammingDistance hd = new HammingDistance();
		
		System.out.println(hd.hammingDistance(a, b));
	}
}
