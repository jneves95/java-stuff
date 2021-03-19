package com.leetcode.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 * Basic tree node for use in binary tree implementations.
 */
public class TreeNode {
		int val;
		TreeNode right;
		TreeNode left;
		TreeNode() {};
		TreeNode(int val) {	this.val = val; }
		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		
		public void print() {
			int maxDepth = maxDepth();
			List<TreeNode> nodes = new ArrayList<>();
			
			int depth = 1;
			nodes.add(this);
			while (depth < maxDepth) {
				// TODO: Print this row
				
				// TODO: Print spacer row / \
				
				// Get next row
				List<TreeNode> nextRow = new ArrayList<>();
				for (TreeNode n : nodes) {
					if (n.left != null) nextRow.add(n.left);
					if (n.right != null) nextRow.add(n.right);
				}
				depth++;
				nodes = nextRow;
			}
		}
		
		public int maxDepth() {
			if (left == null && right == null) return 1;
			else if (right == null) return 1 + left.maxDepth();
			else if (left == null) return 1 + right.maxDepth();
			else return 1 + Math.max(left.maxDepth(), right.maxDepth());
		}
		
		public void simplePrint() {
			Queue<TreeNode> q = new ArrayDeque<TreeNode>();
			q.add(this);
			
			System.out.print("[" + val);
			while (!q.isEmpty()) {
				TreeNode node = q.poll();
				if (node.left != null) {
					System.out.print(" " + node.left.val);
					q.add(node.left);
				}
				else {
					System.out.print(" null");
				}
				if (node.right != null) {
					System.out.print(" " + node.right.val);
					q.add(node.right);
				}
				else {
					System.out.print(" null");
				}
			}
			System.out.println("]");
		}
	}
