
public class DijkstraMain {
	//-------------------------------------------------------------------
	// Title: Main class
	// Author: Arda Baran
	// Description: graph is initialized and shortest paths and distances to load points from a single source printed.
	//------------------------------------------------------------------	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DirectedGraph graph = new DirectedGraph(4);
		graph.addEdge(0, 1, 200);
		graph.addEdge(0, 3, 100);
		graph.addEdge(1, 0, 200);
		graph.addEdge(1, 2, 240);
		graph.addEdge(1, 3, 197);
		graph.addEdge(2, 0, 200);
		graph.addEdge(2, 1, 240);
		graph.addEdge(2, 3, 100);
		graph.addEdge(3, 0, 100);
		graph.addEdge(3, 1, 197);
		graph.addEdge(3, 2, 100);
		Dijkstra d = new Dijkstra(graph);	
		d.dijkstraAlgorithm(0);


		System.out.println("---------------------------------------------------------------");	
		DirectedGraph g = new DirectedGraph(9);
		g.addEdge(0, 1, 4);
		g.addEdge(1, 0, 4);
		g.addEdge(0, 7, 8);
		g.addEdge(7, 0, 8);
		g.addEdge(1, 2, 8);
		g.addEdge(2, 1, 8);
		g.addEdge(1, 7, 11);
		g.addEdge(7, 1, 11);
		g.addEdge(2, 3, 7);
		g.addEdge(3, 2, 7);
		g.addEdge(2, 8, 2);
		g.addEdge(8, 2, 2);
		g.addEdge(2, 5, 4);
		g.addEdge(5, 2, 4);
		g.addEdge(3, 4, 9);
		g.addEdge(4, 3, 9);
		g.addEdge(3, 5, 14);
		g.addEdge(5, 3, 14);
		g.addEdge(4, 5, 10);
		g.addEdge(5, 4, 10);
		g.addEdge(5, 6, 2);
		g.addEdge(6, 5, 2);
		g.addEdge(6, 7, 1);
		g.addEdge(7, 6, 1);
		g.addEdge(6, 8, 6);
		g.addEdge(8, 6, 6);
		g.addEdge(7, 8, 7);
		g.addEdge(8, 7, 7);
		Dijkstra dd = new Dijkstra(g);	
		dd.dijkstraAlgorithm(0);

		System.out.println("---------------------------------------------------------------");	
		DirectedGraph gg = new DirectedGraph(6);
		gg.addEdge(0, 1, 5);
		gg.addEdge(1, 0, 5);
		gg.addEdge(0, 2, 3);
		gg.addEdge(2, 0, 3);
		gg.addEdge(0, 3, 7);
		gg.addEdge(3, 0, 7);
		gg.addEdge(1, 4, 7);
		gg.addEdge(4, 1, 7);
		gg.addEdge(1, 5, 9);
		gg.addEdge(5, 1, 9);
		gg.addEdge(1, 2, 4);
		gg.addEdge(2, 1, 4);
		gg.addEdge(2, 3, 3);
		gg.addEdge(3, 2, 3);
		gg.addEdge(2, 4, 8);
		gg.addEdge(4, 2, 8);
		gg.addEdge(3, 4, 4);
		gg.addEdge(4, 3, 4);
		gg.addEdge(4, 5, 2);
		gg.addEdge(5, 4, 2);
		Dijkstra ddd = new Dijkstra(gg);	
		ddd.dijkstraAlgorithm(0);

	}

}
