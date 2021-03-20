package com.leetcode.arrays;

/**
 * Given two sorted arrays, merge both of them in-place into the first array.
 * (we can assume that the first array is extended to accommodate the whole second array in it)
 */
public class MergeSortedArrays {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;

        while (i < m + n && j < n) {
            if (nums1[i] <= nums2[j]) {
                i++;
            }
            else {
                for (int k = m + n - 1; k > i; k--) {
                    nums1[k] = nums1[k-1];
                }
                nums1[i] = nums2[j];
                j++;
            }
        }

        // If the first array is fully merged, copy the remainder of the second array
        while (j < n) {
            nums1[m + j] = nums2[j];
            j++;
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};

        merge(nums1, 3, nums2, 3);

        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i] + " ");
        }

        System.out.println();
    }
}
