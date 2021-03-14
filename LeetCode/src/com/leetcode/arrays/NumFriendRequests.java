package com.leetcode.arrays;

/*
 * FEITO NA EVA
 * 
 * LeetCode 825
 * Given an array of ages of people from some social network, returns the number of friend requests that can be made between these people, following these conditions:
 * 
 * Person A will NOT friend request person B (B != A) if any of the following conditions are true:

    age[B] <= 0.5 * age[A] + 7  <=>  (age[B] - 7) * 2 <= age[A]
    age[B] > age[A]
    age[B] > 100 && age[A] < 100
    
    From these (NOT) conditions, we can conclude that:
    
    age[A] >= age[B]
    age[A] < (age[B] - 7) * 2

 * For a big enough array (like 20000 elements) it takes too long. One way to go around this, since we can assume ages are between 0 and 120, we can map the counts of each age
 * in a hash table and then validate the key set with the conditions.
 *
 */
public class NumFriendRequests {
	public int numFriendRequests(int[] ages) {
		int requests = 0;
		int[] ageCount = new int[121]; // initialized to 0 by default
		
		
		for (int i = 0; i < ages.length; i++) {
			ageCount[ages[i]] += 1;
		}
		
		for (int b = 0; b < ageCount.length; b++) {
			for (int a = b; a < (b - 7) * 2 && a < ageCount.length; a++) {
				if (ageCount[a] > 0 && ageCount[b] > 0) {
					requests += (a == b) ? ageCount[a] - 1 : ageCount[a];
				}
			}
		}
		
		return requests;
	}
	
	public static void main(String[] args) {
		NumFriendRequests nfr = new NumFriendRequests();
		
		int[] ages = new int[] {16, 16};
		
		System.out.println(nfr.numFriendRequests(ages));
	}

}
