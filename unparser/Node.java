import java.util.Vector;

public class Node {
	String name;
	String nameOfParent;
	
	Vector<Node> children = new Vector<Node>();			//we use a vector since we don't know how many children each node has
	Node parent;
	Node root;
	
	Node(String n){
		name = n;
		children.add(null); 					//each node is considered to be a leaf initially
		parent = root;							//parent is assumed to be null initially
	}
	
	public void setParent(String p){
		nameOfParent = p;
		parent = new Node(p);								//add parent after it's been declared
	}
	
	public Node getParent(){
		return parent;
	}
	
	public void setChild(String ch){
		children.add(new Node(ch));
	}
	
	public Node getChild(int i){
		return children.get(i);
	}
}
