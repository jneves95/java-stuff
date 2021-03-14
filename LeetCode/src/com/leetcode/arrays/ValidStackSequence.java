package com.leetcode.arrays;

import java.util.Stack;

public class ValidStackSequence {

	public boolean validate(int[] pushed, int[] popped) {
		Stack<Integer> st = new Stack<>();
		
		int i = 0;
		int j = 0;
		
		while (i < pushed.length && j < popped.length) {
			if (st.isEmpty() || st.peek() != popped[j]) {
				st.push(pushed[i]);
				i++;
			}
			else {
				st.pop();
				j++;
			}
		}
		
		// When all elements are pushed, check elements left in stack
		while (!st.isEmpty() && j < popped.length) {
			if (st.pop() != popped[j]) return false;
			j++;
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		ValidStackSequence vss = new ValidStackSequence();
		int[] pushed = {1, 2, 3, 4, 5};
		int[] popped = {4, 3, 5, 2, 1};
		
		System.out.println(vss.validate(pushed, popped));
	}

}
