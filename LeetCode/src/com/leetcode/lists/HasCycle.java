package com.leetcode.lists;

import java.util.HashSet;

public class HasCycle {
	
	/*
	 * This is the easy straightforward method that uses a hashtable to store new nodes until it finds a familiar node,
	 * which both indicates the existence of a cycle and identifies its beginning node.
	 */
	public ListNode hasCycleEasy(ListNode head) {
		HashSet<ListNode> set = new HashSet<ListNode>();

		while(head != null && head.next != null) {
			if(set.contains(head)) return head;
			else set.add(head);
			head = head.next;
		}
		
		return null;
	}
	
	/*
	 * This one uses constant memory, by using some pointers moving at different speeds through the list until they meet each other.
	 * Then we use a few tricks to identify the beginning node of the cycle.
	 */
	public ListNode hasCycle(ListNode head) {
		if (head == null || head.next == null || head.next.next == null) return null;
		
		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if (slow == fast) break; // pointers met, we found a cycle
		}
		
		if (slow != fast) return null; // pointers never met, reached the end of the list
		
		/* Now we find the beginning of the cycle by starting the slow pointer back at the beginning and moving both pointers one node at a time until they meet again.
		 * We know they meet at the beginning of the cycle because with the help of a little math we find that the distance between the head and the beginning of the cycle 
		 * is the same as the distance between the meeting point in the cycle and the beginning of the cycle.
		 */
		for (slow = head; slow != fast; slow = slow.next, fast = fast.next);
		return slow;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
