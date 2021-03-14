package com.leetcode.arrays;
/*
 * Given an array of integers _target_ and an array of arrays of integers _pieces_, checks whether it is possible to form _target by concatenating arrays in _pieces_.
 * - Cannot reorder integers in any _pieces_ array.
 */
public class CanFormArray {
	public boolean canFormArray(int[] target, int[][] pieces) {
		int elementsMatched = 0;	// Elements matched in target array
		int piecesMatched = 0;		// Arrays matched from pieces array
		
		for (int j = 0; j < pieces.length && elementsMatched < target.length; j++) {
			for (int k = 0; k < pieces[j].length && k < target.length - elementsMatched; k++) {
				
				// If any integer doesn't match, move on to the next array
				if (pieces[j][k] != target[elementsMatched+k]) {
					break;
				}
				
				// If last element matches, then this array matches a sub-array from target
				if (k == pieces[j].length - 1 && pieces[j][k] == target[elementsMatched+k]) {	

					// Move iterator forward in target array
					elementsMatched += pieces[j].length;
					
					// Bring this piece to the back of the array
					int[] temp = pieces[piecesMatched]; 
					pieces[piecesMatched] = pieces[j];
					pieces[j] = temp;
					piecesMatched++;
					
					// Restart the search cycle
					j = piecesMatched - 1;
					break;
				}
			}
		}
		
		return elementsMatched == target.length;
	}

	public static void main(String[] args) {
		CanFormArray cfa = new CanFormArray();
		
		int[] target = new int[] {1, 2, 3, 4};
		int[][] pieces = new int[][] {{1, 2, 3, 4}};
		
		System.out.println(cfa.canFormArray(target, pieces));
	}

}
