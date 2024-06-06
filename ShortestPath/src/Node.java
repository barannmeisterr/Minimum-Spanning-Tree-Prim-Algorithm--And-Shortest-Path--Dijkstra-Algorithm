public class Node {
//-------------------------------------------------------------------
// Title: Node class
// Author: Arda Baran
// Description: This class implements Node structure of Mixed Singly Linked List and Stack data structure.
//------------------------------------------------------------------	
int vertexId;
Node next;
public Node(int vertexId) {
	this.vertexId=vertexId;
	this.next=null;
}
public int getVertexId() {
	return vertexId;
}
public void setVertexId(int vertexId) {
	this.vertexId = vertexId;
}
public Node getNext() {
	return next;
}
public void setNext(Node next) {
	this.next = next;
}
}
