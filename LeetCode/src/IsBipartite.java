import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class IsBipartite {
	static class Node {
		List<Node> edges = new ArrayList<>();
		
		Node(List<Node> edges) {
			if (edges != null) this.edges = edges;
		}
	}
	
	public boolean isBipartite(int[][] graph) {
		// Store visited state for nodes in graph
		boolean[] visited = new boolean[graph.length];
		
		// Two independent subsets
		Set<Integer> setA = new HashSet<>();
		Set<Integer> setB = new HashSet<>();
		
		Queue<Integer> q = new ArrayDeque<>();
		
		// Initialize queue and first set with first element
		q.add(0);
		
		while (!q.isEmpty()) {
			int node = q.peek();

			for (int i = 0; i < graph[node].length; i++) {
				// Define which set we will be adding the next nodes to
				Set<Integer> set = setA.contains(node) ? setB : setA;
				
				int nextNode = graph[node][i];
				
				set.add(nextNode);
				if (!visited[nextNode]) q.add(nextNode);
				
				// If both sets contain a node, it means we found an odd-length cycle,
				// meaning the sets are no longer independent, and the graph not bipartite
				if (setA.contains(nextNode) && setB.contains(nextNode)) return false; 
			}
			
			visited[node] = true;
			q.remove();
			
			// If queue becomes empty but we still have nodes to visit, add first unvisited node
			if (q.isEmpty()) {
				for (int i = 0; i < visited.length; i++) {
					if (!visited[i]) {
						q.add(i);
						break;
					}
				}
			}
		}
		
		return true;
	}
	
	public boolean isBipartite2(int[][] graph) {
		// Array to store which set the node is going to be assigned to
		int[] setArray = new int[graph.length];
		
		// Initialize every node at -1 indicating that it is in no set yet.
		// 0 will mean node is in set U, 1 means set V
		for (int i = 0; i < setArray.length; i++) {
			setArray[i] = -1;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		
		q.add(0);
		
		return false;
	}
	
	public static void main(String[] args) {
		IsBipartite ib = new IsBipartite();
		
		int[][] graph = {{1},{},{4},{4},{2,3}};
		
		System.out.println(ib.isBipartite(graph));
	}

}
