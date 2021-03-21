package com.leetcode.strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * LeetCode February 24 2021 Challenge
 * 
 * Given a balanced parentheses string, computes the score of the string based on the following conditions:
 * 1) "()" has a score of 1.
 * 2) "AB" has a score of A + B where A and B are balanced parentheses strings.
 * 3) "(A)" has a score of 2 * A where A is a balanced parentheses string.	(()(())) = 6
 */
public class ScoreParentheses {
	static class TreeNode {
		TreeNode parent;
		List<TreeNode> children;
		
		TreeNode() {
			children = new ArrayList<>();
		}
		
		TreeNode(TreeNode parent) {
			this.parent = parent;
			children = new ArrayList<>();
		}
		
		// Recursive function to compute score of this tree node
		int computeScore() {
			if (children.isEmpty()) return 1;
			else {
				int childrenScore = 0;
				for (TreeNode c : children) {
					childrenScore += c.computeScore();
				}
				return parent == null ? childrenScore : 2*childrenScore;
			}
		}
	}

	/**
	 * Using tree.
	 */
	public int scoreParenthesesTree(String s) {
		TreeNode root = new TreeNode();
		TreeNode current = root;
		
		// First we generate a tree for the given string
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				// New child node
				TreeNode next = new TreeNode(current);
				current.children.add(next);
				current = next;
			}
			else {
				// Leaf node, go back to parent
				current = current.parent;
			}
		}
		
		// Traverse tree recursively to compute the score
		return root.computeScore();
	}

	/**
	 * Using stack.
	 */
	public int scoreParentheses(String s) {
		int ans = 0;
		Stack<Integer> st = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				st.push(-1);
			}
			else { // ')'
				if (st.peek() == -1) {	// if it closes off an open parentheses, just exchange with 1 - terminal
					st.pop();
					st.push(1);
				}
				else {
					int x = 0;
					while (!st.isEmpty() && st.peek() != -1) { 	// Add up everything following condition 2 until we find the open parentheses
						x += st.pop();
					}
					st.pop();	// remove the open parentheses
					st.push(x * 2);	// multiply by 2 according to condition 3
				}
			}
		}

		// Add up computed substring scores
		while (!st.isEmpty()) {
			ans += st.pop();
		}

		return ans;
	}

	/**
	 * TODO: Using recursion. (right now it is wrong)
	 */
	public int scoreParenthesesR(String s) {
		if (s.isBlank()) return 1;
		if (s.length() > 1) {
			if (s.charAt(0) == '(' && s.charAt(1) == '(') {
				return 2 * scoreParenthesesR(s.substring(1));
			}
			else if (s.charAt(0) == ')' && s.charAt(1) == '(') {
				return 1 + scoreParenthesesR(s.substring(1));
			}
			else {
				return scoreParenthesesR(s.substring(1));
			}
		}
		else return 1;
	}
	
	public static void main(String[] args) {
		ScoreParentheses sp = new ScoreParentheses();
		String s = "(()(()))(()())";

		System.out.println(sp.scoreParenthesesTree(s));
		System.out.println(sp.scoreParentheses(s));
		System.out.println(sp.scoreParenthesesR(s));
	}

}
