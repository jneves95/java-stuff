package com.leetcode.sorting;

public class Sort {
	// Helper function to swap values in an array
	public static void swap(int[] arr, int i, int j) {
		if (i >= 0 && i < arr.length && j >= 0 && j < arr.length) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
	
	// Prints array with specific indices pointed out (to visualize swaps)
	public static void print(int[] arr, int i, int j) {
		System.out.print("[");
		
		for (int k = 0; k < arr.length; k++) {
			if (k == i || k == j) System.out.print("(");
			System.out.print(arr[k]);
			if (k == i || k == j) System.out.print(")");
			if (k < arr.length - 1) System.out.print(", ");
		}
		
		System.out.println("]");
	}
	
	// Overloads
	public static void print(int[] arr) {
		print(arr, -1, -1);
	}
	
	public static void print(int[] arr, int i) {
		print(arr, i, -1);
	}
	
	// Insertion Sort
	// Similar to the way we sort playing cards in our hands, every time we find a value bigger than its predecessor, 
	// we move it back to its sorted position, and shift the other values forward. O(n^2)
	public static int[] insertionSort(int[] arr, boolean visual) {
		int steps = 0;
		int i = 0;
		
		while (i < arr.length) {
			steps++;		
			if (i > 0 && arr[i] < arr[i-1]) {
				swap(arr, i, i-1);
				if (visual) print(arr, i, i-1);
				i--;
			}
			else i++;	
		}

		System.out.print("Insertion sort: ");
		print(arr);
		System.out.println("Took " + steps + " steps.\n");

		return arr;
	}
	
	// Overload
	public static int[] insertionSort(int[] arr) {
		return insertionSort(arr, false);
	}
	
	// Selection Sort
	// This repeatedly selects the minimum value from an unsorted sub-array and puts it at the beginning, shortening the next sub-array. O(n^2)
	public static int[] selectionSort(int[] arr, boolean visual) {
		int steps = 0;
		
		for (int i = 0; i < arr.length - 1; i++, steps++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++, steps++) {
				if (arr[j] < arr[minIndex]) minIndex = j;
			}
			swap(arr, i, minIndex);
			if (visual) print(arr, i, minIndex);
		}
		
		System.out.print("Selection sort: ");
		print(arr);
		System.out.println("Took " + steps + " steps.\n");

		return arr;
	}
	
	// Overload
	public static int[] selectionSort(int[] arr) {
		return selectionSort(arr, false);
	}
	
	// Bubble Sort
	// This is the most naive method so far, which repeatedly compares adjacent values and swaps them if they're not in the correct order.
	// We repeat this process until there's a full pass of the array without any swaps, so we can conclude that the whole array is in order.
	public static int[] bubbleSort(int[] arr, boolean visual) {
		int steps = 0;
		int n = arr.length;
		boolean swapped = false;
		
		do {
			swapped = false;
			for (int i = 1; i < n; i++, steps++) {
				if (arr[i-1] > arr[i]) {
					swap(arr, i-1, i);
					if (visual) print(arr, i, i-1);
					swapped = true;
				}
			}
			n--;	// We know that for each pass, at least one value was moved to its final position in the end of the array, so we don't need to keep checking the whole length
		} while (swapped);
		
		System.out.print("Bubble sort: ");
		print(arr);
		System.out.println("Took " + steps + " steps.\n");

		return arr;
	}
	
	// Overload
	public static int[] bubbleSort(int[] arr) {
		return bubbleSort(arr, false);
	}
	
	/*
	 * Counting Sort
	 * This algorithm is useful when the range of the values in the array is significantly smaller than the size of the array. 
	 * It works by counting the occurrences of each value and storing them in their own auxiliar array (counts) and then summing up those counts while iterating over said array,
	 * giving us the indices where those values will go in the sorted array.
	 * In case the range of the values is significantly larger, think an array of length 100 with values between 0 and 1000, 
	 * just the auxiliar array would be 10 times larger than the original one, which doesn't look very efficient.
	 * 
	 * Each for-loop iterates only once over the original array (3 times) and the counts array (1 time), so we get O(3n + k) ~ O(n+k) time.
	 * Space complexity depends on the range of values, so it will always be O(k+1) where k = maximum value found in original array.
	 */
	public static int[] countingSort(int[] arr, boolean visual) {
		int steps = 0;
		int max = arr[0];
		
		// First traversal of the array to find out the maximum value
		for (int i = 0; i < arr.length; i++, steps++) {
			max = Math.max(max, arr[i]);
		}
		
		// Initialize counting array (+1 because we have to include zero)
		int[] counts = new int[max + 1];
		
		// Second traversal to count occurrences
		for (int i = 0; i < arr.length; i++, steps++) {
			counts[arr[i]]++;
			if (visual) print(counts, arr[i]);
		}
		
		// Traverse the count array and sum up the values
		for (int i = 0, total = 0; i < counts.length; i++, steps++) {
			total = counts[i] += total;
			if (visual) print(counts, i);
		}
		
		// Traverse the original array one final time and move values to output array
		// (we traverse in reverse order to maintain relative order between duplicates, so the algorithm is stable)
		int[] output = new int[arr.length];
		
		for (int i = arr.length - 1; i >= 0; i--, steps++) {
			output[counts[arr[i]] - 1] = arr[i]; 	// (we do -1 because since counts are always positive, they don't account for the 0th position)
			counts[arr[i]]--;
			
			if (visual) print(output, counts[arr[i]]);
			if (visual) print(counts, arr[i]);
		}
		
		System.out.print("Counting sort: ");
		print(output);
		System.out.println("Took " + steps + " steps.\n");

		return arr;
	}
	
	// Overload
	public static int[] countingSort(int[] arr) {
		return countingSort(arr, false);
	}
	
	/*
	 * Merge Sort
	 * 
	 * The magic is in the merge function, which is called recursively, halving the array repeatedly until only 1 element is in each subarray, and then merging them in order back
	 * in the original array, with each subarray in the merge already sorted. This works because as we sort from the bottom up, or in other words, from smaller subarrays to the 
	 * bigger array, both subarrays are guaranteed to be sorted and the next element to move over to the original array is guaranteed to be the smallest from the subarrays, 
	 * with no need to look ahead.
	 */
	public static int mergeSort(int[] arr, int left, int right, boolean visual) {
		if (left >= right) return 0;
		int steps = 0;
		
		int middle = left + (right-left) / 2;
		
		steps += mergeSort(arr, left, middle, visual);
		steps += mergeSort(arr, middle + 1, right, visual);
		steps += merge(arr, left, middle, right, visual);
		
		if (left == 0 && right == arr.length - 1) {
			System.out.print("Merge sort: ");
			print(arr);
			System.out.println("Took " + steps + " steps.\n");
		}
		
		return steps;
	}
	
	public static int mergeSort(int[] arr, boolean visual) {
		return mergeSort(arr, 0, arr.length - 1, visual);
	}
	
	public static int mergeSort(int[] arr) {
		return mergeSort(arr, 0, arr.length - 1, false);
	}
	
	/*
	 * Merges two subarrays back into the array
	 */
	public static int merge(int[] arr, int left, int middle, int right, boolean visual) {		
		int steps = 0;
		
		// Create temporary subarrays
		int lenLeft = middle - left + 1;
		int lenRight = right - middle;
		int[] subLeft = new int[lenLeft];
		int[] subRight = new int[lenRight];
		
		// Copy values from original array
		for (int i = 0; i < lenLeft; i++) {
			subLeft[i] = arr[left + i];
		}
		
		for (int i = 0; i < lenRight; i++) {
			subRight[i] = arr[middle + 1 + i];
		}
		
		// Merge the subarrays back into the array
		int i = 0, j = 0, k = left;
		while(i < lenLeft && j < lenRight) {
			if (subLeft[i] < subRight[j]) {
				arr[k] = subLeft[i];
				if (visual) print(arr, k);
				i++;
			}
			else {
				arr[k] = subRight[j];
				if (visual) print(arr, k);
				j++;
			}
			k++;
			steps++;
		}
		
		// Copy the remaining elements of the subarrays, if there are any - the previous loop will always end when one array is completely copied, 
		// leaving some elements left in the other)
		while (i < lenLeft) {
			arr[k] = subLeft[i];
			if (visual) print(arr, k);
			i++;
			k++;
			steps++;
		}
		
		while (j < lenRight) {
			arr[k] = subRight[j];
			if (visual) print(arr, k);
			j++;
			k++;
			steps++;
		}
		
		return steps;
	}
	
	/*
	 * Quick sort
	 * 
	 */
	public static void quickSort(int[] arr, int low, int high, boolean visual) {
		if (low < high) {
			int j = partition(arr, low, high);
			quickSort(arr, low, j, visual);
			quickSort(arr, j + 1, high, visual);
		}
		
		if (low == 0 && high == arr.length - 1) {
			System.out.print("Merge sort: ");
			print(arr);
//			System.out.println("Took " + steps + " steps.\n");
		}
	}
	
	public static void quickSort(int[] arr, boolean visual) {
		quickSort(arr, 0, arr.length - 1, visual);
	}
	
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length - 1, false);
	}

	public static int partition(int[] arr, int low, int high) {
		int i = low;	// +1 because we assume 0th element as the pivot
		int j = high + 1;
		int pivot = arr[low];
		
		while (i < j) {
			// Finds bigger element than pivot
			do {
				i++;
			}
			while (i < high && arr[i] < pivot);
			
			// Finds smaller element than pivot
			do {
				j--;
			}
			while (j > low && arr[j] >= pivot);
			
			// Swaps them
			if (i < j) {
				swap(arr, i, j);
			}
		}
		
		// Finally place pivot in its sorted position
		swap(arr, low, j);
		
		return j;
	}
	
	/*
	 * Heap sort
	 * 
	 * Works by converting an unsorted array into a max heap (using heapify method) and then repeatedly removing first element from the heap 
	 * (swapping with last element and decrementing heap size) until the heap is empty. Because the first element in a max heap is always the largest,
	 * and by always moving it to the end of the heap, by the time the heap is empty, the array is sorted.
	 */
	public static void heapSort(int[] arr, boolean visual) {
		// First create a max heap from given array by iterating backwards and heapifying subtrees from the bottom up
		for (int i = arr.length/2 - 1; i >= 0; i--) {
			heapify(arr, arr.length - 1, i);
		}
		
		// Swap first (largest) element with last element and reduce heap's size by 1 until heap is empty
		for (int i = arr.length - 1; i >= 0; i--) {
			swap(arr, 0, i);
			heapify(arr, i-1, 0);
		}
		
		System.out.print("Heap sort: ");
		print(arr);
//		System.out.println("Took " + steps + " steps.\n");
	}
	
	/*
	 * Heapify method - converts a subtree from the heap of length N from subtree root node I
	 */
	public static void heapify(int[] arr, int n, int i) {
		// Initialize largest, left and right nodes
		int largest = i;
		int l = 2 * i;
		int r = 2 * i + 1;
		
		// Check if left child is larger
		if (l <= n && arr[l] > arr[largest]) {
			largest = l;
		}
		
		// Check if right child is larger
		if (r <= n && arr[r] > arr[largest]) {
			largest = r;
		}
		
		// If a child node was larger than root node, swap them and heapify affected subtree
		if (largest != i) {
			swap(arr, largest, i);
			heapify(arr, n, largest);
		}
	}
	
	public static void main(String[] args) {
//		insertionSort(new int[] {7, 6, 1, 5, 3, 4, 8, 2, 3, 9, 1, 4});
//		selectionSort(new int[] {7, 6, 1, 5, 3, 4, 8, 2, 3, 9, 1, 4});
//		bubbleSort(new int[] {7, 6, 1, 5, 3, 4, 8, 2, 3, 9, 1, 4, 7, 6, 1, 5, 3, 4, 8, 2, 3, 9, 1, 4});
//		countingSort(new int[] {7, 6, 1, 5, 3, 4, 8, 2, 3, 9, 1, 4});
//		mergeSort(new int[] {7, 6, 1, 5, 3, 4, 8, 2, 3, 9, 1, 4, 7, 6, 1, 5, 3, 4, 8, 2, 3, 9, 1, 4});
//		quickSort(new int[] {7, 6, 1, 5, 3, 4, 8, 2, 3, 9, 1, 4, 7, 6, 1, 5, 3, 4, 8, 2, 3, 9, 1, 4}, true);
		heapSort(new int[] {7, 6, 1, 5, 3, 4, 8, 2, 3, 9, 1, 4, 7, 6, 1, 5, 3, 4, 8, 2, 3, 9, 1, 4}, true);
	}

}
