package unparser;

import parser.InputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Azad on 5/6/2014.
 */

//-------------------------------------------------------------
//  Class Name : TreeConstructor
//  Purpose    : This class takes the path to the AST text file and constructs
//              a root
//-------------------------------------------------------------
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
    public static Node root;
    private String path;

//-------------------------------------------------------------
//  Method Name : Constructor
//  Purpose    : This constructor takes the path to the target file
//              and reads that file into a root
//-------------------------------------------------------------
    public TreeConstructor(String path){

        this.path= path;
        InputReader read = new InputReader(path);
        String ast = read.getString();
        st = new StringTokenizer(ast);
        //we need to get rid of the first token that is a parenthesis
        //so we read a token.
        st.nextToken();
        root = treeConstructor(st.nextToken(),null);

    }


//-------------------------------------------------------------
//  Method Name : getRoot()
//  Purpose    : returns the root Node of the Tree which is usually "CHUNK"
//-------------------------------------------------------------
    public Node getRoot(){
        return root;
    }


//-------------------------------------------------------------
//  Method Name : printTree()
//  Purpose    : This method prints the Tree that has been constructed in the
//              Class constructor
//-------------------------------------------------------------
    public void printTree(){
        finalTreeString = "";
        createStructuredStringTree(root, 0);
        System.out.println(finalTreeString);
    }

//-------------------------------------------------------------
//  Method Name : toString
//  Purpose    : returns the Tree that has been constructed into a tree
//               ***/// just for testing ////******
//-------------------------------------------------------------
    public String toString(){
        finalTreeString = "";
        createStructuredStringTree(root, 0);
        return finalTreeString;
    }


    public void printTreeTokens(){
        printTokens(path);
    }


//-------------------------------------------------------------
//  Method Name : treeConstructor
//  arguments : the root of the tree you wish to construct, and the father of the tree
//  About : this is a recursive method that generates the tree bottom up
//           basically what it does is that it generates the root and then starts adding
//           the children by calling itself with different arguments.
//  Purpose    : Construct a tree using the tokens seen in the StringTokenizer
//-------------------------------------------------------------
    public static Node treeConstructor(String root, Node father){
        Node thisNode;
        if(root.equals("'")){
            thisNode = new Node(getStringToken(),father);
        }
        else{
            thisNode = new Node(root,father);
        }
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

//-------------------------------------------------------------
//  Method Name : getStringToken
//  About: because of architectual decisions, when we encounter a " ' " token,
//      we have to wait for the next one to show up so we can recognize the whole thing
//      as a Token, it usually happens when we have strings in our code
//  Purpose    : recognize a string token
//-------------------------------------------------------------
    //when we see a "'" token, we wait for the next one for them to be the next token all together
    //it means it's a string
    private static String getStringToken(){
        String currentToken = st.nextToken();
        String finalString="'";
        while(!currentToken.equals("'")){
            finalString+= currentToken;
            currentToken=st.nextToken();
        }
        finalString+="'";
//        st.nextToken();
        return finalString;
    }

//-------------------------------------------------------------
//  Method Name : handleStack
//  Purpose    : handle the stack depending what it contains. mostly to
//              handle paranthesis.
//
//-------------------------------------------------------------
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

//-------------------------------------------------------------
//  Method Name : createStructuredStringTree
//  Purpose    : this method is just for purpose of testing, we Construct the tree we have built to
//              make sure we have created the correct version of the tree.
//-------------------------------------------------------------
    private static void createStructuredStringTree(Node tree, int Indention){
        //Create the indention first
        String indent="";
        if (Indention > 0 ) {
            indent = new String(new char[Indention]).replace('\0', '\t');
        }
        //add indents to the final root
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
                        createStructuredStringTree(tree.getChild(j), Indention + 1);
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
