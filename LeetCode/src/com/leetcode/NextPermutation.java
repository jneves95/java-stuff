package com.leetcode;

/**
 * 1 1 4 5 6
 * 1 1 4 6 5
 * 1 1 5 4 6
 * 1 1 5 6 4
 * 1 1 6 4 5
 * 1 1 6 5 4
 * 1 4 1 5 6
 * 1 4 1 6 5
 * 1 4 5 1 6
 * 1 4 5 6 1
 * 1 4 6 1 5
 * 1 4 6 5 1
 * 1 5 1 4 6
 * 
 6 5 4 2 1
 */
public class NextPermutation {
	public void nextPermutation(int[] nums) {
		for (int i = nums.length - 2; i >= 0; i--) {
			for (int j = nums.length - 1; j > i; j--) {
				if (nums[i] < nums[j]) {
					// Swap them
					int temp = nums[i];
					nums[i] = nums[j];
					nums[j] = temp;
					
					// Reverse digits to the right
					reverse(nums, i+1, nums.length-1);
					
					return;
				}
			}
		}
		
		reverse(nums, 0, nums.length-1);
	}
	
	public void reverse(int[] nums, int n, int k) {
		while (n < k) {
			int temp = nums[n];
			nums[n] = nums[k];
			nums[k] = temp;
			n++;
			k--;
		}
	}
	
	public static void main(String args[]) {
		int[] example = new int[] {1, 1, 4, 5, 6};
		
		
		NextPermutation np = new NextPermutation();
		
		for (int j = 0; j < 100; j++) {
			np.nextPermutation(example);
			
			System.out.print("[");
			
			for (int i = 0; i < example.length; i++) {
				System.out.print(example[i]);
				if (i < example.length - 1) System.out.print(", ");
			}
			
			System.out.println("]");
		}
	}
}
