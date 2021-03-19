package com.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathBinaryMatrix {
	static class Node {
		int x;
		int y;
		int distance;
		
		Node(int x, int y, int distance) {
			this.x = x;
			this.y = y;
			this.distance = distance;
		}
	}
	
	// Checks whether a certain position is valid in a given square matrix
	public boolean isValid(int size, int i, int j) {
		return (i >= 0 && i < size && j >= 0 && j < size);
	}
	
	public int shortestPathBinaryMatrix(int[][] grid) {
		// Check if first cell is blocked
		if (grid[0][0] == 1) return -1;
		
		// Grid to store visited state of cells
		boolean[][] visited = new boolean[grid.length][grid.length];
		
		// Adjacent grid cells
		int[] adjacentX = {-1, 0, 1, -1, 1, -1, 0, 1};
		int[] adjacentY = {-1, -1, -1, 0, 0, 1, 1, 1};
		
		// Queue for nodes to visit
		Queue<Node> q = new LinkedList<>();
		
		// Add starting node to queue
		q.add(new Node(0, 0, 0));
		visited[0][0] = true;
		
		// Start BFS
		while(!q.isEmpty()) {
			Node curr = q.peek();
			
			// Check if destination cell
			if (curr.x == grid.length - 1 && curr.y == grid.length - 1) {
				return curr.distance + 1;
			}
			
			// Otherwise, remove this cell from queue and add adjacent unblocked and unvisited cells
			q.remove();
			for (int i = 0; i < 8; i++) {
				int row = curr.x + adjacentX[i];
				int col = curr.y + adjacentY[i];
				
				if (isValid(grid.length, row, col) && grid[row][col] == 0 && !visited[row][col]) {
					visited[row][col] = true;
					q.add(new Node(row, col, curr.distance + 1));
				}
			}
		}
		
		return -1;
	}

	public static void main(String[] args) {
		ShortestPathBinaryMatrix spbm = new ShortestPathBinaryMatrix();
		
		int[][] example0 = {{0,1,1}, {0,0,1}, {0,0,0}};
		int[][] example1 = {{0,0,0,0,0}, {1,1,1,0,1}, {1,1,0,1,1}, {1,0,1,1,1}, {0,0,0,0,0}};

		System.out.println(spbm.shortestPathBinaryMatrix(example0));
		System.out.println(spbm.shortestPathBinaryMatrix(example1));
	}

}
