package com.leetcode;

import java.util.Iterator;
import java.util.LinkedList;

public class PeekingIterator implements Iterator<Integer> {
	Iterator<Integer> iterator;
	boolean hasPeeked;
	Integer peekedElement;
	
	public PeekingIterator(Iterator<Integer> iterator) {
		this.iterator = iterator;
		this.hasPeeked = false;
		this.peekedElement = null;
	}
	
	 // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if (!hasPeeked) {
        	peekedElement = iterator.next();
        	hasPeeked = true;
        }

    	return peekedElement;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
	    if (!hasPeeked) {
	    	return iterator.next();
	    }
	    
	    Integer result = peekedElement;
	    hasPeeked = false;
	    peekedElement = null;
	    return result;
	}
	
	@Override
	public boolean hasNext() {
	    return hasPeeked || iterator.hasNext();
	}

	
	public static void main(String[] args) {
		LinkedList<Integer> example = new LinkedList<>();
		for (int i = 0; i < 5; i++) {
			example.add(i);
		}
		
		PeekingIterator it = new PeekingIterator(example.iterator());
	}
}
