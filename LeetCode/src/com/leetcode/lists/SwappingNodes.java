package com.leetcode.lists;

import java.util.List;

/**
 * LeetCode 14 March 2021 Challenge
 *
 * Given a singly-linked list and a number k, swaps the k-th node from the beginning with the k-th node from the end of the list.
 */
public class SwappingNodes {
    public ListNode swapNodes(ListNode head, int k) {
        int length = 0;
        int index = 0;
        ListNode a = null, b = null;

        // Measure list length
        b = head;
        while (b != null) {
            b = b.next;
            length++;
        }

        // Traverse over the list again to find nodes to swap
        b = head;
        while (b != null) {
            if (index == k - 1 || index == length - k) {
                if (a == null) {
                    a = b;  // Found first node
                }
                else break; // Found second node
            }

            b = b.next;
            index++;
        }

        // Swap values
        if (a != null && b != null) {
            int temp = a.val;
            a.val = b.val;
            b.val = temp;
        }

        return head;
    }

    public static void main(String[] args) {
        SwappingNodes sn = new SwappingNodes();

        ListNode head = new ListNode(new int[]{1, 2, 5, 4, 3, 6, 9, 8});
        head.print();

        sn.swapNodes(head, 9);
        head.print();
    }
}
