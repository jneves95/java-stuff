package com.leetcode.trees;

import java.util.ArrayList;
import java.util.List;

/*
 * LeetCode 9 March 2021 Challenge
 * 
 * Given a binary tree, adds a row of nodes with value V at depth D
 */
public class AddOneRow {
	
	public TreeNode addOneRow(TreeNode root, int v, int d) {
		// Get nodes of depth D
		List<TreeNode> nodes = new ArrayList<>();
		
		// If inserting at root level
		if (d == 1) {
			TreeNode newRoot = new TreeNode(v, root, null);
			return newRoot;
		}
		
		int depth = 1;
		nodes.add(root);
		while (depth < d - 1) {
			List<TreeNode> nextRow = new ArrayList<>();
			for (TreeNode n : nodes) {
				if (n.left != null) nextRow.add(n.left);
				if (n.right != null) nextRow.add(n.right);
			}
			depth++;
			nodes = nextRow;
		}
		
		// Insert new row of nodes
		for (TreeNode n : nodes) {
			TreeNode left = new TreeNode(v, n.left, null);
			TreeNode right = new TreeNode(v, null, n.right);
			n.left = left;
			n.right = right;
		}
		
		return root;
	}

	

	public static void main(String[] args) {
		AddOneRow aor = new AddOneRow();
		TreeNode a = new TreeNode(4);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(6);
		TreeNode d = new TreeNode(3);
		TreeNode e = new TreeNode(1);
		TreeNode f = new TreeNode(5);
		TreeNode g = new TreeNode(8);
		
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		f.right = g;
		
		a.simplePrint();
		aor.addOneRow(a, 9, 2);
		a.simplePrint();
	}
}	
