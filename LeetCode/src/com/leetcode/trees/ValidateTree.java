package com.leetcode.trees;

/*
 * Given a binary tree, checks if it is a valid binary search three: 
 * - all values in the left subtree of a node are less than the node's value
 * - all values in the right subtree of a node are greater than the node's value
 * - all left and right subtrees are valid BSTs
 */
public class ValidateTree {
	private Integer prev;
	private boolean innerValidBST(TreeNode root) {
		// An empty tree is a valid BST
		if (root == null) return true;
		
		// Check left subtree
		if (!innerValidBST(root.left)) return false;
		
		// If the current node breaks the ascending order, it is not a valid BST
		if (prev != null && root.val <= prev) return false;
		
		// Update the global variable
		prev = root.val;
		
		// Check right subtree
		return innerValidBST(root.right);
	}
	public boolean isValidBST(TreeNode root) {
		prev = null;
		return innerValidBST(root);
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
		
		ValidateTree vt = new ValidateTree();
		
		System.out.println(vt.isValidBST(a));
	}

}
