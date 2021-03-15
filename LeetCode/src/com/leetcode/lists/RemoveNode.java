package com.leetcode.lists;

public class RemoveNode {

    /**
     * Given a node in a list, remove it from the list. Note that we are not given the head of the list.
     */
    public void removeNode(ListNode node) {
        while (node.next != null) {
            node.val = node.next.val;
            if (node.next.next == null) {
                node.next = null;
                return;
            }
            node = node.next;
        }
    }

    /**
     * Removes the nth node from the end of a list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Measure list's length
        int length = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            length++;
        }

        // Check if we need to remove head
        if (length == n) {
            return head.next;
        }

        // Find nth-1 node from the end
        int index = 0;
        curr = head;
        while (curr != null && index < length - n - 1) {
            curr = curr.next;
            index++;
        }

        // Remove nth node
        curr.next = curr.next.next;

        return head;
    }

    /**
     * Starts traversing the list with two pointers, separated by N+1 nodes, hence when the front pointer arrives at the end of the list, the back pointer is at the nth node.
     */
    public ListNode removeNthFromEndOnePass(ListNode head, int n) {
        // Advance front pointer to the (n+1)th node from the beginning
        ListNode front = head;
        while (front != null && n >= 0) {
            front = front.next;
            n--;
        }

        // If front pointer reaches end of list as its starting position, it means we must remove the head
        if (front == null && n == 0) return head.next;

        // Now advance both pointers at the same speed, but n+1 nodes apart
        ListNode back = head;
        while (front != null && back != null) {
            front = front.next;
            back = back.next;
        }

        // Found our nth node from the end, remove it
        back.next = back.next.next;

        return head;
    }

    public static void main(String[] args) {
        RemoveNode dn = new RemoveNode();

        // Create list and pick a node to be removed
        ListNode head = new ListNode(new int[] {2, 5, 3, 1, 9, 8, 6});
        ListNode toRemove = head;
        while (toRemove != null && toRemove.val != 1) toRemove = toRemove.next;

        // Remove and print
        head.print();
        dn.removeNode(toRemove);
        head.print();

        // Remove 2nd node from the end and print
        head = dn.removeNthFromEnd(head, 6);
        head.print();

        // Test one pass
        ListNode other = new ListNode(new int[] {1, 2});
        other.print();
        other = dn.removeNthFromEndOnePass(other, 1);
        other.print();
    }
}
