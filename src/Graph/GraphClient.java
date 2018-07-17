package Graph;

import java.util.HashMap;

/**
 * @author Rishabh
 * 
 * @date 07-Jul-2018
 */

public class GraphClient {

	public static void main(String[] args) {

		Graph graph = new Graph();

		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");

		graph.addEdge("A", "B", 1);
		graph.addEdge("A", "D", 10);
		graph.addEdge("C", "B", 1);
		graph.addEdge("C", "D", 5);
		graph.addEdge("D", "E", 2);
		graph.addEdge("E", "G", 2);
		graph.addEdge("E", "F", 7);

		graph.addEdge("G", "F", 3);

		// graph.removeEdge("G", "F");
		graph.display();

		// System.out.println(graph.hasPath("A", "F", new HashMap<>()));
		// System.out.println(graph.BFS("A", "F"));
		// System.out.println(graph.DFS("A", "F"));
		// graph.BFT();
		System.out.println();
		// graph.DFT();
		System.out.println();
		// System.out.println(graph.isCyclic());
		// System.out.println(graph.isConnected());
		// System.out.println(graph.isTree());
		// System.out.println(graph.getCC());
		// System.out.println(graph.Bipartite());
		graph.prims().display();
	}

}
