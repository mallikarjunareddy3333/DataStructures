package arjun.ds.graph.representation.edgeList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class Edge {
	int startVertex;
	int endVertex;
	int weight;

	public Edge(int startVertex, int endVertex, int weight) {
		this.startVertex = startVertex;
		this.endVertex = endVertex;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "(" + startVertex + "," + endVertex + ")";
	}

}

public class Graph {
	List<String> vertext_list = new ArrayList<>();
	List<Edge> edge_list = new ArrayList<>();

	boolean addVertex(String lable) {
		return vertext_list.add(lable);
	}

	Boolean addEdge(String startVertex, String endVertex, int weight) {
		Edge e = new Edge(vertext_list.indexOf(startVertex), vertext_list.indexOf(endVertex), weight);
		return edge_list.add(e);
	}

	void printVertices() {
		System.out.println("All vertices in the Graph: ");
		vertext_list.forEach(i -> System.out.print(i + " "));
	}

	void printEdges() {
		System.out.print("\n\nAll edges in the Graph: \n[");
		edge_list.forEach(e -> System.out.print(
				"(" + vertext_list.get(e.startVertex) + ", " + vertext_list.get(e.endVertex) + ", " + e.weight + ") "));
		System.out.println("]");
	}

	boolean findIsThereEdge(String v1, String v2) {

		int index1 = vertext_list.indexOf(v1);
		int index2 = vertext_list.indexOf(v2);

		return edge_list.stream().anyMatch((e) -> (e.startVertex == index1 && e.endVertex == index2
				|| e.startVertex == index2 && e.endVertex == index1));

	}

	void findAllAdjacentEdges(String v) {
		int index = vertext_list.indexOf(v);
		System.out.print("[");
		edge_list.stream().filter((e) -> (e.startVertex == index || e.endVertex == index)).collect(Collectors.toList())
				.forEach(e -> System.out
						.print("(" + vertext_list.get(e.startVertex) + ", " + vertext_list.get(e.endVertex) + ", " + e.weight + ")"));
		System.out.println("]");

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

		graph.printVertices();

		graph.addEdge("A", "B", 5);
		graph.addEdge("A", "C", 7);
		graph.addEdge("A", "D", 3);
		graph.addEdge("B", "E", 2);
		graph.addEdge("B", "F", 10);
		graph.addEdge("C", "G", 1);
		graph.addEdge("D", "H", 11);
		graph.addEdge("E", "H", 9);
		graph.addEdge("F", "H", 4);
		graph.addEdge("G", "H", 6);

		graph.printEdges();

		System.out.println("\nFind Edge between A and D: " + graph.findIsThereEdge("A", "D"));
		System.out.println("Find Edge between A and G: " + graph.findIsThereEdge("A", "G"));
		System.out.println("Find Edge between G and H: " + graph.findIsThereEdge("G", "H"));
		System.out.println("Find Edge between G and H: " + graph.findIsThereEdge("X", "H"));
		
		System.out.println("\nAll the adjacent edges to A: ");
		graph.findAllAdjacentEdges("A");
		
		System.out.println("\nAll the adjacent edges to H: ");
		graph.findAllAdjacentEdges("H");

	}

}
