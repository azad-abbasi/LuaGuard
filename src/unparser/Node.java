/**
 * Created by Azad on 5/5/2014.
 * this class is the node for the Tree walker
 */

package unparser;
import java.util.ArrayList;



//-------------------------------------------------------------
//  Class Name : Node
//  Purpose    : This Class is the Node in a root, that contains it's
//              Name, it's children (they are Nodes as well) and a parent
//              that is a Node itself.
//
//  Mehtods: void addChild(Node n)
//           int getChildCount()
//           Node getParent()
//           void setName(String)
//           Node getChild()
//           String getName()
//-------------------------------------------------------------
public class Node {
    //there are attributes for each Node, they have names, and they
    //contain it's children which are Nodes themselves
    String name;
    ArrayList<Node> children;
    Node parent;

    public Node(String name){
        this.name = name;
    }
    public Node(){

    }
    //this method adds children to the children list
    public void addChild(Node n){
        if(children == null){
            children = new ArrayList<Node>();
        }
        children.add(n);
        n.setParent(this);

    }
    public void addChildatIndex(Node n, int index){
        if(children == null){
            children = new ArrayList<Node>();
        }
        children.add(index,n);
        n.setParent(this);
    }
    public void addChildtoTop(Node n){
        if(children == null){
            children = new ArrayList<Node>();
        }
        children.add(0,n);
        n.setParent(this);
    }
    public int getChildIndex(Node n){
        return children.indexOf(n);
    }
    public void setParent(Node p){
        this.parent = p;
    }
    public Node getParent(){
        return parent;
    }

    public int getChildCount(){
        if(children == null){
            return 0;
        }
        return children.size();
    }
    public void setName(String name){
        this.name = name;
    }
    // this method removes children
    public void removeChild(int index){
        if(children.size() < index -1)
            return;
        children.remove(index);
    }
    //this method returns the child node from a specific index
    public Node getChild(int index){
        if(children.isEmpty()){
            return null;
        }
        return children.get(index);
    }

    public boolean isEmpty(){
        if (children.isEmpty() || children==null)
            return true;
        else
            return false;


    }
    public void removeChildByRef(Node child){
        if(children.contains(child)){
            children.remove(child);
        }
    }
    public String getName(){
        return this.name;
    }
}
