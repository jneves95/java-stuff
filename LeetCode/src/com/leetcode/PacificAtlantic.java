package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PacificAtlantic {
	static class Pair {
		int first;
		int second;
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}
		
		List<Integer> toList() {
			List<Integer> pair = new ArrayList<>();
			pair.add(first);
			pair.add(second);
			return pair;
		}
	}
	
	public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) return new ArrayList<>();
		
		List<List<Integer>> ans = new ArrayList<>();
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		// Matrix to store if a certain cell is reached by any ocean
		// (0 - not reached, 1 - reached by Atlantic, 2 - reached by Pacific, 3 - reached by both)
		int[][] reach = new int[m][n];
		
		// Water flow direction
		int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
		
		// BFS queue
		Queue<Pair> oceanQue = new LinkedList<>();

		// Initialize queue for Pacific ocean
		for (int i = 0; i < m; i++) {
			oceanQue.add(new Pair(i, 0));
		}
		
		for (int i = 0; i < n; i++) {
			oceanQue.add(new Pair(0, i));
		}
		
		while (!oceanQue.isEmpty()) {
			Pair p = oceanQue.poll();
			int x = p.first;
			int y = p.second;
			
			reach[x][y] = 1;
			
			// Add adjacent cells
			for(int[] dir : directions) {
				int newX = x + dir[0];
				int newY = y + dir[1];
				
				// Check if valid coordinates
				if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
					if (reach[newX][newY] == 0 && matrix[x][y] <= matrix[newX][newY]) {	// Add if not reached yet and reachable
						oceanQue.add(new Pair(newX, newY));
					}
				}
			}
		}
		
		// Initialize queue for Atlantic ocean
		for (int i = 0; i < n; i++) {
			oceanQue.add(new Pair(m-1, i));
		}
		
		for (int i = 0; i < m; i++) {
			oceanQue.add(new Pair(i, n-1));
		}
		
		while (!oceanQue.isEmpty()) {
			Pair p = oceanQue.poll();
			int x = p.first;
			int y = p.second;
			
			if (reach[x][y] == 1) {	// Already reached by pacific ocean
				reach[x][y] = 3;
				ans.add(p.toList());
			}
			else {
				reach[x][y] = 2;
			}
			
			// Add adjacent cells
			for(int[] dir : directions) {
				int newX = x + dir[0];
				int newY = y + dir[1];
				
				// Check if valid coordinates
				if (newX >= 0 && newX < m && newY >= 0 && newY < n) {
					if (reach[newX][newY] < 2 && matrix[x][y] <= matrix[newX][newY]) {	// Add if not reached yet by this ocean
						oceanQue.add(new Pair(newX, newY));
					}
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		int[][] test = {{1, 2, 2, 3, 5}, 
						{3, 2, 3, 4, 4}, 
						{2, 4, 5, 3, 1}, 
						{6, 7, 1, 4, 5}, 
						{5, 1, 1, 2, 4}};
		
		List<List<Integer>> res = pacificAtlantic(test);
		
		for (List<Integer> pair : res) {
			System.out.print("[" + pair.get(0) + ", " + pair.get(1) + "] ");
		}
	}

}
