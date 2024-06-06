public class Prim {
//-------------------------------------------------------------------
// Title: Prim class
// Author: Arda Baran
// Description: This class implements Prim's algorithm to the Undirected Graph.
//Prim's algorithm is used to find the minimum spanning tree path and the minimum spanning tree value.
//One of Singly Linked List data structure instance implemented in order to keep visited vertices and we can add a new minimum weighted neighbor	
//that we can reach from the vertices in present in the virtual scope vertices list.	
//The other one of singly linked list data structure instance is implemented in order to keep mst paths.
//two dimensional boolean matrix and two dimensional integer matrix are implemented to get the matrices from undirected graph.	
//An undirected graph data structure is instance implemented to perform Prim's algorithm on that undirected graph instance. 
//In order to perform Prim's algorithm ;
//Step 1 : 
//A virtual scope is defined which keeps all visited vertices while performing Prim's algorithm.
//Step 2:
//an arbitrary vertex is selected and this selected arbitrary vertex acts as the starting vertex of the Minimum	Spanning Tree.
//Step 3:
//add the arbitrary vertex to the virtual scope.
//Step 4:
//Find the neighbors of arbitrary vertex then select the one of them which is connected with arbitrary vertex and has the 	
//minimum weight of edge cost.add that neighbor to the virtual scope then add to mst path list arbitrary vertex as source vertex,
//the neighbor of arbitrary vertex which has minimum edge weight as destination vertex,and the edge weight between arbitrary  	
//vertex and the neighbor of arbitrary vertex which has minimum edge weight.
//Step 5:
//Do it until all vertices in the undirected graph are added to the virtual scope list.	
//-------------------------------------------------------------				
int[][]adjMatrixWeighted;
boolean[][] adjMatrixConnections;
UndirectedGraph graph;
SinglyLinkedList verticesInVirtualScope;
SinglyLinkedList mstPathList;
int minimumSpanningTreeValue;
public Prim(UndirectedGraph graph) {
	this.graph=graph;
this.adjMatrixWeighted=graph.getAdjMatrixWeighted();
this.adjMatrixConnections=graph.getAdjMatrixConnected();
this.verticesInVirtualScope=new SinglyLinkedList(graph.getNumOfVertices());
this.mstPathList=new SinglyLinkedList();
this.minimumSpanningTreeValue=0;
}
public int getMinimumSpanningTreeValue() {
	return minimumSpanningTreeValue;
}
public void setMinimumSpanningTreeValue(int minimumSpanningTreeValue) {
	this.minimumSpanningTreeValue = minimumSpanningTreeValue;
}
public int[][] getAdjMatrixWeighted() {
	return adjMatrixWeighted;
}
public void setAdjMatrixWeighted(int[][] adjMatrixWeighted) {
	this.adjMatrixWeighted = adjMatrixWeighted;
}
public boolean[][] getAdjMatrixConnections() {
	return adjMatrixConnections;
}
public void setAdjMatrixConnections(boolean[][] adjMatrixConnections) {
	this.adjMatrixConnections = adjMatrixConnections;
}
public UndirectedGraph getGraph() {
	return graph;
}
public void setGraph(UndirectedGraph graph) {
	this.graph = graph;
}
public SinglyLinkedList getVerticesInVirtualScope() {
	return verticesInVirtualScope;
}
public void setVerticesInVirtualScope(SinglyLinkedList verticesInVirtualScope) {
	this.verticesInVirtualScope = verticesInVirtualScope;
}
public SinglyLinkedList getMstPathList() {
	return mstPathList;
}
public void setMstPathList(SinglyLinkedList mstPathList) {
	this.mstPathList = mstPathList;
}
public void findMinimumWeightEdge() {
//-----------------------------------------------------------------------------------------
//Summary:finds the minimum cost neighbor from the scope.	
//after finding minimum cost , the minimum cost vertex index is added to scope list.	
//the source ,destination and the cost between source and destination are added to the mst path list.	
//the mst value is updated when a new unvisited vertex is found.
//--------------------------------------------------------------------------------------------	
int destVertex=-1;//destination vertex index
int mstValue=getMinimumSpanningTreeValue();//the current mst value
int min = Integer.MAX_VALUE;
int[] verticesInScope=getVerticesInVirtualScope().getVertices(getVerticesInVirtualScope());//the vertices in the scope
int numOfVerticesInScope= verticesInScope.length;//the current size of the scope
int [][] weights=getAdjMatrixWeighted();//adj matrix weights
int sourceVertex=-1;//source vertex index
boolean [][]connections=getAdjMatrixConnections();//connection matrix between vertices
for(int i = 0 ; i<numOfVerticesInScope;i++ ) {
	for(int j = 0;j<getGraph().getNumOfVertices();j++) {
   if(connections[i][j]&&!verticesInVirtualScope.isContain(j)&&verticesInVirtualScope.isContain(i)) {   
//checks all reachable vertices from the virtual scope,if source is added already to the scope list and the reachable 	   
//vertices is not added to the scope list yet...	   
	   if(weights[i][j]<min) {
//find the minimum edge cost		  		   
		   min=weights[i][j];
	   }
   }
if(weights[i][j]==min&&verticesInVirtualScope.isContain(i)&&!verticesInVirtualScope.isContain(j)) {
//set the source and the new found reachable destination indexes	
	sourceVertex=i;
	destVertex=j;    
}
	}
}
verticesInVirtualScope.addVertexToVirtualScope(destVertex);//add the new discovered minimum cost vertex to the scope list
mstPathList.addMstPath(sourceVertex, destVertex, min);//add the new discovered minimum cost vertex and its parent and their weights to the mst path list
mstValue=mstValue+min;
setMinimumSpanningTreeValue(mstValue);//update mst value
}
public void PrimsAlgorithm(int startVertex) {
//----------------------------------------------------------
//Summary:Performs Prim's algorithm.
//Prim's algorithm starts with chosen arbitrary/start vertex	
//-----------------------------------------------------------
verticesInVirtualScope.addVertexToVirtualScope(startVertex);//add arbitrary vertex to the scope list as first step	
while(!verticesInVirtualScope.AreAllVerticesAdded()) {
//perform the same steps until all vertices in the undirected graph are added to the scope list.
	findMinimumWeightEdge();  
}
printMst();//In the last step,print the output.
}
public void printMst() {
//-----------------------------------------------------
//Summary:prints the mst value and paths.	
//-----------------------------------------------------	
getGraph().printMatrixWithWeight();
System.out.println("The Minimum Spanning Tree Path");
getMstPathList().printMstPath();
System.out.println();
System.out.println("The Minimum Spanning Tree value= " + getMinimumSpanningTreeValue());
}
}
