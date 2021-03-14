package com.leetcode.arrays;

public class RotateArray {
	public void rotateOnePass(int[] nums, int k) {
		k %= nums.length;
		if (nums.length <= 1 || k == 0) return;
		
		int temp, previous = nums[0], startIndex = 0;
		
		for (int i = 0, j = k; i < nums.length; i++, j = (j+k) % nums.length) {
			temp = nums[j];
			nums[j] = previous;
			previous = temp;
			
			if (j == startIndex) {
				startIndex = ++j;
				previous = nums[j];
			}
		}
	}
	
	public void rotateWeird(int[] nums, int k) {
		if (nums.length <= 1 || k == 0 || k == nums.length) return;
		
		// Eliminating cyclic dependencies
		while ((k > 1 && (nums.length % k == 0 || nums.length % (nums.length % k) == 0)) || (nums.length % 2 == 0 && k % 2 == 0)) {
			rotateWeird(nums, 1);
			k--;
		}
		
		// Placeholders
		int p1 = nums[0], p2 = 0;
		
		for (int i = 0, j = k % nums.length; i < nums.length; i++, j = (j + k) % nums.length) {
			p2 = nums[j];
			nums[j] = p1;
			p1 = p2;
		}
	}
	
	// Rotates by reversing everything once, then reversing the first k digits and the last (length-k) digits separately
	// -- this is possible because when rotating k steps, it shifts the first k digits k steps to the front, and the last (length-k) digits to the back
	public void rotateReverse(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
		
	}
	
	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}
	
	public static void main(String args[]) {
//		int[] example0 = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54};
//		int[] example1 = new int[] {-1, -100, 3, 99};
//		int[] example2 = new int[] {0};
//		int[][] examples = new int[][] {example0};
		
		int[] steps = new int[] {45};
		
		RotateArray solution = new RotateArray();
		
		for (int k : steps) {
			System.out.println("Rotating {" + k + "} steps:");
			
			//for (int[] example : examples) {
				int[] example = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54};
				System.out.print("[");
				
				for (int i = 0; i < example.length; i++) {
					System.out.print(example[i]);
					if (i < example.length - 1) System.out.print(", ");
				}
				
				System.out.print("] -> [");
				
				solution.rotateOnePass(example, k);
				
				for (int i = 0; i < example.length; i++) {
					System.out.print(example[i]);
					if (i < example.length - 1) System.out.print(", ");
				}
				
				System.out.println("]");
			//}
		}
	}
}
