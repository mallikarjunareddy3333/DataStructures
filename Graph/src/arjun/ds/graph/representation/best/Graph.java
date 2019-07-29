package arjun.ds.graph.representation.best;

import java.util.LinkedList;

public class Graph {

	int V;

	LinkedList<Integer> adjacentList[];

	public Graph(int V) {
		this.V = V;
		adjacentList = new LinkedList[V];
		for (int i = 0; i < V; i++) {
			adjacentList[i] = new LinkedList<>();
		}
	}

	void addEdge( int src, int dest) {
		adjacentList[src].add(dest);
		adjacentList[dest].add(src);
	}

	// A utility function to print the adjacency list
	// representation of graph
	static void printGraph(Graph graph) {
		for (int v = 0; v < graph.V; v++) {
			System.out.println("Adjacency list of vertex " + v);
			System.out.print("head");
			for (Integer pCrawl : graph.adjacentList[v]) {
				System.out.print(" -> " + pCrawl);
			}
			System.out.println("\n");
		}
	}

	public static void main(String[] args) {
		// create the graph given in above figure
		int V = 5;
		Graph graph = new Graph(V);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		// print the adjacency list representation of
		// the above graph
		printGraph(graph);
	}

}
