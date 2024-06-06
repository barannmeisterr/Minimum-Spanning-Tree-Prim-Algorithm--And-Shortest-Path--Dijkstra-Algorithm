public class PrimMain {
	//-------------------------------------------------------------------
	// Title: Main class
	// Author: Arda Baran
	// Description: the undirected graph initialized and MST result is printed with value.
	//-------------------------------------------------------------	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraph graph = new UndirectedGraph(5);
		graph.addEdge(0, 1, 120);
	 
		graph.addEdge(0, 2, 160);
		
		graph.addEdge(0, 3, 300);

		graph.addEdge(0, 4, 450);

	   // graph.addEdge(1, 0, 120);
	    graph.addEdge(1, 2, 200);
	    graph.addEdge(1, 3, 410);
	    graph.addEdge(1, 4, 500);

	    //graph.addEdge(2, 0, 160);
	    //graph.addEdge(2, 1, 200);
	    
	    graph.addEdge(2, 3, 420);
	    graph.addEdge(2, 4, 400);

	    //graph.addEdge(3, 0, 300);
	    //graph.addEdge(3, 1, 410);
	    //graph.addEdge(3, 2, 420);
	    graph.addEdge(3, 4, 510);
	   //graph.addEdge(4, 0, 450);
	    //graph.addEdge(4, 1, 500);
	   // graph.addEdge(4, 2, 400);
	    //graph.addEdge(4, 3, 510);

		Prim p = new Prim(graph);
		
		p.PrimsAlgorithm(0);
	System.out.println("----------------------------------------------------------------------------------------------");	
	UndirectedGraph g = new UndirectedGraph(6);
	g.addEdge(0, 1, 2);
	g.addEdge(0, 2, 1);
	g.addEdge(2, 3, 1);
	g.addEdge(1, 4, 2);
	g.addEdge(1, 5, 5);
	g.addEdge(2, 5, 2);
	g.addEdge(3, 5, 5);
	g.addEdge(3, 4, 7);
	Prim pp = new Prim(g);
	pp.PrimsAlgorithm(0);
	
	}

}
