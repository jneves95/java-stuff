package com.leetcode;

public class NumFriendRequests {
	
	public int numFriendRequests(int[] ages) {
		int requests = 0;
		int[] ageCount = new int[121];
		
		for (int i = 0; i < ages.length; i++) {
			ageCount[ages[i]]++;
		}
		
		for (int b = 0; b < ageCount.length; b++) {
			for (int a = b; a < (b - 7) * 2 && a < ageCount.length; a++) {
				if (a == b) {
					requests += ageCount[a] * (ageCount[b] - 1);
				}
				else {
					requests += ageCount[a] * ageCount[b];
				}
			}
		}
		
		return requests;
	}
	
	public static void main(String[] args) {
		NumFriendRequests nfr = new NumFriendRequests();
		
		int[] ages = new int[] {23,4,76,118,48,88,97,71,112,23,98,21,83,24,85,18,20,53,77,30,99,103,62,117,51,41,46,43,71,88,111,68,99,104,105,40,120,97,108,13,23,32,105,86,74,55,22,84,63,88,80,10,59,47,118,1,83,28,74,1,111,85,99,104,79,19,117,18,20,62,16,3,33,64,62,41,8,34,32,35,92,25,16,55,72,29,17,56,28,110,56,37,112,81,24,62,54,60,109,33};
		
		System.out.println(nfr.numFriendRequests(ages));
	}
}