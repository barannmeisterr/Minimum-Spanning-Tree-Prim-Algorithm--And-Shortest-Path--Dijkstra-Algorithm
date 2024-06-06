import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class Dijkstra {
	//-------------------------------------------------------------------
	// Title: Dijkstra class
	// Author: Arda Baran
	// Description: This class implements Dijkstra's algorithm to the Directed Graph.
	//Dijkstra's algorithm is used to find the minimum cost(Shortest path) from a single chosen source to all other vertices
	//which means load points in the directed graph
	//One of mixed Stack and Singly Linked List data structure named as SetOfNodes instance implemented in order to keep visited vertices and get the last added vertex to the set.
	//if a vertex presents in the nodeSet,it means that that vertex's shortest path distance is known.	
	//two dimensional boolean matrix and two dimensional integer matrix are implemented to get the matrices from directed graph.	
	//A directed graph data structure is instance implemented to perform Dijkstra's algorithm on that directed graph instance. 
	//In order to perform Dijkstra's algorithm ;
	//Step 1 : 
	//Set initial distances for all vertices: 0 for the source vertex, and infinity(Integer.MAX_VALUE) for all the other vertices.
	//Step 2:
	//Choose the unvisited vertex with the shortest distance from the start to be the current vertex. So the algorithm will always
	//selects the shortest distance from current vertices
	//Step 3:
	//For each of the current vertex's unvisited neighbor vertices, calculate the distance from the source and update the distance if
	//the new, calculated, distance is lower.
	//if the current vertex is 2 ,start is 0 then,target is 1  ;
	//Formula = shortest path distance to 2 from 0 = min{D(1),D(2)+C(2,1)}
	//Step 4:
	//Mark it as visited. A visited vertex is not checked again.
	//Step 5:
	//Do it until all vertices in the directed graph are added to nodeSet	
	//-------------------------------------------------------------		
int[][] adjMatrixW;
boolean[][] adjMatricC;
int[] shortestPathCost;
DirectedGraph g;
int source;
SetOfNodes nodeSet;//the set of vertices that shortest distance is known
int[] ancestors;//predocessors
public Dijkstra(DirectedGraph g) {
this.g = g;
this.adjMatrixW = g.getAdjMatrixWeighted();
this.adjMatricC = g.getAdjMatrixConnected();
this.shortestPathCost = new int[g.getNumOfVertices()];
this.nodeSet = new SetOfNodes(g.getNumOfVertices());
this.ancestors = new int[g.getNumOfVertices()];
for (int i = 0; i < g.getNumOfVertices(); i++) {
shortestPathCost[i] = Integer.MAX_VALUE;//all paths are initialized to infinity at the beginning
ancestors[i]=-1;//all prodecessors are initialized to -1 at the beginning
}
}
//getter and setters
public int[][] getAdjMatrixW() {
	return adjMatrixW;
}
public void setAdjMatrixW(int[][] adjMatrixW) {
	this.adjMatrixW = adjMatrixW;
}
public boolean[][] getAdjMatricC() {
	return adjMatricC;
}
public void setAdjMatricC(boolean[][] adjMatricC) {
	this.adjMatricC = adjMatricC;
}
public int[] getShortestPathCost() {
	return shortestPathCost;
}
public void setShortestPathCost(int[] shortestPathCost) {
	this.shortestPathCost = shortestPathCost;
}
public DirectedGraph getG() {
	return g;
}
public void setG(DirectedGraph g) {
	this.g = g;
}
public SetOfNodes getNodeSet() {
	return nodeSet;
}
public void setNodeSet(SetOfNodes nodeSet) {
	this.nodeSet = nodeSet;
}

public int linkCost(int v1,int v2) {
//-----------------------------------------
//Summary:the value of the edge weight between v1 and v2.
//--------------------------------------------	
	return adjMatrixW[v1][v2];
}
public void updateDistances(int currentVertex, int neighborOfCurrentVertex) {
//----------------------------------------------------------------------------
//Summary:the formula of D(neighborOfCurrentVertex)=min{D(neighborOfCurrentVertex),D(currentVertex)+c(currentVertex,neighborOfCurrentVertex)	
//is applied,then current vertex is set as the ancestor of neighborOfCurrentVertex.
//-------------------------------------------------------------------------------	
int updatedCost = shortestPathCost[currentVertex] + linkCost(currentVertex, neighborOfCurrentVertex);
if (updatedCost < shortestPathCost[neighborOfCurrentVertex]) {
shortestPathCost[neighborOfCurrentVertex] = updatedCost;
ancestors[neighborOfCurrentVertex]=currentVertex;   
}
    }
public void findMinWeightedVertexAndUpdateDistances() {
//----------------------------------------------------------------------------
//Summary:unvisited vertex with shortest path cost is chosen,all distances are updated , ancestors are set and the new discovered	
//with the shortest path cost is added to the nodeSet.
//-------------------------------------------------------------------------------			
int minWeight = Integer.MAX_VALUE;
int currentVertex = nodeSet.getLastAddedVertexInTheSet();
int minWeightedVertexIdx = -1;
        // Update distances
   for (int i = 0; i < getG().getNumOfVertices(); i++) {
      if (currentVertex != i && adjMatricC[currentVertex][i] && nodeSet.isContain(currentVertex) && !nodeSet.isContain(i)) {
        updateDistances(currentVertex, i);
            }
        }
        // Find the minimum weighted vertex
   for (int i = 0; i < getG().getNumOfVertices(); i++) {
       if (!nodeSet.isContain(i) && shortestPathCost[i] < minWeight) {
         minWeight = shortestPathCost[i];
           minWeightedVertexIdx = i;
            }
        }
        // Add the minimum weighted vertex to the set
        if (minWeightedVertexIdx != -1) {
            nodeSet.addNodeToSet(minWeightedVertexIdx);
        }
    }
public void dijkstraAlgorithm(int source) {
//----------------------------------------------------------------------------
//Summary:Performs Dijkstra's algorithm.Dijkstra's algorithm starts with a vertex named source.at the beginning the shortest 
//distance from source to itself is set to 0 , the vertices whose connected directly to the source are set to the value 
//of the linkCost between source and the neighbors of the source.Also ancestors are set for neighbors of source as source.
//the distance is set to 0 for vertices that are not directly connected directly with the source vertex.
//ancestors are set.after performing the dijkstra's algorithm ,shortest paths from a single source to all other vertices are
//printed.	
//-------------------------------------------------------------------------------
nodeSet.addNodeToSet(source);
shortestPathCost[source] = 0;
   for (int i = 0; i < getG().getNumOfVertices(); i++) {
     if (i != source && adjMatricC[source][i]) {
       shortestPathCost[i] = adjMatrixW[source][i];
     ancestors[i]=source;
     }
      }
while (!nodeSet.areAllShortestPathsKnown()) {
findMinWeightedVertexAndUpdateDistances();
}
System.out.println("The result is:");
for (int i = 0; i < getG().getNumOfVertices(); i++) {
	if(i!=source) {
		printPath(i);
	}
}
}
public void printPath(int destination) {
//----------------------------------------------------------------------    
//Summary:Prints the shortest paths and shortest path values from a single source to all other vertices in the directed graph.	
//-----------------------------------------------------------------------	
	if (shortestPathCost[destination] == Integer.MAX_VALUE) {
        System.out.println("No path exists to vertex " + destination);
        return;
    }
    List<Integer> path = new ArrayList<>();
    for (int at = destination; at != -1; at = ancestors[at]) {
        path.add(at);
    }
    Collections.reverse(path);
    System.out.print("Shortest Path From Source Point 0 To Destination Point "+destination+": ");
    for (int i = 0; i < path.size(); i++) {
        if (i != 0) {
            System.out.print(" ");
        }
        System.out.print(path.get(i));
    }
    System.out.println("---->Minimum Distance= " + shortestPathCost[destination]);
}
}