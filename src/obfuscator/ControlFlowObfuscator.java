package obfuscator;

import unparser.Node;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Condition;


/**
 * Created by Areej on 5/17/14.
 * edited by Azad Abbasi
 */
public class ControlFlowObfuscator {

    Node treeRoot;

    public ControlFlowObfuscator(Node treeRoot) {
        this.treeRoot = treeRoot;
    }

    public static ArrayList<Node> createBogusIf(){
        ArrayList<Node> list = new ArrayList<Node>();
        Random r = new Random();
        int a = r.nextInt(9999);
        int b = r.nextInt(9999);
        int c = r.nextInt(9999);
        int e = r.nextInt(9999);
        int d = e*5;


        int result = a*b+c-d/e;
        System.out.println(result);
        String res = ParameterObfuscator.randomString(5);
        String resultS = String.valueOf(result);
        String as = String.valueOf(a);
        String bs = String.valueOf(b);
        String cs = String.valueOf(c);
        String ds = String.valueOf(d);
        String es = String.valueOf(e);

        Node assignment = new Node("ASSIGNMENT");
        Node explist = new Node("EXPR_LIST");
        Node varlist = new Node("VAR_LIST");
        Node minus = new Node("-");
        Node plus = new Node("+");
        Node mult = new Node("*");
        Node div = new Node("/");
        div.addChild(new Node(ds));
        div.addChild(new Node(es));
        mult.addChild(new Node(as));
        mult.addChild(new Node(bs));
        plus.addChild(mult);
        plus.addChild(new Node(cs));
        minus.addChild(plus);
        minus.addChild(div);
        explist.addChild(minus);
        varlist.addChild(new Node(res));
        assignment.addChild(varlist);
        assignment.addChild(explist);


        Node ifNode = new Node("if");
        Node conditionNode = new Node("CONDITION");
        Node equalNode = new Node("==");
        Node resid = new Node(resultS);
        Node varsi = new Node(res);
        equalNode.addChild(varsi);
        equalNode.addChild(resid);
        conditionNode.addChild(equalNode);
        ifNode.addChild(conditionNode);

        list.add(assignment);
        list.add(ifNode);

        return list;
    }


//    public static Node CreateBogusIF(){
//        //create a node of if
//        // with condition node : 100 == (50+50)
//        Node ifNode = new Node("if");
//        Node conditionNode = new Node("CONDITION");
//        Node equalNode = new Node("==");
//        Node plusNode = new Node("+");
//        plusNode.addChild(new Node("50"));
//        plusNode.addChild(new Node("50"));
//        equalNode.addChild(new Node("100"));
//        equalNode.addChild(plusNode);
//        conditionNode.addChild(equalNode);
//        ifNode.addChild(conditionNode);
//        return ifNode;
//    }

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
        chunckNode.addChild(new Node("break"));
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
                ArrayList<Node> temp = createBogusIf();
                Node parent = CurrentNode.getParent();
                parent.addChildatIndex(temp.get(0), parent.getChildIndex(CurrentNode));
                parent.addChildatIndex(temp.get(1), parent.getChildIndex(CurrentNode));
                temp.get(1).getChild(0).addChild(CurrentNode);
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
                temp.getChild(1).getChild(0).addChildatIndex(CurrentNode,0);
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
