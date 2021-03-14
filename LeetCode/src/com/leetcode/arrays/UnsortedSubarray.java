package com.leetcode.arrays;

import java.util.ArrayList;
import java.util.List;

public class UnsortedSubarray {
	public int unsortedSubarray(int[] arr) {
		boolean sorted = true; // Assume the array is sorted from the beginning
		int min = 0;
		int max = 0;

		// Find the minimum and maximum values out of order and save its index
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i-1]) {
				if (sorted) {
					sorted = false;
					min = arr[i];
					max = arr[i-1];
				}
				else {
					if (arr[i] < min) min = arr[i];
					if (arr[i-1] > max) max = arr[i-1];
				}
			}
		}
		
		// Return 0 if array is sorted
		if (sorted) return 0;
		
		// Now that we know the minimum and maximum values out of order, we find their sorted positions in the array, and those are the boundaries of the unsorted subarray
		int left = 0;
		int right = arr.length - 1;
		while (left < arr.length && arr[left] <= min) left++;
		while (right >= 0 && arr[right] >= max) right--;
		
		System.out.print("[");
		for (int i = left; i <= right; i++) {
			System.out.print(arr[i]);
			if (i < right) System.out.print(", ");
		}
		System.out.println("]");
		
		return right - left + 1;
	}

	public static void main(String[] args) {
		UnsortedSubarray us = new UnsortedSubarray();
		List<int[]> arrays = new ArrayList<>();

		arrays.add(new int[]{1, 2, 3, 4});
		arrays.add(new int[]{0,0,0,1,1,1,2,2,2,5,5,5,3,1,8,6,6,7,7,8});
		arrays.add(new int[]{});
		arrays.add(new int[]{3, 3, 3, 3});
		arrays.add(new int[]{0, 0});
		
		for (int[] arr : arrays) {
			System.out.print("[");
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
				if (i < arr.length - 1) System.out.print(", ");
			}
			System.out.print("] -> ");
			
			int result = us.unsortedSubarray(arr);
			System.out.println("Length: " + result);
		}
	}

}
