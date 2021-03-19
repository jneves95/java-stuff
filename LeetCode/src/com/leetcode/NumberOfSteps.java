package com.leetcode;

/**
 * Given a non-negative integer, returns how many steps it takes to be reduced to 0 
 * by dividing by 2 when it is even, and subtracting 1 when it is odd.
 * 
 * Ex: num = 14, 14 -> 7 -> 6 -> 3 -> 2 -> 1 -> 0 (6 steps)
 */
public class NumberOfSteps {
	public int numberOfSteps(int num) {
			int steps = 0;
			
			while (num > 0) {
				if (num % 2 == 0) num /= 2;
				else num--;
				steps++;
			}
			
			return steps;
	}
	
	public static void main(String[] args) {
		NumberOfSteps nos = new NumberOfSteps();
		
		int num = 123;
		
		System.out.println(nos.numberOfSteps(num));
	}

}
