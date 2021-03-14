package com.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

/*
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

	public int scoreParentheses(String s) {
		if (s.isBlank()) return 1;
		if (s.length() > 1) {
			if (s.charAt(0) == '(' && s.charAt(1) == '(') {
				return 2 * scoreParentheses(s.substring(1));
			}
			else if (s.charAt(0) == ')' && s.charAt(1) == '(') {
				return 1 + scoreParentheses(s.substring(1));
			}
			else {
				return scoreParentheses(s.substring(1));
			}
		}
		else return 1;
	}
	
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
	
	public static void main(String[] args) {
		ScoreParentheses sp = new ScoreParentheses();
		String s = "(()(()))(()())";
		
		System.out.println(sp.scoreParenthesesTree(s));
	}

}
