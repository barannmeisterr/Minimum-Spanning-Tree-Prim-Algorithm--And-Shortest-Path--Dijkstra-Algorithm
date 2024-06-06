public class UndirectedGraph {
//-------------------------------------------------------------------
// Title: UndirectedGraph class
// Author: Arda Baran
// Description: This class implements Undirected Graph Data Structure with weighted edges.
//Prim's Minimum Spanning Tree algorithm can be applied on Undirected Graph.
//I defined two different adjancency matrix two dimensional array one of them is type of integer type, the other one is boolean type. 	
//boolean matrix:
//Since my purpose is to keep the connection status which means if any of two vertices in the undirected graph are connected
//with an edge , the value in the matrix at the location row = index of vertex1 , column = index of vertex 2 must be true.
//That's why I implemented boolean matrix
//For example:
//Let boolean a = adjMatrixConnected[index of vertex1][index of vertex2],then if a is true , we can say that vertex 1 is
//connected to vertex 2 and vertex 2 connected to vertex 1 since the graph is an undirected graph.	
//integer matrix:
//Since my purpose is to add connection between two vertices with weight of the edge that bounds two vertices in the 
//undirected graph, the value in the matrix at the location row = index of vertex1 , column = index of vertex 2 must be	
//equal to weight of the edge which connects vertex1 and vertex2.
//For example:
//Let int b = adjMatrixConnected[index of vertex1][index of vertex2],we can say that vertex 1 is connected to vertex 2	
//and vertex 2 connected to vertex 1 since the graph is an undirected graph and the weight of the edge which connects 
//vertex1 to vertex 2 and vertex 2 to vertex 1 equals to b.	
//-------------------------------------------------------------			
int numOfVertices;//Number Of Vertices in the undirected graph
int [][] adjMatrixWeighted;//matrix to keep weights and connections.
boolean [][] adjMatrixConnected;//matrix to keep only connection status.
public UndirectedGraph(int numOfVertices) {
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
//Summary:connects vertex1 to vertex 2 by an edge and the edge which connects vertex1 to vertex 2 and 
//vertex 2 to vertex 1 has a weight.Then sets the connection value between vertex1 to vertex 2 and vertex2 to vertex 1 as true.
//---------------------------------------------------------------------------------	
	adjMatrixWeighted[vertex1][vertex2]=weight;
    adjMatrixWeighted[vertex2][vertex1]=weight;
    adjMatrixConnected[vertex1][vertex2]=true;
    adjMatrixConnected[vertex2][vertex1]=true;
}
public void printMatrixWithWeight() {
//--------------------------------------------------------------------------------	
//Summary:prints the integer adjancency matrix ,the connected vertices and their connections weights in the undirected graph.
//---------------------------------------------------------------------------------			
	int[][]adjM=getAdjMatrixWeighted();
    for (int i = 0; i < numOfVertices; i++) {
        for (int j = 0; j < numOfVertices; j++) {
            if (adjM[i][j] != 0) {
                int weight = adjM[i][j];
                System.out.println(i + " " + j + " " + weight);
            }
        }
    }
System.out.println();
}
public void printMatrixBoolean() {
//--------------------------------------------------------------------------------	
//Summary:prints the boolean adjancency matrix.
//---------------------------------------------------------------------------------			
	boolean[][]adjM=getAdjMatrixConnected();
	    for (int i = 0; i < numOfVertices; i++) {
	        for (int j = 0; j < numOfVertices; j++) {	        
	                System.out.println(i + " " + j + " " + adjM[i][j]);
	            }	        
	    }
}
}
