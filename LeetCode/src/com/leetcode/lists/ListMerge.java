package com.leetcode.lists;

import java.util.Arrays;

public class ListMerge {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode prev = null;
		
		// Traverse both lists while choosing the smaller value nodes
		while (l1 != null && l2 != null) {
			ListNode temp;
			if (l1.val <= l2.val) {
				temp = new ListNode(l1.val);
				l1 = l1.next;
			}
			else {
				temp = new ListNode(l2.val);
				l2 = l2.next;
			}
			
			if (head == null) head = temp; // Save head
			if (prev != null) prev.next = temp; // Link previous node to new node
			prev = temp;
		}
		
		// When one list is finished, traverse to the end of the remaining one
		while (l1 != null) {
			ListNode temp = new ListNode(l1.val);
			if (head == null) head = temp;
			if (prev != null) prev.next = temp;
			prev = temp;
			l1 = l1.next;
		}
		
		while (l2 != null) {
			ListNode temp = new ListNode(l2.val);
			if (head == null) head = temp;
			if (prev != null) prev.next = temp;
			prev = temp;
			l2 = l2.next;
		}
		
		// Return head of new list
		return head;
	}
	
	// Generates a random integer between min and max
	public int randomInt(int min, int max) {
		int random = (int) (min + Math.random() * (max - min + 1));
		return random;
	}
	
	
	// Generates a randomized sorted list 
	public ListNode generateRandomSortedList(int maxLength, int maxValue) {
		// Randomize list length
		int length = randomInt(0, maxLength); // Integer between 0 and maxLength
		
		if (length == 0) return null;
		
		// Creates an array with randomized values up to maxValue and sorts it
		int[] arr = new int[length];
		for (int i = 0; i < length; i++) {
			arr[i] = randomInt(0, maxValue);
		}
		
		Arrays.sort(arr);
		
		// Creates list with values of sorted array
		ListNode head = new ListNode(arr[0]);	// Initialize head
		ListNode prev = head;
		
		for (int i = 1; i < length; i++) {
			ListNode temp = new ListNode(arr[i]);
			prev.next = temp;
			prev = temp;
		}
		
		return head;
	}
	
	
	// Prints a given list
	public void printList(ListNode head) {
		System.out.print("[");
		
		while (head != null) {
			System.out.print(head.val);
			if (head.next != null) System.out.print(", ");
			head = head.next;
		}
		
		System.out.print("]");
	}
	

	public static void main(String[] args) {
		ListMerge lm = new ListMerge();
		ListNode l1 = lm.generateRandomSortedList(0, 10);
		ListNode l2 = lm.generateRandomSortedList(5, 10);
		
		System.out.print("List 1: ");
		lm.printList(l1);
		System.out.print(", list 2: ");
		lm.printList(l2);
		System.out.println();
		
		System.out.print("Merged lists: ");
		lm.printList(lm.mergeTwoLists(l1, l2));
	}

}
