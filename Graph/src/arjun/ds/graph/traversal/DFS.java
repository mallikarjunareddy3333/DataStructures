package arjun.ds.graph.traversal;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

class Node {
	String label;
	boolean visited = false;

	public Node(String label) {
		this.label = label;
	}

	public String getLabel() {
		return label;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Node)) {
			return false;
		}

		Node node2 = (Node) obj;
		if (this.label == node2.label) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		int prime = 31;
		int result = 0;

		result = result * prime + this.label != null ? this.label.hashCode() : 0;

		return result;
	}

	@Override
	public String toString() {
		return label;
	}
}

class Graph {
	Map<Node, LinkedList<Node>> adjacencyList = new HashMap<>();

	void addVertex(String label) {
		if (adjacencyList.get(new Node(label)) == null) {
			adjacencyList.put(new Node(label), new LinkedList<>());
		}
	}

	void addEdge(String v1, String v2) {
		if (adjacencyList.containsKey(new Node(v1)) && adjacencyList.containsKey(new Node(v2))) {
			adjacencyList.get(new Node(v1)).addFirst(new Node(v2));
			adjacencyList.get(new Node(v2)).addFirst(new Node(v1));
		}
	}

	void printAllVertices() {
		System.out.print("All vertices in the Graph: \n[ ");
		adjacencyList.entrySet().forEach((i -> System.out.print(i.getKey() + " ")));
		System.out.println("]");
	}

	void printAllEdges() {
		System.out.print("\nAll Edges in the Graph: \n[ ");
		adjacencyList.entrySet().forEach((i -> System.out.print("(" + i.getKey() + ", " + i.getValue() + ") ")));
		System.out.println("]");
	}

	void dfsTraversal(Node v, Graph graph) {

		System.out.print(v.label + " ");
		v.visited = true;
		
		Iterator<Node> it = graph.adjacencyList.get(v).listIterator();

		while (it.hasNext()) {
			Node node1 = it.next();
			if (!node1.visited)
				dfsTraversal(node1, graph);
		}
	}

}

public class DFS {

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

		graph.dfsTraversal(new Node("A"), graph);

	}

}
