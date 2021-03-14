package com.leetcode;

import java.util.Stack;

public class IsBipartite {
	public boolean isBipartite(int[][] graph) {
		// Node visited state (0 means not visited, -1 and 1 are the colors the nodes can have)
		int[] color = new int[graph.length];
		
		Stack<Integer> st = new Stack<>();
		
		// Initialize first node color and push it to stack
		st.push(0);
		color[0] = 1;
		
		// Traverse all nodes while coloring them
		while (!st.isEmpty()) {
			int node = st.pop();
			
			for (int adj : graph[node]) {
				if (color[adj] == 0) {
					color[adj] = color[node] * -1;
					st.push(adj);
				}
				else if (color[adj] == color[node]) return false;	// If we find an adjacent node with same color, there exists an odd cycle, and thus the graph is not bipartite
			}
			
			// If stack is empty, check to see if there are other disconnected nodes and evaluate them next
			if (st.isEmpty()) {
				for (int i = 0; i < graph.length; i++) {
					if (color[i] == 0) {
						color[i] = 1;
						st.push(i);
						break;
					}
				}
			}
		}
		
		// All nodes were traversed and no odd cycles were found -> graph is bipartite
		return true;
	}

	public static void main(String[] args) {
		IsBipartite ib = new IsBipartite();
		int[][] graph = {{1,2,3},{0,2},{0,1,3},{0,2}};
		
		System.out.println(ib.isBipartite(graph));
	}

}
