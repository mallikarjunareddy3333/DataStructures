package arjun.ds.graph.traversal;

import java.util.Iterator;
import java.util.LinkedList;

class Graph {

	int V;

	LinkedList<Integer> adjacentList[];

	public Graph(int V) {
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
	void printGraph(Graph graph) {
		for (int v = 0; v < graph.V; v++) {
			System.out.println("Adjacency list of vertex " + v);
			System.out.print("head");
			for (Integer pCrawl : graph.adjacentList[v]) {
				System.out.print(" -> " + pCrawl);
			}
			System.out.println("\n");
		}
	}

	// prints BFS traversal from a given source s
	void BFS(int s) {

		// Mark all the vertices as not visited(By default
		// set as false)
		boolean visited[] = new boolean[V];

		// create a queue for BFS
		LinkedList<Integer> queue = new LinkedList<>();

		visited[s] = true;
		queue.add(s);

		while (queue.size() != 0) {
			s = queue.poll();
			System.out.print(s + " ");
			// Get all adjacent vertices of the dequeued vertex s
			// If a adjacent has not been visited, then mark it
			// visited and enqueue it
			Iterator<Integer> i = adjacentList[s].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					visited[n] = true;
					queue.add(n);
				}
			}
		}

	}

}

public class BFS {

	public static void main(String[] args) {

		Graph g = new Graph(4);

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

		g.BFS(2);

	}

}
