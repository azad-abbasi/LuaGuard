package obfuscator;

import unparser.Node;


/**
 * Created by Areej on 5/17/14.
 */
public class ControlFlowObfuscator {

    Node treeRoot;

    public ControlFlowObfuscator(Node treeRoot) {
        this.treeRoot = treeRoot;
    }


    public static Node CreateBogusIF(){
        //create a node of if
        // with condition node : 100 == (50+50)
        Node ifNode = new Node("if");
        Node conditionNode = new Node("CONDITION");
        Node equalNode = new Node("==");
        Node plusNode = new Node("+");
        plusNode.addChild(new Node("50"));
        plusNode.addChild(new Node("50"));
        equalNode.addChild(new Node("100"));
        equalNode.addChild(plusNode);
        conditionNode.addChild(equalNode);
        ifNode.addChild(conditionNode);
        return ifNode;
    }

    public static Node CreateBogusWhile(){
        Node bogusWhile;
        bogusWhile = new Node("while");
        Node equalNode = new Node("==");
        Node plusNode = new Node("+");
        plusNode.addChild(new Node("50"));
        plusNode.addChild(new Node("50"));
        equalNode.addChild(new Node("100"));
        equalNode.addChild(plusNode);
        bogusWhile.addChild(equalNode);
        Node doNode = new Node("do");
        bogusWhile.addChild(doNode);
        Node chunckNode = new Node("CHUNK");
        doNode.addChild(chunckNode);
        return bogusWhile;
    }

    public void CFOObfuscate(){
        //System.out.println("IN the CFO ");
        CFOProcessing(this.treeRoot);
    }

    public static void CFOProcessing(Node CurrentNode){
        //System.out.println(CurrentNode.getName());

            /**-----------------------------------IF----------------------------------*/
            if(CurrentNode.getName().equals("if")) {
                // System.out.println("i found an  " + CurrentNode.getName());
                // call the createBogusIF
                Node temp = CreateBogusIF();
                Node parent = CurrentNode.getParent();
                parent.addChildatIndex(temp, parent.getChildIndex(CurrentNode));
                temp.getChild(0).addChild(CurrentNode);
                // remove the if child existing for the parent
                parent.removeChildByRef(CurrentNode);
                // add the bogusIf to the parent
                int count = CurrentNode.getChildCount();
                for(int i = 0; i < count; i++){
                    //System.out.println(" I am a child of " + CurrentNode.getName() + ">>>");
                    CFOProcessing(CurrentNode.getChild(i));
                }

                /**-----------------------------------WHILE----------------------------------*/
            }
            else if(CurrentNode.getName().equals("while")){
                //While expr do_block -> ^(While expr do_block)
                //System.out.println("I am a while");
                Node temp = CreateBogusWhile();
                Node parent = CurrentNode.getParent();
                parent.addChildatIndex(temp, parent.getChildIndex(CurrentNode));
                temp.getChild(1).getChild(0).addChild(CurrentNode);
                // remove the while child existing for the parent
                parent.removeChildByRef(CurrentNode);
                int count = CurrentNode.getChildCount();
                for(int i = 0; i < count; i++){
                    //System.out.println(" I am a child of " + CurrentNode.getName() + ">>>");
                    CFOProcessing(CurrentNode.getChild(i));
                }

            }
            else{
               // System.out.println(CurrentNode.getName());
                int count = CurrentNode.getChildCount();
                for(int i = 0; i < count; i++){
                    //System.out.println(" I am a child of " + CurrentNode.getName() + ">>>");
                    CFOProcessing(CurrentNode.getChild(i));
                }
            }
    }
   public  Node getManipulatedTree() {
       return treeRoot;
   }
}
