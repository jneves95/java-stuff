package com.leetcode.trees;

/*
 * Converts a valid binary search tree into a greater tree, where all values are replaced with their original value plus the same of all greater values.
 * 
 * -- We do this by using Reverse In-order Traversal and keeping a global variable for the total sum of the nodes traversed so far.
 */
public class ConvertBST {
	private int sum = 0;
	private TreeNode innerConvertBST(TreeNode root) {
		if (root == null) return null;
		
		root.right = innerConvertBST(root.right);
		sum = root.val += sum;
		root.left = innerConvertBST(root.left);
		
		return root;
	}
	
	public TreeNode convertBST(TreeNode root) {
		sum = 0;
		return innerConvertBST(root);
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
		e.right = h;
		g.right = i;
		
		ConvertBST cbst = new ConvertBST();
		
		cbst.convertBST(a);

		System.out.println("a: " + a.val);
		System.out.println("b: " + b.val);
		System.out.println("c: " + c.val);
		System.out.println("d: " + d.val);
		System.out.println("e: " + e.val);
		System.out.println("f: " + f.val);
		System.out.println("g: " + g.val);
		System.out.println("h: " + h.val);
		System.out.println("i: " + i.val);
	}

}
