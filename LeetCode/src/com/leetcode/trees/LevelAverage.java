package com.leetcode.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* 
 * LeetCode March 3 2021 Challenge
 * 
 * Given a binary tree, returns an array with the average of the values of each level of the tree
 */
public class LevelAverage {

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> averages = new ArrayList<>();

		// Initialize first level
		Queue<TreeNode> nodes = new LinkedList<>();
		nodes.add(root);

		// Iterate through tree level by level
		while (!nodes.isEmpty()) {
			long sum = 0;	// To avoid overflow errors, we use long for the total sum
			int length = nodes.size();
			
			// Sum up nodes' values and add their children to the next level
			for (int i = 0; i < length; i++) {
				TreeNode node = nodes.poll();
				sum += node.val;
				if (node.left != null) nodes.add(node.left);
				if (node.right != null) nodes.add(node.right);
			}
			
			// Calculate level average
			averages.add((double)sum / length);
		}
		
		return averages;
	}
	
	public static void main(String[] args) {
		LevelAverage la = new LevelAverage();
		
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
		
		List<Double> result = la.averageOfLevels(a);
		for (Double db : result) {
			System.out.print(db + " ");
		}
	}

}
