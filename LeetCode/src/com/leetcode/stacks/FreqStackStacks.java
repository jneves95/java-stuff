package com.leetcode.stacks;

import com.leetcode.stacks.FreqStack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;


/**
 * TODO: Implementation?
 */
public class FreqStackStacks {
	private Map<Integer, Integer> counts;
	private Map<Integer, Stack<Integer>> stacks;
	private int maxFreq;
	
	public FreqStackStacks() {
		maxFreq = 0;
		counts = new HashMap<>();
		stacks = new HashMap<>();
	}
	
	public void push(int val) {
		
	}
	
	public int pop() {
		
		return -1;
	}
	
	public boolean isEmpty() {
		return stacks.isEmpty();
	}
	
	public static void main(String[] args) {
		FreqStack fs = new FreqStack();
		fs.push(4);
		fs.push(5);
		fs.push(7);
		fs.push(5);
		fs.push(7);
		fs.push(4);
		fs.push(4);
		fs.push(5);
		
		while (!fs.isEmpty()) {
			System.out.println(fs.pop());
			// 5 4 4 7 5 7 5 4
		}
	}

}
