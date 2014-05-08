import java.util.Vector;

public class Node {
	String name;
	String nameOfParent;
	
	Vector<Node> children = new Vector<Node>();			//we use a vector since we don't know how many children each node has
	Node parent;
	Node root;
	
	Node(String n){
		name = n;
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
	
	public void addChild(Node ch, int i){
		children.set(i, ch);
	}
	
	public Node getChild(int i){
		return children.get(i);
	}
	
	public Vector<Node> getChildren(){
		return children;
	}
	
	public void print(){
		System.out.println("Name:" + name);
		System.out.println("Parent:" + nameOfParent);
		
		System.out.println("Children:");
		for(Node ch : children){
			if (ch != null){
				System.out.println(ch.name);
			}
			else{
				System.out.print("No children");
			}
			
		}
		
		System.out.println(" ");
	}
}
