public class DirectedGraph {
	//-------------------------------------------------------------------
	// Title: DirectedGraph class
	// Author: Arda Baran
	// Description: This class implements Directed Graph Data Structure with weighted edges.
	//Dijkstra's algorithm can be applied on Directed Graph.
	//I defined two different adjancency matrix two dimensional array one of them is type of integer type, the other one is boolean type. 	
	//boolean matrix:
	//Since my purpose is to keep the connection status which means if any of two vertices in the Directed Graph are connected
	//with an edge , the value in the matrix at the location row = index of vertex1 , column = index of vertex 2 must be true.
	//That's why I implemented boolean matrix
	//For example:
	//Let boolean a = adjMatrixConnected[index of vertex1][index of vertex2],then if a is true , we can say that vertex 1 is
	//connected to vertex 2 with a direct edge.
	//integer matrix:
	//Since my purpose is to add connection between two vertices with weight of the edge that bounds two vertices in the 
	//directed graph, the value in the matrix at the location row = index of vertex1 , column = index of vertex 2 must be	
	//equal to weight of the edge which connects vertex1 and vertex2.
	//For example:
	//Let int b = adjMatrixConnected[index of vertex1][index of vertex2],we can say that vertex 1 is connected to vertex 2	
	//with a direct edge and this edge has weight. 
	//	
int numOfVertices;//Number Of Vertices in the directed graph
int[][]adjMatrixWeighted;//matrix to keep weights and connections.
boolean [][] adjMatrixConnected;//matrix to keep only connection status.
public DirectedGraph(int numOfVertices) {
	this.numOfVertices=numOfVertices;
	this.adjMatrixWeighted=new int[numOfVertices][numOfVertices];
	this.adjMatrixConnected=new boolean[numOfVertices][numOfVertices];
}
//getter and setters
public int getNumOfVertices() {
	return numOfVertices;
}
public void setNumOfVertices(int numOfVertices) {
	this.numOfVertices = numOfVertices;
}
public int[][] getAdjMatrixWeighted() {
	return adjMatrixWeighted;
}
public void setAdjMatrixWeighted(int[][] adjMatrixWeighted) {
	this.adjMatrixWeighted = adjMatrixWeighted;
}
public boolean[][] getAdjMatrixConnected() {
	return adjMatrixConnected;
}
public void setAdjMatrixConnected(boolean[][] adjMatrixConnected) {
	this.adjMatrixConnected = adjMatrixConnected;
}
public void addEdge(int vertex1,int vertex2,int weight) {
	//--------------------------------------------------------------------------------	
	//Summary:adds direct edge from vertex 1 to vertex 2 and this edge has weight.  
	//Then sets the connection value from vertex1 to vertex 2  as true.
	//---------------------------------------------------------------------------------		
	adjMatrixWeighted[vertex1][vertex2]=weight;
	adjMatrixConnected[vertex1][vertex2]=true;
}
}
