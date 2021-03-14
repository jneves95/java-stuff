package com.leetcode.lists;

import java.util.HashMap;

/*
 * Given a linked list where each node has an additional pointer which points to any node in the list or is null (random pointer),
 * returns a deep copy of said list, where all pointers in the new list point to nodes in the new list.
 */
public class CopyRandomList {
	static class RandomNode  {
		int val;
		RandomNode next;
		RandomNode random;
		
		public RandomNode (int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}
	
	public RandomNode copyRandomList(RandomNode head) {
		if (head == null) return null;
		
		// Copy head
		RandomNode newHead = new RandomNode(head.val);
		RandomNode node = newHead;
		
		// Initialize mapping of random pointers
		HashMap<RandomNode, RandomNode> map = new HashMap<RandomNode, RandomNode>();
		map.put(head, newHead);
		
		// Copy nodes
		while (head != null) {
			node.next = head.next != null ? new RandomNode(head.next.val) : null;
			node.random = head.random;
			map.put(head, node);
			head = head.next;
			node = node.next;
		}
		
		// Assign corresponding random pointers
		node = newHead;
		while (node != null) {
			if (node.random != null) node.random = map.get(node.random);
			node = node.next;
		}
		
		return newHead;
	}
	
	public static void main(String[] args) {
		RandomNode head = new RandomNode(4);
		head.next = new RandomNode(2);
		head.next.next = new RandomNode(3);
		
		head.random = head.next.next;
		head.next.random = head;
		head.next.next.random = head.next.next;
		
		// Print original list
		RandomNode n = head;
		
		System.out.print("Original: [");
		
		while (n != null) {
			System.out.print(n.val + "(" + (n.random == null ? "null" : n.random.toString()) + ")");
			if (n.next != null) System.out.print(", ");
			n = n.next;
		}
		
		System.out.println("]");
		
		// Print copied list
		CopyRandomList crl = new CopyRandomList();
		n = crl.copyRandomList(head);
		
		System.out.print("Copy: [");
		
		while (n != null) {
			System.out.print(n.val + "(" + (n.random == null ? "null" : n.random.toString()) + ")");
			if (n.next != null) System.out.print(", ");
			n = n.next;
		}
		
		System.out.println("]");
	}

}
