package com.leetcode.arrays;

/**
 * Given a non-empty array of decimal digits representing a non-negative integer, increment one to the integer.
 *
 * Ex: [4,3,2,2] -> [4,3,2,3]
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while (i >= 0 && digits[i] == 9) {
            digits[i] = 0;
            i--;
        }

        // Needs extra digit
        if (i < 0) {
            digits = new int[digits.length + 1];
            digits[0] = 1;
        }
        else {
            digits[i]++;
        }

        return digits;
    }

    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        int[] digits = {9, 9, 9, 8};

        digits = po.plusOne(digits);

        for (int digit : digits) {
            System.out.print(digit + " ");
        }
    }
}
