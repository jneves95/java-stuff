package com.leetcode;

/*
 * Given a sequence (length n) of versions of a product, where all subsequent versions after a bad version are also bad, returns the first bad version.
 * We do this by running a binary search through the versions until we find the first bad one. This takes log(n)
 * 
 */
public class FirstBadVersion {
	public boolean isBadVersion(int n) {
		return n >= 2500;
	}
	
	public int firstBadVersion(int n) {
		int low = 0;
		int high = n;
		
		while (low < high) {
			int mid = (high - low) / 2 + low;
			if (isBadVersion(mid)) high = mid; // bad version, but we don't know if it's the first one, so we look for another previous to this one (not excluding this)
			else low = mid + 1; // not bad version, so we need to look for a bad version to the right of this, hence the increment
		}
		
		return high;
	}
	
	public static void main(String[] args) {
		FirstBadVersion fbv = new FirstBadVersion();
		
		System.out.println(fbv.firstBadVersion(2500));
	}

}
