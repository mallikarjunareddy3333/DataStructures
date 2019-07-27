package arjun.ds.graph.representation.edgeList;

import java.util.ArrayList;
import java.util.List;

class Edge {
	int startVertex;
	int endVertex;
	int weight;

	public Edge(int startVertex, int endVertex, int weight) {
		this.startVertex = startVertex;
		this.endVertex = endVertex;
		this.weight = weight;
	}

}

public class GraphWithEdgeList {
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
		vertext_list.forEach(i -> System.out.print(i + " "));
	}

	void printEdges() {
		System.out.print("\n[");
		edge_list.forEach(e -> System.out
				.print("(" + vertext_list.get(e.startVertex) + ", " + vertext_list.get(e.endVertex) + ") "));
		System.out.println("]");
	}

	public static void main(String[] args) {
		GraphWithEdgeList graph = new GraphWithEdgeList();
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
		graph.printEdges();
	}

}
