package arjun.ds.graph.representation.adjacencyList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Graph {

	Map<String, LinkedList<String>> adjacencyList = new HashMap<>();

	void addVertex(String label) {
		if (!adjacencyList.containsKey(label)) {
			adjacencyList.put(label, new LinkedList<>());
		}
	}

	void addEdge(String v1, String v2) {
		if (adjacencyList.get(v1) != null && adjacencyList.get(v2) != null) {
			adjacencyList.get(v1).addFirst(v2);
			adjacencyList.get(v2).addFirst(v1);
		}
	}

	void printAllVertices() {
		System.out.print("All vertices in the Graph: \n[");
		adjacencyList.entrySet().forEach((i -> System.out.print(i.getKey() + ", ")));
		System.out.println("]");
	}

	void printAllEdges() {
		System.out.print("\nAll Edges in the Graph: \n[");
		adjacencyList.entrySet().forEach((i -> System.out.print("(" + i.getKey() + ", " + i.getValue() + ") ")));
		System.out.println("]");
	}

	boolean findIsThereEdge(String v1, String v2) {
		return adjacencyList.get(v1) != null ? adjacencyList.get(v1).contains(v2) : false;
	}

	void findAllAdjacentEdges(String v) {
		if (adjacencyList.get(v) != null) {
			System.out.print("[");
			adjacencyList.get(v).forEach(i -> System.out.print(i + " "));
			System.out.println("]");
		} else {
			System.out.println(v + " is not a valid vertex");
		}
	}

	public static void main(String[] args) {

		Graph graph = new Graph();
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");
		graph.addVertex("H");

		graph.printAllVertices();

		graph.addEdge("A", "B");
		graph.addEdge("A", "C");
		graph.addEdge("A", "D");
		graph.addEdge("B", "E");
		graph.addEdge("B", "F");
		graph.addEdge("C", "G");
		graph.addEdge("D", "H");
		graph.addEdge("E", "H");
		graph.addEdge("F", "H");
		graph.addEdge("G", "H");

		graph.printAllEdges();

		System.out.println("\nFind Edge between A and D: " + graph.findIsThereEdge("A", "D"));
		System.out.println("Find Edge between A and G: " + graph.findIsThereEdge("A", "G"));
		System.out.println("Find Edge between G and H: " + graph.findIsThereEdge("G", "H"));
		System.out.println("Find Edge between X and H: " + graph.findIsThereEdge("X", "H"));

		System.out.println("\nAll the adjacent edges to A: ");
		graph.findAllAdjacentEdges("A");

		System.out.println("\nAll the adjacent edges to H: ");
		graph.findAllAdjacentEdges("H");

		System.out.println("\nAll the adjacent edges to X: ");
		graph.findAllAdjacentEdges("X");

	}

}
