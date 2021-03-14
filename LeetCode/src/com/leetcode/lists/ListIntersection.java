package com.leetcode.lists;

/*
 * LeetCode March 4 2021 Challenge
 */
public class ListIntersection {

	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		// First traverse both lists and find their length
		int lenA = 0;
		int lenB = 0;

		for (ListNode curr = headA; curr != null; curr = curr.next, lenA++);
		for (ListNode curr = headB; curr != null; curr = curr.next, lenB++);
		
		// Knowing their lengths, we can advance the difference between them in the longer list, and then iterate over both lists until the nodes match
		ListNode currB = headB; 
		ListNode currA = headA;
		if (lenA > lenB) {
			for (int i = 0; i < lenA - lenB; i++, currA = currA.next);
		}
		else if (lenB > lenA) {
			for (int i = 0; i < lenB - lenA; i++, currB = currB.next); 
		}
		
		// Now iterate over both of them until the nodes match
		while (currA != null && currB != null) {
			if (currA == currB) return currA;
			currA = currA.next;
			currB = currB.next;
		}
		
		// If we didn't find matching nodes, return null
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
