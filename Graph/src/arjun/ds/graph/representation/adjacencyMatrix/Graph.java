package arjun.ds.graph.representation.adjacencyMatrix;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Graph {

	String[] vertex_list = { "A", "B", "C", "D", "E", "F", "G", "H" };
	int[][] edgeList = new int[8][8];

	{
		for (int i = 0; i < vertex_list.length; i++) {
			for (int j = 0; j < vertex_list.length; j++) {
				edgeList[i][j] = -1;
			}
		}
	}

	boolean addEdge(String v1, String v2, int weight) {
		int index1 = Stream.of(vertex_list).collect(Collectors.toList()).indexOf(v1);
		int index2 = Stream.of(vertex_list).collect(Collectors.toList()).indexOf(v2);

		if (index1 != -1 && index2 != -1) {
			edgeList[index1][index2] = weight;
			edgeList[index2][index1] = weight;
			return true;
		}

		return false;
	}

	void printAllVertices() {
		System.out.print("All Vertices: [");
		for (int i = 0; i < vertex_list.length; i++) {
			System.out.print(vertex_list[i] + " ");
		}
		System.out.println("]");
	}

	void printAllEdges() {
		System.out.print("All Edges: [");
		for (int i = 0; i < vertex_list.length; i++) {
			for (int j = 0; j < vertex_list.length; j++) {
				if (edgeList[i][j] != -1) {
					System.out.print("(" + vertex_list[i] + ", " + vertex_list[j] + ", " + edgeList[i][j] + ") ");
				}
			}
		}

		System.out.println("]");
	}

	boolean findIsThereEdge(String v1, String v2) {

		int index1 = Stream.of(vertex_list).collect(Collectors.toList()).indexOf(v1);
		int index2 = Stream.of(vertex_list).collect(Collectors.toList()).indexOf(v2);

		return (index1 != -1 && index2 != -1) && edgeList[index1][index2] != -1 ? true : false;

	}

	void findAllAdjacentEdges(String v) {
		int index1 = Stream.of(vertex_list).collect(Collectors.toList()).indexOf(v);
		
		if ( index1 == -1 ) {
			System.out.println(v + " not a valid vertex.");
			return;
		}
		
		for (int j = 0; j < vertex_list.length; j++) {
			if (edgeList[index1][j] != -1) {
				System.out.print("(" + vertex_list[index1] + ", " + vertex_list[j] + ", " + edgeList[index1][j] + ") ");
			}
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph();
		graph.printAllVertices();
		graph.printAllEdges();

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
