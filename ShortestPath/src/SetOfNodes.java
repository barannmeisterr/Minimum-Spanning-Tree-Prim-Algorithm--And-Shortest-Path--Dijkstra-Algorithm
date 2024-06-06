public class SetOfNodes {
	//-------------------------------------------------------------------
	// Title: SetOfNodes class
	// Author: Arda Baran
	// Description: This class implements Mixed Singly Linked List and Stack data structure.
	//in order to add vertex which distances is absouletly known and get the last added vertex.
	//------------------------------------------------------------------
	Node root;
	int capacity;
	public SetOfNodes(int capacity) {
		this.capacity=capacity;
		this.root=null;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int size() {
		int count=0;
		Node curr=root;
		while(curr!=null) {
			count++;
			curr=curr.getNext();
		}
	return count;
	}
	public boolean areAllShortestPathsKnown() {
		return (size()==getCapacity());
	}
	public Node addNodeToSet(Node n,int vertexIdx) {
	//--------------------------------------------------
	//Summary:adds vertex to the set recursively.
	//--------------------------------------------------	
		if(n==null) {
			return new Node(vertexIdx);
		}
	n.setNext(addNodeToSet(n.getNext(),vertexIdx));
	return n;
	}
	public void addNodeToSet(int vertex) {
	root=addNodeToSet(root,vertex);	
	}
	public Node getLastAddedNodeInTheSet() {
	//--------------------------------------------------------
	//Summary:Returns the last element of the list.Stack data structure is referenced.	
	//--------------------------------------------------------	
		if(root==null) {
			return null;
		}
	if(root.getNext()==null) {
		return root;
	}
	Node curr=root;
	while(curr.getNext()!=null) {
		curr=curr.getNext();
	}
	return curr;
	}
	public int getLastAddedVertexInTheSet() {
		return getLastAddedNodeInTheSet().getVertexId();
	}
	public boolean isContain(Node n ,int vertex) {
		if(n==null) {
			return false;
		}
	if(n.getVertexId()==vertex) {
		return true;
	}
	return isContain(n.getNext(),vertex);
	}
	public boolean isContain(int vertex) {
		return isContain(root,vertex);
	}
}