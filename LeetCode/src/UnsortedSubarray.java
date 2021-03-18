/*
 * LeetCode February 25 2021 challenge
 * 
 * Given an integer array, finds the shortest possible unsorted sub-array that when sorted
 * in ascending order makes the whole array sorted in ascending order.
 */
public class UnsortedSubarray {

	public int unsortedSubarray(int[] arr) {
		int i = 0;
		int j = arr.length - 1;
		
		while (i < j && arr[i+1] >= arr[i]) {
			i++;
		}
		
		while (j > i && arr[j-1] <= arr[j]) {
			j--;
		}
		
		if (i == j) {
			System.out.println("[]");
			return 0;
		}
		else {
			// prints
			System.out.print("[");
			for (int k = i; k <= j; k++) {
				System.out.print(arr[k]);
				if (k < j) System.out.print(", ");
			}
			System.out.println("]");
			
			return j - i + 1;
		}
	}
	
	public static void main(String[] args) {
		UnsortedSubarray us = new UnsortedSubarray();
//		int[] arr1 = {2, 6, 4, 8, 10, 9, 15};
		int[] arr2 = {2, 1};
//		int[] arr3 = {1, 2, 3, 4, 5, 7, 6, 8, 9, 10, 11, 12};

//		System.out.println(us.unsortedSubarray(arr1));
		System.out.println(us.unsortedSubarray(arr2));
//		System.out.println(us.unsortedSubarray(arr3));
		
	}

}
