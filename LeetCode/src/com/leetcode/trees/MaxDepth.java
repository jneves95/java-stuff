package com.leetcode.trees;

/*
 * Given a binary tree, returns its maximum depth.
 */
public class MaxDepth {
	public int maxDepth(TreeNode root) {
		if (root == null) return 0;
		
		int left = maxDepth(root.left) + 1;
		int right = maxDepth(root.right) + 1;
		
		return Math.max(left, right);
	}
	
	public static void main(String[] args) {
		TreeNode a = new TreeNode(4);
		TreeNode b = new TreeNode(1);
		TreeNode c = new TreeNode(6);
		TreeNode d = new TreeNode(0);
		TreeNode e = new TreeNode(2);
		TreeNode f = new TreeNode(5);
		TreeNode g = new TreeNode(7);
		TreeNode h = new TreeNode(3);
		TreeNode i = new TreeNode(8);
		
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		c.left = f;
		c.right = g;
		g.right = h;
		h.right = i;
		
		MaxDepth md = new MaxDepth();
		
		System.out.println(md.maxDepth(null));
	}
}
