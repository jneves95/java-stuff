package com.leetcode.random;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/*
 * LeetCode 19 March 2021 Challenge
 * 
 */
public class KeysAndRooms {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		boolean[] haveKey = new boolean[rooms.size()];
		haveKey[0] = true;
		int visited = 0;
		
		Queue<Integer> keys = new ArrayDeque<>();
		keys.add(0);
		
		while (!keys.isEmpty()) {
			for (int key : rooms.get(keys.poll())) {
				if (!haveKey[key]) {
					keys.add(key);
					haveKey[key] = true;
				}
			}

			visited++;
		}
		
		return visited == rooms.size();
	}
	
	public static List<List<Integer>> roomKeysFromArray(int[][] rooms) {
		List<List<Integer>> res = new ArrayList<>();
		
		for (int[] room : rooms) {
			List<Integer> keys = new ArrayList<>();
			for (int i : room) {
				keys.add(i);
			}
			res.add(keys);
		}
		
		return res;
	}

	public static void main(String[] args) {
		KeysAndRooms kar = new KeysAndRooms();
		List<List<Integer>> rooms1 = roomKeysFromArray(new int[][] {{1}, {2}, {3}, {}});
		List<List<Integer>> rooms2 = roomKeysFromArray(new int[][] {{1, 3}, {0, 1, 2}, {2}, {0}});

		System.out.println(kar.canVisitAllRooms(rooms1));
		System.out.println(kar.canVisitAllRooms(rooms2));
	}

}
