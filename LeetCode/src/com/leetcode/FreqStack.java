import java.util.HashMap;
import java.util.Map;

public class FreqStack {
	private Map<Integer,Integer> counts;
	private Node head;
	
	static class Node {
		int val;
		int count;
		Node next;
		
		Node(int val, int count) {
			this.val = val;
			this.count = count;
		}
	}
	
	public FreqStack() {
		counts = new HashMap<>();
		head = null;
	}
	
	public void push(int val) {
		// Increment count
		int count = counts.getOrDefault(val, 0) + 1;
		counts.put(val, count);
		
		// Create node
		Node n = new Node(val, count);
		
		// If stack empty, just push
		if (head == null) {
			head = n;
			return;
		}
		
		// Put element in ordered position (by count first and then by position entered in stack)
		Node prev = null;
		Node curr = head;
		
		while (curr != null) {
			if (count >= curr.count) {
				// Insert node in correct position
				n.next = curr;
				
				if (curr == head) {
					head = n;
				}
				else if (prev != null) {
					prev.next = n;
				}
				break;
			}
			else if (curr.next == null) {
				// Reached the end of the list, append here
				curr.next = n;
				break;
			}
			
			// Iterate to next element
			prev = curr;
			curr = curr.next;
		}
	}
	
	public int pop() {
		if (head != null) {
			// Decrement count and pop this value
			int val = head.val;
			counts.put(val, counts.get(val) - 1);
			head = head.next;
			return val;
		}
		return -1;
	}
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void print() {
		System.out.print("top-to-bottom: [");
		
		Node curr = head;
		while (curr != null) {
			System.out.print(curr.val);
			if (curr.next != null) System.out.print(", ");
			curr = curr.next;
		}
		
		System.out.println("]");
	}
	
	public static void main(String[] args) {
		FreqStack fs = new FreqStack();
		fs.push(5);
		fs.push(7);
		fs.push(5);
		fs.push(7);
		fs.push(4);
		fs.push(5);
		
		while (!fs.isEmpty()) {
			fs.print();
			System.out.println(fs.pop());
		}
	}

}
