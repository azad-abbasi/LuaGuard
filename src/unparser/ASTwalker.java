/**
 * Created by Azad on 5/5/2014.
 * this file will walk through an AST
 * file and regenerates the tree
 */
package unparser;
import parser.InputReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class ASTwalker {
    public static StringTokenizer st ;
    public static Node treeRoot;
    public static ArrayList<String> Keywords = new ArrayList<String>(
                Arrays.asList("ASSIGNMENT", "ASSIGNMENT_VAR","CALL",
                        "CHUNK", "COL_CALL","CONDITION", "EXPR_LIST",
                        "FIELD", "FIELD_LIST", "FOR_IN", "FUNCTION",
                        "INDEX", "LABEL","LOCAL_ASSIGNMENT", "NAME_LIST",
                        "PARAM_LIST", "TABLE", "UNARY_MINUS","VAR",
                        "VAR_LIST","FUNCTION_FUNCTION"));
    public static Stack<String> myNodeStack = new Stack<String>();

    public ASTwalker(String path){
        InputReader read = new InputReader(path);
        String ast = read.getString();
        st = new StringTokenizer(ast);
    }


    //recursive function to create a tree.
    public static Node treeConstructor(String root){
        Node thisNode = new Node(root);
        String currentToken;
        int index = 0 ;
        while(st.hasMoreTokens()){
            currentToken = st.nextToken();

            //if the current token is not a "(" or ")" then it's either a string or another child
            //with no furthur children

            if(!(currentToken.equals(")") || currentToken.equals("("))){
                if(!currentToken.equals("'")){
                    thisNode.addChild(new Node(currentToken));

                }
                else{
                    thisNode.addChild(treeConstructor(getStringToken()));
                }
//                currentToken = st.nextToken();
            }
            //what happens if we see a closing parenthesis here
            else if(currentToken.equals("(")){
                thisNode.addChild(treeConstructor(st.nextToken()));

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
        String finalString="";
        while(!currentToken.equals("'")){
            finalString+=currentToken;
            currentToken=st.nextToken();
        }
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
    public static void printTokens(String path){
        InputReader read = new InputReader(path);
        String ast = read.getString();
        StringTokenizer wb = new StringTokenizer(ast);
        while(wb.hasMoreTokens()){
            System.out.println(wb.nextToken());
        }
    }

    public static void main(String[] args) {
        printTokens(args[0]);
        InputReader read = new InputReader(args[0]);
        String ast = read.getString();
        st = new StringTokenizer(ast);
        String token = st.nextToken();
        Node tree = treeConstructor(st.nextToken());
        System.out.println("");
        System.out.println("");
        System.out.println(tree.getChild(1).getChild(0).getName());
//        printTokens(args[0]);

//        readTokens(args[0]);
    }
}
