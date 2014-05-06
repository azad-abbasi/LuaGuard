import java.util.Vector;

public class Node {
	static String name;
	static String nameOfParent;
	
	static Vector<Node> children = new Vector<Node>();			//we use a vector since we don't know how many children each node has
	static Node parent;
	
	Node(String n, String nop){
		name = n;
		nameOfParent = nop;
		children.add(null); 					//each node is considered to be a leaf initially
		parent = null;							//parent is assumed to be null initially
	}
	
	public static void addParent(Node p){
		parent = p;								//add parent after it's been declared
	}
	
	
}
