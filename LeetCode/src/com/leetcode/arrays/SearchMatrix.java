package com.leetcode.arrays;

/*
 * Given a matrix where each row and column is sorted ascendingly, verifies whether a given integer is in said matrix.
 * 
 * We cannot employ a binary search because we have no way of halving the search boundaries while guaranteeing our target is in the half we want.
 * 
 * So we can iterate over the matrix in a right-bottom direction when the target value is bigger, and left-bottom when it is smaller.
 */

public class SearchMatrix {

	public boolean searchMatrix(int[][] matrix, int target) {
		int row = 0;
		int col = matrix[0].length - 1;
		
		while (row < matrix.length && col >= 0) {
			if (matrix[row][col] == target) return true;
			else if (matrix[row][col] > target) {
				col--;
			}
			else {
				row++;
			}
		}
		
		return false;
	}
	
	/* 
	 * Iterative brute-force approach
	 */
	public boolean searchMatrixBrute(int[][] matrix, int target) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j] == target) return true;
			}
		}
		
		return false;
	}
	
	/*
	 * Recursive search for conceptual purposes, not efficient
	 */
	
	public boolean searchRecursive(int[][] matrix, int target, int iMin, int iMax, int jMin, int jMax) {
		int iMid = iMin + (iMax - iMin) / 2;
		int jMid = jMin + (jMax - jMin) / 2;
		int midValue = matrix[iMid][jMid];
		
		if (midValue == target) {
			print(matrix, iMid, jMid);
			return true;
		}

		if (midValue > target) {
			boolean m1 = iMin < iMid && jMin < jMid ? searchRecursive(matrix, target, iMin, iMid-1, jMin, jMid-1) : false;
			boolean m2 = iMin < iMid ? searchRecursive(matrix, target, iMin, iMid-1, jMid, jMax) : false;
			boolean m3 = jMin < jMid ? searchRecursive(matrix, target, iMid, iMax, jMin, jMid-1) : false;
			return m1 || m2 || m3;
		}
		else {
			boolean m1 = iMid < iMax && jMid < jMax ? searchRecursive(matrix, target, iMid+1, iMax, jMid+1, jMax) : false;
			boolean m2 = iMid < iMax ? searchRecursive(matrix, target, iMid+1, iMax, jMin, jMid) : false;
			boolean m3 = jMid < jMax ? searchRecursive(matrix, target, iMin, iMid, jMid+1, jMax) : false;
			return m1 || m2 || m3;
		}
	}
	
	
	public void print(int[][] matrix, int i, int j) {
		for (int k = 0; k < matrix.length; k++) {
			for (int l = 0; l < matrix[k].length; l++) {
				if (k == i && j == l) System.out.print("(");
				System.out.print(matrix[k][l]);
				if (k == i && j == l) System.out.print(")");
				if (l < matrix[k].length - 1) System.out.print(", ");
			}
			System.out.println();
		}
	}
	
	public void print(int[][] matrix) {
		print(matrix, -1, -1);
	}
	
	public static void main(String[] args) {
		SearchMatrix sm = new SearchMatrix();
		int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
		
		for (int i = 0; i < 30; i++) {
			System.out.println((i+1) + ": " + sm.searchMatrix(matrix, i+1));
		}
	}

}
