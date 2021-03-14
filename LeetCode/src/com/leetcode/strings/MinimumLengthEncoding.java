package com.leetcode.strings;

import java.util.Map;
import java.util.Set;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/*
 * LeetCode 06 March 2021 Challenge
 */
public class MinimumLengthEncoding {
	/* 
	 * This is a tree representation of the words' characters from right-to-left.
	 * So if we represent the word "time", at the root we will have a node 'e', and a child 'm', which has a child 'i', which has a child 't', which has no children.
	 * 
	 * By doing so, we can input all the words into this tree, and any words that are suffixes of other words will already be subpaths in this tree.
	 * Then we can count the number of leaves (words that are not suffixes of other words) and add up their lengths for the result.
	 */
	static class TrieNode {
		int count;	// We keep a count of the children so that later we can quickly identify leaf nodes (count == 0)
		TrieNode[] children;
		TrieNode() {
			count = 0;
			children = new TrieNode[26]; // A node for each letter in the alphabet
		}
		
		TrieNode get(char c) {
			if (children[c - 'a'] == null) {
				children[c - 'a'] = new TrieNode();
				count++;
			}
			return children[c - 'a'];
		}
	}
	
	public int minimumLengthEncoding(String[] words) {
		// Keep a mapping from nodes to words, so that we can later refer back to the tree and see which words have no suffixes
		Map<TrieNode, Integer> nodes = new HashMap<>(); 
		TrieNode root = new TrieNode();
		
		// Iterate through words and populate trie
		for (int i = 0; i < words.length; i++) {
			TrieNode curr = root;
			
			for (int j = words[i].length() - 1; j >= 0; j--) {
				curr = curr.get(words[i].charAt(j));
			}
			
			// When we're done, map the corresponding node to the start of this word
			nodes.put(curr, i);
		}
		
		// For every word that has no suffixes, add it to the result (+1 for the '#' character)
		int result = 0;
		for (TrieNode node : nodes.keySet()) {
			if (node.count == 0) {
				int index = nodes.get(node);
				result += words[index].length() + 1;
			}
		}
		
		return result;
	}
	
	/*
	 * Another possible procedure is to put all the words into a set, and then for each word, check for its possible suffixes in the set and remove them.
	 * (Since words only have up to 7 characters, each word can only have up to 6 suffixes, so we do 6 checks per word)
	 */
	public int minimumLengthEncodingSuffixes(String[] words) {
		Set<String> set = new HashSet<>(Arrays.asList(words));
		
		for (String word : words) {
			if (set.contains(word)) {
				for (int i = 1; i < word.length(); i++) {
					set.remove(word.substring(i));
				}
			}
		}
		
		int result = 0;
		
		for(String word : set) {
			result += word.length() + 1;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		MinimumLengthEncoding mle = new MinimumLengthEncoding();
		String[] words = {"time", "me", "bell", "halftime", "im", "i"};
		
		System.out.println(mle.minimumLengthEncodingSuffixes(words));
	}

}
