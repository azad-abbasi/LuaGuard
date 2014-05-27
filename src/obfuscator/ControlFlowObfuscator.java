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


    public static Node CreateBogusIF(){
        //create a node of if
        // with condition node : 100 == (50+50)
        Node bogusNode;
        bogusNode = new Node("if",null);
        Node conditionNode = new Node("CONDITION", bogusNode);
        bogusNode.addChild(conditionNode);
        Node exprNode = new Node("=", conditionNode);
        Node expr1 = new Node("100", exprNode);
        Node expr2 = new Node("", exprNode);
        expr2.addChild(new Node("+", expr2));
        expr2.addChild(new Node("50", expr2));
        expr2.addChild(new Node("50", expr2));
        exprNode.addChild(expr1);
        exprNode.addChild(expr2);
        conditionNode.addChild(exprNode);
        bogusNode.addChild(new Node("CHUNK", bogusNode));
        return bogusNode;
    }

    public static Node CreateBogusWhile(){
        Node bogusWhile;
        bogusWhile = new Node("while",null);
        Node expr = new Node("=", bogusWhile);
        Node expr1 = new Node("100", bogusWhile);
        Node expr2 = new Node("", expr);
        expr2.addChild(new Node("+", expr2));
        expr2.addChild(new Node("50", expr2));
        expr2.addChild(new Node("50", expr2));
        expr.addChild(expr1);
        expr.addChild(expr2);
        bogusWhile.addChild(expr);
        Node doNode = new Node("do", bogusWhile);
        bogusWhile.addChild(doNode);
        Node chunckNode = new Node("CHUNK", doNode);
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
                temp.getChild(1).addChild(CurrentNode);
                Node parent = CurrentNode.getParent();
                // remove the if child existing for the parent
                parent.removeChildByRef(CurrentNode);
                // add the bogusIf to the parent
                parent.addChild(temp);
                /**-----------------------------------WHILE----------------------------------*/
            }else if(CurrentNode.getName().equals("while")){
                //While expr do_block -> ^(While expr do_block)
                System.out.println("I am a while");
                Node temp = CreateBogusWhile();
                temp.getChild(1).getChild(0).addChild(CurrentNode);
                Node parent = CurrentNode.getParent();
                // remove the while child existing for the parent
                parent.removeChildByRef(CurrentNode);
                // add the bogusWhile to the parent
                parent.addChild(temp);
            }else{
               // System.out.println(CurrentNode.getName());
                int count = CurrentNode.getChildCount();
                for(int i = 0; i < count; i++){
                    //System.out.println(" I am a child of " + CurrentNode.getName() + ">>>");
                    CFOProcessing(CurrentNode.getChild(i));
                }
            }
    }
   public static Node getTheTreeManipulated() {
       return treeRoot;
   }
}
