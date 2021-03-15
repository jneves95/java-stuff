package com.leetcode.lists;

/**
 * Given the head of a list, return the reversed list.
 */
public class ReverseList {

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) return head; // Stop boundary
        ListNode p = reverseListRecursive(head.next);       // Traverses list recursively
        head.next.next = head;                              // Point next node back at this node
        head.next = null;                                   // Make sure that head points to null at the end of the recursion, avoiding cycles (this step is irrelevant for middle nodes)
        return p;                                           // Carry last node back to the start of recursion, returning as the new head
    }

    public static void main(String[] args) {
        ReverseList rl = new ReverseList();
        ListNode head = new ListNode(new int[] {1, 2, 3, 4, 5});

        head.print();
        head = rl.reverseList(head);
        head.print();
        head = rl.reverseListRecursive(head);
        head.print();
    }
}
