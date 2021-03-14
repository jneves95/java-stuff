package com.leetcode.strings;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Given an absolute path string, simplifies it and returns the canonical path as found in a unix-style file system.
 */
public class SimplifyPath {
	public String simplifyPath(String path) {
		Deque<String> directories = new ArrayDeque<>();

		for (String s : path.split("/")) {
			if (s.compareTo("..") == 0 && !directories.isEmpty()) directories.pop();
			else if (s.compareTo("..") != 0 && s.compareTo(".") != 0 && !s.isEmpty()) directories.push(s);
		}
		
		StringBuilder sb = new StringBuilder();
		while (!directories.isEmpty())
			sb.append("/" + directories.removeLast());
		
		if (sb.length() == 0) 
			sb.append("/");
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String example = "/a/./b/../../c/";
		
		SimplifyPath sp = new SimplifyPath();

		System.out.println(sp.simplifyPath(example));
	}
}
