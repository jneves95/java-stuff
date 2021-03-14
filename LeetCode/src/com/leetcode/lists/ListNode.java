package com.leetcode.lists;

public class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] arr) {
        if (arr.length == 0) return;
        this.val = arr[0];
        ListNode curr = this;

        for (int i = 1; i < arr.length; i++) {
            ListNode node = new ListNode(arr[i]);
            curr.next = node;
            curr = node;
        }
    }

    /**
     * Prints the list starting from this node.
     */
    public void print() {
        System.out.print("[");
        ListNode curr = this;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) System.out.print(", ");
            curr = curr.next;
        }
        System.out.println("]");
    }
}
