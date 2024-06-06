public class ListNode {
//-------------------------------------------------------------------
// Title: ListNode class
// Author: Arda Baran
// Description: This class represents vertices and mst paths.Vertices are consist of index of vertex
//Mst Path consists of the index of source vertex,the index of destination vertex and edgeWeight.
//-------------------------------------------------------------	
int data,sourceVertex,destinationVertex,edgeWeight;
ListNode next;
public ListNode(int data) {
//----------------------------------
//Summary:Constructor for vertex.
//----------------------------------	
	this.data=data;
	this.next=null;
}
public ListNode(int sourceVertex,int destinationVertex,int edgeWeight) {
//----------------------------------------------------------------------	
//Summary:Constructor for mst path.
//----------------------------------------------------------------------	
	this.sourceVertex=sourceVertex;
    this.destinationVertex=destinationVertex;
    this.edgeWeight=edgeWeight;
    this.next=null;
}
public int getSourceVertex() {
	return sourceVertex;
}
public void setSourceVertex(int sourceVertex) {
	this.sourceVertex = sourceVertex;
}
public int getDestinationVertex() {
	return destinationVertex;
}
public void setDestinationVertex(int destinationVertex) {
	this.destinationVertex = destinationVertex;
}
public int getEdgeWeight() {
	return edgeWeight;
}
public void setEdgeWeight(int edgeWeight) {
	this.edgeWeight = edgeWeight;
}
public int getData() {
	return data;
}
public void setData(int data) {
	this.data = data;
}
public ListNode getNext() {
	return next;
}
public void setNext(ListNode next) {
	this.next = next;
}
}