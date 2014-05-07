/**
 * Created by Azad on 5/5/2014.
 * this class is the node for the Tree walker
 */

package unparser;
import java.util.ArrayList;

public class Node {
    //there are attributes for each Node, they have names, and they
    //contain it's children which are Nodes themselves
    String name;
    ArrayList<Node> children;

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
    public String getName(){
        return this.name;
    }
}
