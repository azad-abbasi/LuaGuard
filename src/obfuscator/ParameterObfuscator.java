
package obfuscator;

import java.io.*;
import java.util.*;
import java.lang.*;
import java.util.Map;
import unparser.Node;

/*
 *  Obfuscator program: 
 *  created by Amanda Lemkuil
 *  May 16 2014
 *  CIS 423
 */


public class ParameterObfuscator {
    Node root;
    Map<String, ArrayList<String>> functionMap;
    
//-------------------------------------------------------------
//  Method Name : Constructor
//  arguments : the root to the tree
//  Purpose    : set the values straight
//-------------------------------------------------------------
    public ParameterObfuscator(Node root){
        this.root = root;
        functionMap = new HashMap<String, ArrayList<String>>();
    }

//-------------------------------------------------------------
//  Method Name : newParamNode
//  arguments : a parent node
//  Purpose   : create a new parameter node with given parent and 
//               random string name
//-------------------------------------------------------------
    public static Node newParamNode(Node parentNode){
        Node newParam;
        newParam = new Node(randomString(5));
        parentNode.addChild(newParam);
        return newParam;
    }

//-------------------------------------------------------------
//  Method Name : addParams
//  Purpose    : 
//  About : this method is a recursive method that asks every child
//          to call it's children to find all PARAM_LIST nodes
//          
//-------------------------------------------------------------
    public void addParams(){
        addParams(this.root);
    }

    public static void addParams(Node currentNode){

        if(currentNode.getName().equals("FUNCTION_ASSIGNMENT")){
            Node varNode = currentNode.getChild(0); //VAR_LIST node
            String funName = varNode.getChild(0).getName(); //function name
            Node exprNode = currentNode.getChild(1); //EXPR_LIST node
            Node paramNode = exprNode.getChild(0).getChild(0); //PARAM_LIST node
            if()


            }
            Node child = newParamNode(currentNode);

        }
        /*if(currentNode.getName().equals("PARAM_LIST")){
            Node child = newParamNode(currentNode);

        } else {
            int childCount = currentNode.getChildCount();
            for(int i = 0; i< childCount; i++){
                addParams(currentNode.getChild(i));
            }
        }*/
    }


    public Node getNewTree(){
        return root;
    }

//-------------------------------------------------------------
//  Method Name : randomString
//  Purpose    : generate a random string of charachters and numbers 
//  About : this method is given an integer length. It contains a specified 
//          charachter string and uses the java StringBuilder and Random classes 
//          to generate and return the random string.
//         
//-------------------------------------------------------------
    public static String randomString(int length) {
        String abc = "0123456789abcdefghijklmnopqrstuvwxyz";
        Random r = new Random();
    
        StringBuilder sb = new StringBuilder(length);
        for( int i = 0; i < length; i++ ) 
            sb.append( abc.charAt( r.nextInt(abc.length()) ) );
        return sb.toString();
    }
}