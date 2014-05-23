package obfuscator;

import unparser.Node;


/**
 * Created by Areej on 5/17/14.
 */
public class ControlFlowObfuscator {

   static Node treeRoot;

    public ControlFlowObfuscator(Node treeRoot) {
        this.treeRoot = treeRoot;
    }


    public static Node CreateBogusIF(Node ifNode){
        //create a node of if
        // with condition node : 100 == (50+50)
        Node bogusNode;
        bogusNode = new Node("if",null);
        Node conditionNode = new Node("CONDITION", bogusNode);
        bogusNode.addChild(conditionNode);
        Node exprNode = new Node("True", conditionNode);
        conditionNode.addChild(exprNode);
        // add an expr to the CONDITION NODE
        // for now lets make it easy: expr = TRUE
        // make the chunk of the condition node : the current ifNode
        //conditionNode.addChild(ifNode);
        //System.out.println("I AM IN BOGUS IF FUNCTION");
        // make it have a condition that is true and the body of that codition is the old if
        return bogusNode;
    }
    public static Node CreateBogusWhile(){
        Node bogusWhile;
        bogusWhile = new Node();
        return bogusWhile;
    }
    public void CFOObfuscate(){
        System.out.println("IN the CFO ");
        CFOProcessing(this.treeRoot);
    }

    public static void CFOProcessing(Node CurrentNode){
        System.out.println(CurrentNode.getName());

            /**-----------------------------------IF----------------------------------*/
            if (CurrentNode.getName().equals("if")) {
                // System.out.println("i found an  " + CurrentNode.getName());
                // call the createBogusIF
                // point the bogusIF node to the original if NOde
                // point the parent of the original if node to the new bogusIF
                Node temp = CreateBogusIF(CurrentNode);
                temp.addChild(CurrentNode);
                Node parent = CurrentNode.getParent();
                // remove the if child excisting for the parent
                int count = parent.getChildCount();
                for (int i = 0; i < count; i++) { // which child is this????
                    // I am assuming that I am changing every if as im moving on. No if statments are left of the main branch
                    if (parent.getChild(i).getName().equals("if")) {
                        parent.removeChild(i);
                       // System.out.println("Removed an IF");
                    }
                }
                // add the bogusIf to the parent
                parent.addChild(temp);
                /**-----------------------------------WHILE----------------------------------*/
            }else if(CurrentNode.getName().equals("While")){
                //While expr do_block -> ^(While expr do_block)

            }else{
               // System.out.println(CurrentNode.getName());
                int count = CurrentNode.getChildCount();
                for(int i = 0; i < count; i++){
                    //System.out.println(" I am a child of " + CurrentNode.getName() + ">>>");
                    CFOProcessing(CurrentNode.getChild(i));
                }
            }

        // traverse the tree until I encounter a node with (if)


        //if no if node encountered
        //add a bogus if node at the end of the code
        // as a new child node to the main chunck of the program

        //return treeRoot;
    }
   public static Node getTheTreeManipulated() {
       return treeRoot;
   }
}
