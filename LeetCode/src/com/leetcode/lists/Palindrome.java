package com.leetcode.lists;

/**
 * Given a singly-linked list, evaluates whether it is a palindrome.
 */
public class Palindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode first = head;
        ListNode second = head;

        // Find middle of list
        while (first != null && second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }

        // Reverse second half of list
        ReverseList rl = new ReverseList();
        second = rl.reverseListRecursive(first);
        first = head;

        // Traverse both halves and check for differences
        while (first != null && second != null) {
            if (first.val != second.val) return false;
            first = first.next;
            second = second.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        ListNode head = new ListNode(new int[]{1, 2});

        System.out.println(p.isPalindrome(head));
    }
}
