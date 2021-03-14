package com.leetcode.arrays;

/*
 * Given a matrix where each row is filled with 1s and 0s, 1s representing soldiers and 0s representing civilians, 
 * where rows always start with 1s and end with 0s, and they are not mixed, returns the weakest K rows:
 * Row I is weaker than row J if I has less soldiers than J, or if equal number of soldiers, when I has an index lower than J.
 * 
 * We did this by creating ourselves a specific class to store both the number of soldiers and the original index of each row, implementing the Comparable interface
 * so we can sort (stable) the rows while preserving the original relative order of the indices. Then we return the first K indices as the result.
 * 
 */
import java.util.Arrays;

public class WeakestRows {
	// Class row to store original index and number of soldiers for stable sorting
	static class Row implements Comparable<Row> {
		int index;
		int soldiers;
		
		Row(int index, int soldiers) {
			this.index = index;
			this.soldiers = soldiers;
		}

		@Override
		public int compareTo(Row o) {
			return this.soldiers == o.soldiers ? this.index - o.index : this.soldiers - o.soldiers;
		}
	}
	
	public int[] weakestRows(int[][] grid, int k) {
		Row[] rows = new Row[grid.length];
		int[] result = new int[k];
		
		// Initialize row objects from grid
		for (int i = 0; i < grid.length; i++) {
			int count = 0;
			for (int j = 0; j < grid[i].length; j++) {
				if (grid[i][j] == 0) break;
				count++;
			}
			rows[i] = new Row(i, count);
		}

		Arrays.sort(rows);
		
		// Fill result array
		for (int i = 0; i < k; i++) {
			result[i] = rows[i].index;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		WeakestRows wr = new WeakestRows();
		
		int[][] grid = {{1,1,0,0,0}, {1,1,1,1,0}, {1,0,0,0,0}, {1,1,0,0,0}, {1,1,1,1,1}};
		
		int[] result = wr.weakestRows(grid, 3);
		
		System.out.print("[");
		
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]);
			if (i < result.length - 1) System.out.print(", ");
		}
		
		System.out.println("]");
	}
}
