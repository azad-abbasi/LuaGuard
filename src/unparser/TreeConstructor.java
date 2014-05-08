package unparser;

import org.antlr.runtime.tree.CommonTree;
import parser.InputReader;
import parser.LuaParser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Azad on 5/6/2014.
 */
public class TreeConstructor {
    public static StringTokenizer st ;
    public static ArrayList<String> Keywords = new ArrayList<String>(
            Arrays.asList("ASSIGNMENT", "ASSIGNMENT_VAR", "CALL",
                    "CHUNK", "COL_CALL", "CONDITION", "EXPR_LIST",
                    "FIELD", "FIELD_LIST", "FOR_IN", "FUNCTION",
                    "INDEX", "LABEL", "LOCAL_ASSIGNMENT", "NAME_LIST",
                    "PARAM_LIST", "TABLE", "UNARY_MINUS", "VAR",
                    "VAR_LIST", "FUNCTION_FUNCTION"));
    public static Stack<String> myNodeStack = new Stack<String>();
    public static String finalTreeString = "";
    public static Node tree;
    private String path;


    public TreeConstructor(String path){
        this.path= path;
        InputReader read = new InputReader(path);
        String ast = read.getString();
        st = new StringTokenizer(ast);
        //we need to get rid of the first token that is a parenthesis
        //so we read a token.
        st.nextToken();
        tree = treeConstructor(st.nextToken(),null);

    }



    public Node getRoot(){
        return tree;
    }

    public void printTree(){
        finalTreeString = "";
        createStructuredTree(tree, 0);
        System.out.println(finalTreeString);
    }


    public String toString(){
        finalTreeString = "";
        createStructuredTree(tree, 0);
        return finalTreeString;
    }

    public void printTreeTokens(){
        printTokens(path);
    }

    public static Node treeConstructor(String root, Node father){
        Node thisNode = new Node(root,father);
        String currentToken;
        int index = 0 ;
        while(st.hasMoreTokens()){
            currentToken = st.nextToken();

            //if the current token is not a "(" or ")" then it's either a string or another child
            //with no furthur children

            if(!(currentToken.equals(")") || currentToken.equals("("))){
                if(!currentToken.equals("'")){
                    thisNode.addChild(new Node(currentToken,thisNode));

                }
                else{
                    thisNode.addChild(new Node(getStringToken(),thisNode));
                }
//                currentToken = st.nextToken();
            }
            //what happens if we see a closing parenthesis here
            else if(currentToken.equals("(")){
                thisNode.addChild(treeConstructor(st.nextToken(),thisNode));

            }

            //what if we see an opening parenthesis here
            else if(currentToken.equals(")")){
                return thisNode;
            }
        }

        return thisNode;
    }


    //when we see a "'" token, we wait for the next one for them to be the next token all together
    //it means it's a string
    public static String getStringToken(){
        String currentToken = st.nextToken();
        String finalString="' ";
        while(!currentToken.equals("'")){
            finalString+=" "+ currentToken;
            currentToken=st.nextToken();
        }
        finalString+=" '";
//        st.nextToken();
        return finalString;
    }

    // this function returns true if the node is
    //ending in ")"
    public static boolean handleStack(String str){
        if(str.equals(")")){
            myNodeStack.pop();
            return false;
        }
        else {
            myNodeStack.push("(");
            return true;
        }
    }

    // print the tokens of a file given in the path
    public static void printTokens(String path){
        InputReader read = new InputReader(path);
        String ast = read.getString();
        StringTokenizer wb = new StringTokenizer(ast);
        while(wb.hasMoreTokens()){
            System.out.println(wb.nextToken());
        }
    }
    private static void createStructuredTree(Node tree, int Indention){
        //Create the indention first
        String indent="";
        if (Indention > 0 ) {
            indent = new String(new char[Indention]).replace('\0', '\t');
        }
        //add indents to the final tree
        finalTreeString += indent;
        //add the beginning parenthesis
        finalTreeString += " ( ";
        //now we add the current Tree's name
        String tokenName = "N";


        if(tokenName.equals("String")){
            finalTreeString = finalTreeString + " ' " + tree.getName() + " ' ";
        }
        else{
            finalTreeString += tree.getName();
        }


        //now we will have to print the children
        if(tree.getChildCount() > 0 ) {
            for (int i = 0 ; i<tree.getChildCount() ; i++){
                //if this child didn't have any children
                if(tree.getChild(i).getChildCount() == 0 ){
                    tokenName = "N";

                    if(tokenName.equals("String")){
                        finalTreeString = finalTreeString + " " + " ' " + tree.getChild(i).getName() + " ' ";
                    }
                    else{
                        finalTreeString = finalTreeString + " " + tree.getChild(i).getName();
                    }

                }
                else{
                    finalTreeString += "\n";
                    for(int j = i ; j<tree.getChildCount(); j++){
                        createStructuredTree(tree.getChild(j), Indention + 1);
                    }
                    finalTreeString = finalTreeString + indent + " )\n";
                    break;
                }
                if(i == tree.getChildCount()-1)
                    finalTreeString += " )\n";
            }
        }
        //else if you don't have any children
        else{
            finalTreeString += " )\n";
        }
    }




}
