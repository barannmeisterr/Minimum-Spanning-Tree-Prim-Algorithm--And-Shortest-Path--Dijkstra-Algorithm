//-------------------------------------------------------------------
// Title: SinglyLinkedList class
// Author: Arda Baran
// Description: This class implements Singly Linked List Data Structure.
//The list can be list of visited vertices which means virtual scope or can be mst path list thanks to two different constructor.
//-------------------------------------------------------------		
public class SinglyLinkedList {
ListNode root;
int capacity;//capacity is a limit to perform Prim's algorithm until all vertices in undirected graph are visited.
public SinglyLinkedList(int capacity) {
//------------------------------------------	
//Summary:Constructor for virtual scope list.
//------------------------------------------	
	this.root=null;
    this.capacity=capacity;    
}
public SinglyLinkedList() {
//--------------------------------------------
//Summary:Constructor for MST path list.	
//---------------------------------------------	
	this.root=null;
}
public int getCapacity() {
	return capacity;
}
public void setCapacity(int capacity) {
	this.capacity = capacity;
}
public boolean AreAllVerticesAdded() {
//----------------------------------------------------------------------------------------------------
//Summary:Returns true when all vertices in the undirected graph are added to the virtual scope list.
//----------------------------------------------------------------------------------------------------	
	return (size()==getCapacity());
}
public ListNode addVertexToVirtualScope(ListNode n,int data) {
//---------------------------------------------------------------------
//Summary:adds vertex to list recursively after vertex is visited.	
//---------------------------------------------------------------------	
	if(n==null) {		
		return new ListNode(data);       	
	}	
	n.setNext(addVertexToVirtualScope(n.getNext(),data));	
return n;
}
public int size() {
//----------------------------------------------------------
//Summary:Tracks the current size of the List.	
//----------------------------------------------------------	
	int count = 0 ;
	ListNode current =root;
while(current!=null) {
	count++;
current = current.getNext();
}
return count ;
}
public int[] getVertices(SinglyLinkedList l) {
//----------------------------------------------------------------------------------------------------------------
//Summary:returns all vertices that are present in the virtual scope list.Takes parameter as a type of SinglyLinkedList.
//----------------------------------------------------------------------------------------------------------------	
int[] vertices=new int[l.size()];	
if(l.root==null) {
	return null;
}
if(l.root!=null && l.size()==1) {
	vertices[0]=l.root.getData();
}
ListNode curr = root;
int i = 0;
while(curr!=null && i<l.size()) {
	vertices[i]=curr.getData();
    curr=curr.getNext();
i++;
}
return vertices;
}
public void addVertexToVirtualScope(int data) {
//------------------------------------------------
//Summary:helper method to add vertex to virtual scope.
//-------------------------------------------------	
	root=addVertexToVirtualScope(root,data);
}
public boolean isContain(ListNode n,int data) {
//-------------------------------------------------------------------------------------------------------------
//Summary:Checks the parameter are present in the list recursively.If parameter vertex is in the list already, returns true.
//--------------------------------------------------------------------------------------------------------------	
	if(n==null) {
		return false;
	}
if(n.getData()==data) {
	return true;
}
return isContain(n.getNext(),data);
}
public boolean isContain(int data) {
	return isContain(root,data);
}
public ListNode addMstPath(ListNode n,int sourceVertex,int destVertex,int edgeWeight) {
//---------------------------------------------------------------------
//Summary:adds source vertex ,destination vertex and the weight of edge between source and destination to the mst path list recursively.	
//---------------------------------------------------------------------		
	if(n==null) {
		return new ListNode(sourceVertex,destVertex,edgeWeight);
	}
n.setNext(addMstPath(n.getNext(),sourceVertex,destVertex,edgeWeight));
return n;
}
public void addMstPath(int sourceVertex,int destVertex,int edgeWeight) {
	root=addMstPath(root,sourceVertex,destVertex,edgeWeight);
}
public void printMstPath(ListNode n) {
//---------------------------------------------------------------------------------------------------------------
//Summary:Prints the MST path list.If the connection is not contain zero the lowest number is written in the path.	
//----------------------------------------------------------------------------------------------------------------	
if(n==null) {
return;
}
ListNode curr=root;
while(curr!=null) {
if(curr.getSourceVertex()<curr.getDestinationVertex()) {
System.out.println(curr.getSourceVertex()+" "+curr.getDestinationVertex()+" "+curr.getEdgeWeight());	
}else {
	System.out.println(curr.getDestinationVertex()+" "+curr.getSourceVertex()+" "+curr.getEdgeWeight());	
}
curr=curr.getNext();
}
}
public void printMstPath() {
	printMstPath(root);
}
}
