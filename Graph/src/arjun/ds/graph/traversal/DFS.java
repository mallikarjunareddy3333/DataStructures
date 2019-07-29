package arjun.ds.graph.traversal;

import java.util.Iterator;
import java.util.LinkedList;

class Graph1 {

	int V;

	LinkedList<Integer> adjacentList[];

	public Graph1(int V) {
		this.V = V;
		adjacentList = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adjacentList[i] = new LinkedList<>();
		}
	}

	void addEdge(int src, int dest) {
		adjacentList[src].add(dest);
		adjacentList[dest].add(src);
	}

	// A utility function to print the adjacency list
	// representation of graph
	void printGraph(Graph1 graph) {
		for (int v = 0; v < graph.V; v++) {
			System.out.println("Adjacency list of vertex " + v);
			System.out.print("head");
			for (Integer pCrawl : graph.adjacentList[v]) {
				System.out.print(" -> " + pCrawl);
			}
			System.out.println("\n");
		}
	}
	
	// A function used by DFS
	void DFSUtil(int s, boolean visited[]) {
		
		// Mark the current node as visited and print it
		visited[s] = true;
		System.out.print(s + " ");

		// Recur for all the vertices adjacent to this vertex
		Iterator<Integer> i = adjacentList[s].listIterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n]) {
				DFSUtil(n, visited);
			}
		}
	}

	// prints BFS traversal from a given source s
	void DFS(int s) {

		// Mark all the vertices as not visited(By default
		// set as false)
		boolean visited[] = new boolean[V];
		
		// Call the recursive helper function to print DFS traversal 
		DFSUtil(s, visited);
		
	}

}

public class DFS {

	public static void main(String[] args) {

		Graph1 g = new Graph1(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		// print the adjacency list representation of
		// the above graph
		g.printGraph(g);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.DFS(2);

	}

}
