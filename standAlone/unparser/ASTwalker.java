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

    public static void readTokens(String astPath){

        Node treeRoot = new Node();

        //now we have every node in a st node tokenizer !
        String currentToken;
        while (st.hasMoreTokens()) {
            currentToken = st.nextToken();
            if(currentToken.equals("(")){
                myNodeStack.push(currentToken);
                treeRoot.setName(st.nextToken());
           }
        }
    }

    // this function returns true if the node is
    //ending in ")"
    public static boolean handleStack(String str){
        if(str.equals(")")){
            myNodeStack.pop();
            return true;
        }
        else {
            myNodeStack.push(")");
            return false;
        }
    }
    public static void printTokens(String path){
        InputReader read = new InputReader(path);
        String ast = read.getString();
        StringTokenizer st = new StringTokenizer(ast);
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }

    public static void main(String[] args) {

        printTokens(args[0]);
        readTokens(args[0]);
    }
}
