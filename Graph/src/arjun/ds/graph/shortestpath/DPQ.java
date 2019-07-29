package arjun.ds.graph.shortestpath;

//Java implementation of Dijkstra's Algorithm  
//using Priority Queue 

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class DPQ {

	private int dist[];
	private Set<Integer> settled;
	private PriorityQueue<Node> pq;
	private int V;
	List<List<Node>> adj;

	public DPQ(int V) {
		this.V = V;
		dist = new int[V];
		settled = new HashSet<Integer>();
		pq = new PriorityQueue<Node>(V, new Node());
	}

	// Function for Dijkstra's Algorithm
	public void dijkstra(List<List<Node>> adj, int src) {
		this.adj = adj;
		
		// step1: put all the vertices distances with max_value
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		
		// step2: Add source node to the priority queue
		// Distance to the source is 0
		dist[src] = 0;
		
		pq.add(new Node(src, 0));
		
		while (settled.size() != V) {
			int u = pq.remove().node;

			settled.add(u);

			e_Neighbours(u);
		}

	}

	// Function to process all the neighbours
	// of the passed node
	private void e_Neighbours(int u) {
		int edgeDistance = -1;
		int newDistance = -1;

		for (int i = 0; i < adj.get(u).size(); i++) {
			Node v = adj.get(u).get(i);

			// If current node hasn't already been processed
			if (!settled.contains(v)) {
				edgeDistance = v.cost;
				newDistance = dist[u] + edgeDistance;

				// If new distance is cheaper in cost
				if (newDistance < dist[v.node]) {
					dist[v.node] = newDistance;
				}

				// Add the current node to the queue
				pq.add(new Node(v.node, dist[v.node]));
			}

		}

	}

	public static void main(String[] args) {
		int V = 5;
		int source = 0;

		// Adjacency list representation of the
		// connected edges
		List<List<Node>> adj = new ArrayList<>();

		// Initialize list for every node
		for (int i = 0; i < V; i++) {
			List<Node> item = new ArrayList<Node>();
			adj.add(item);
		}

		// Inputs for the DPQ graph
		adj.get(0).add(new Node(1, 9));
		adj.get(0).add(new Node(2, 6));
		adj.get(0).add(new Node(3, 5));
		adj.get(0).add(new Node(4, 3));

		adj.get(2).add(new Node(1, 2));
		adj.get(2).add(new Node(3, 4));

		// Calculate the single source shortest path
		DPQ dpq = new DPQ(V);
		dpq.dijkstra(adj, source);

		// Print the shortest path to all the nodes
		// from the source node
		System.out.println("The shorted path from node :");
		for (int i = 0; i < dpq.dist.length; i++)
			System.out.println(source + " to " + i + " is " + dpq.dist[i]);
	}

}
