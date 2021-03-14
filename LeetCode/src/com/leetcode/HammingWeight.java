package com.leetcode;


public class HammingWeight {
	public int hammingWeight(int n) {
		char[] bin = Integer.toBinaryString(n).toCharArray();
		int bits = 0;
		
		for (char ch : bin) 
			if (ch == '1') bits++;
		
		return bits;
	}
	
	public int hammingWeightMask(int n) {
		int bits = 0;
	    int mask = 1;
	    
	    for (int i = 0; i < 32; i++) {
	        if ((n & mask) != 0) {
	            bits++;
	        }
	        mask <<= 1;
	    }
	    
	    return bits;
	}
	
	public int hammingWeightShift(int n) {
		int bits = 0;
		
		while (n != 0) {
			bits += (n & 1);
			n >>>= 1;
		}
		
		return bits;
	}
	
	public static void main(String[] args) {
		HammingWeight hw = new HammingWeight();
		
		for(int i = -2; i < 16; i++)
			System.out.println(hw.hammingWeight(i) + ", " + hw.hammingWeightMask(i) + ", " + hw.hammingWeightShift(i));
	}
}
