package com.leetcode.strings;

public class ReverseInteger {
	public int reverseInteger(int x) {
		int y = 0;
		while (x != 0) {
			if (y > Integer.MAX_VALUE / 10 || y < Integer.MIN_VALUE / 10) return 0; // this condition verifies that the next append will not overflow the integer limit
			else y *= 10;
			y += x % 10;
			x /= 10;
		}
		return y;
	}

	public static void main(String[] args) {
		int x = -1463847412;
		
		ReverseInteger ri = new ReverseInteger();
		
		System.out.println(ri.reverseInteger(x));
	}

}
