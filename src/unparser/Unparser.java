
/**
 * Created by azada on 4/24/14.
 */

package unparser;

import java.util.ArrayList;
import java.util.Arrays;
//-------------------------------------------------------------
//  Class Name : Unparser
//  Purpose    : This Class takes the root to a tree in the constructor
//              and creates a Lua code accordingly
//  Mehtods: void addChild(Node n)
//           int getChildCount()
//           Node getParent()
//           void setName(String)
//           Node getChild()
//           String getName()
//-------------------------------------------------------------
public class Unparser {
    Node root ;
    String code ;
    //finalcode variable is the static final value of the code
    static StringBuilder finalCode;
    public static ArrayList<String> keywords = new ArrayList<String>(
            Arrays.asList("ASSIGNMENT", "ASSIGNMENT_VAR", "CALL",
                    "CHUNK", "COL_CALL", "CONDITION", "EXPR_LIST",
                    "FIELD", "FIELD_LIST", "FOR_IN", "FUNCTION",
                    "INDEX", "LABEL", "LOCAL_ASSIGNMENT", "NAME_LIST",
                    "PARAM_LIST", "TABLE", "UNARY_MINUS", "VAR",
                    "VAR_LIST", "FUNCTION_FUNCTION" , "if"));
//-------------------------------------------------------------
//  Method Name : Constructor
//  arguments : the root to the tree
//  Purpose    : set the values straight
//-------------------------------------------------------------
    public Unparser(Node root){
        this.root = root ;
        finalCode = new StringBuilder();
    }
//-------------------------------------------------------------
//  Method Name : unparse
//  Purpose    : this is where we start creating the unparsed original code
//  About : this method is a recursive method that asks every child
//          to call it's children to print themselves
//          this method calls an static method to take care of the code
//-------------------------------------------------------------
    public void unparse(){
        unparse(this.root);
        code = finalCode.toString();
    }


    public static void unparse(Node currentNode){
        //if we encounter a "CHUNK" we move on to
        // it's children and ask them to print themselves
        /**-----------------------------------CHUNK----------------------------------*/
        if(currentNode.getName().equals("CHUNK")){
            for(int i=0 ; i<currentNode.getChildCount() ; i++)
                unparse(currentNode.getChild(i));
        }
        /**-----------------------------------FUNCTION_ASSIGNMENT----------------------------------*/
        //if we encounter a Funtion ASSIGNMENT
        else if(currentNode.getName().equals("FUNCTION_ASSIGNMENT")){
            finalCode.append("function ");


            for (int i=0;i<currentNode.getChildCount();i++){
                unparse(currentNode.getChild(i));
            }

            finalCode.append("\nend\n");
        }
        /**-----------------------------------LOCAL_ASSIGNMENT----------------------------------*/
        else if(currentNode.getName().equals("LOCAL_ASSIGNMENT")){
            finalCode.append("local ");
            unparse(currentNode.getChild(0));
            finalCode.append("=");
            unparse(currentNode.getChild(1));
            finalCode.append("\n");
        }
        /**-----------------------------------NAME_LIST----------------------------------*/
        else if(currentNode.getName().equals("NAME_LIST")){
            for(int i=0 ; i<currentNode.getChildCount() ; i++) {
                unparse(currentNode.getChild(i));
                if(i>=0 && i<currentNode.getChildCount()-1 && currentNode.getChildCount()>1)
                    finalCode.append(",");
            }
        }
        /**-----------------------------------EXPR_LIST----------------------------------*/
        else if(currentNode.getName().equals("EXPR_LIST")){
                for(int i=0 ; i<currentNode.getChildCount() ; i++) {
                    unparse(currentNode.getChild(i));
                    if(i>=0 && i<currentNode.getChildCount()-1 && currentNode.getChildCount()>1)
                        finalCode.append(",");
                }
        }
        /**-----------------------------------PARAM_LIST----------------------------------*/
        else if(currentNode.getName().equals("PARAM_LIST")){
            finalCode.append("(");
            for(int i=0 ; i<currentNode.getChildCount() ; i++) {
                unparse(currentNode.getChild(i));
                if(i>=0 && i<currentNode.getChildCount()-1 && currentNode.getChildCount()>1)
                    finalCode.append(",");
            }
            finalCode.append(") ");
//            finalCode.append("\n");
        }
        /**-----------------------------------FUNCTION----------------------------------*/
        else if(currentNode.getName().equals("FUNCTION")){
            if(currentNode.getParent().getName().equals("CALL")){
                finalCode.append("function ");
                for(int i=0 ; i<currentNode.getChildCount() ; i++)
                    unparse(currentNode.getChild(i));
                finalCode.append(" end ");
            }
            else if(currentNode.getParent().getName().equals("return")){
                finalCode.append("function ");
                for(int i=0 ; i<currentNode.getChildCount() ; i++)
                    unparse(currentNode.getChild(i));
                finalCode.append(" end ");
            }
            else if(currentNode.getParent().getParent().getName().equals("LOCAL_ASSIGNMENT")){
                finalCode.append("function ");
                for(int i=0 ; i<currentNode.getChildCount() ; i++)
                    unparse(currentNode.getChild(i));
                finalCode.append("\nend\n");
            }
            else{
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
                if(i==0)
                    finalCode.append("\n");
            }

            }
        }
        /**-----------------------------------REQUIRE----------------------------------*/
        else if(currentNode.getName().equals("REQUIRE")){
            finalCode.append("require ");
            for(int i=0 ; i<currentNode.getChildCount() ; i++) {
                unparse(currentNode.getChild(i));
                if(i>=0 && i<currentNode.getChildCount()-1 && currentNode.getChildCount()>1)
                    finalCode.append(",");
            }
            finalCode.append("\n");
        }
        /**-----------------------------------VAR----------------------------------*/
        else if(currentNode.getName().equals("VAR")){
            if(currentNode.getChild(1).getName().equals("CALL")){
                finalCode.append(currentNode.getChild(0).getName());
                for(int i=1 ; i<currentNode.getChildCount() ; i++)
                    unparse(currentNode.getChild(i));
            }
            if(currentNode.getChild(1).getName().equals("INDEX")){
                for(int i=0 ; i<currentNode.getChildCount() ; i++)
                    unparse(currentNode.getChild(i));
            }
        }
        /**-----------------------------------CALL----------------------------------*/
        else if(currentNode.getName().equals("CALL")){
            finalCode.append("(");
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
                if(i>=0 && i<currentNode.getChildCount()-1 && currentNode.getChildCount()>1)
                    finalCode.append(",");
            }

            finalCode.append(") ");
        }
        /**-----------------------------------VAR_LIST----------------------------------*/
        else if(currentNode.getName().equals("VAR_LIST")){
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
                if(i>=0 && i<currentNode.getChildCount()-1 && currentNode.getChildCount()>1)
                    finalCode.append(",");
            }
        }
        /**-----------------------------------LOCAL_DEC----------------------------------*/
        else if(currentNode.getName().equals("LOCAL_DEC")){
            finalCode.append("local ");
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
                if(i>=1 && i<currentNode.getChildCount()-1 && currentNode.getChildCount()>1)
                    finalCode.append(",");
            }
            finalCode.append("\n");
        }
        /**-----------------------------------CONDITION----------------------------------*/
        else if(currentNode.getName().equals("CONDITION")){



            if(!currentNode.getChild(0).getName().equals("True")){
                if(currentNode.getParent().getChild(0)==currentNode){
                    for(int i=0 ; i<currentNode.getChildCount() ; i++){
                        if(i==1){
                            finalCode.append(") then\n");
                        }
                        unparse(currentNode.getChild(i));
                    }
                }
                else{
                    finalCode.append("elseif(");
                    for(int i=0 ; i<currentNode.getChildCount() ; i++){
                        if(i==1){
                            finalCode.append(") then\n");
                        }
                        unparse(currentNode.getChild(i));
                    }
                }
            }
            else{
                finalCode.append("else \n");
                for(int i=0 ; i<currentNode.getChildCount() ; i++){
                    unparse(currentNode.getChild(i));
                }
            }
        }
        /**-----------------------------------ASSIGNMENT----------------------------------*/
        else if(currentNode.getName().equals("ASSIGNMENT")){
            unparse(currentNode.getChild(0));
            finalCode.append("=");
            unparse(currentNode.getChild(1));
            finalCode.append("\n");
        }
        /**-----------------------------------ASSIGNMENT_VAR----------------------------------*/
        else if(currentNode.getName().equals("ASSIGNMENT_VAR")){
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
            }
//            finalCode.append("\n");
        }
        /**-----------------------------------INDEX----------------------------------*/
        else if(currentNode.getName().equals("INDEX")){
            boolean flag = false;
            if(currentNode.getParent().getChildCount()>=3)
                flag = true;
            if(flag && currentNode.getParent().getChild(2).getName().equals("COL_CALL")){
                finalCode.append(":");
                for(int i=0 ; i<currentNode.getChildCount() ; i++){
                    unparse(currentNode.getChild(i));
                }
            }

            else if(currentNode.getChild(0).getName().charAt(0)=='\''){
                finalCode.append(".");
                for(int i=0 ; i<currentNode.getChildCount() ; i++){
                    unparse(currentNode.getChild(i));
                }
            }
            else {
                finalCode.append("[");
                for(int i=0 ; i<currentNode.getChildCount() ; i++){
                    unparse(currentNode.getChild(i));
                }
                finalCode.append("]");
            }
        }
        /**-----------------------------------UNARY_MINUS----------------------------------*/
        else if(currentNode.getName().equals("UNARY_MINUS")){
            finalCode.append("-");
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
            }
        }
        /**-----------------------------------COL_CALL----------------------------------*/
        else if(currentNode.getName().equals("COL_CALL")){
            finalCode.append("(");
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
            }
            finalCode.append(") ");
        }
        /**-----------------------------------TABLE----------------------------------*/
        else if(currentNode.getName().equals("TABLE")){
            finalCode.append("{");
            for(int i=0 ; i<currentNode.getChildCount() ; i++) {
                unparse(currentNode.getChild(i));
                if(i>=0 && i<currentNode.getChildCount()-1 && currentNode.getChildCount()>1)
                    finalCode.append(",");
            }

            finalCode.append("}\n");
        }
        /**-----------------------------------FIELD----------------------------------*/
        else if(currentNode.getName().equals("FIELD")){
            if(currentNode.getChildCount()>1) {
                finalCode.append("[");
                unparse(currentNode.getChild(0));
                finalCode.append("]");
                finalCode.append("=");
                unparse(currentNode.getChild(1));
            }
            else{
                unparse(currentNode.getChild(0));
            }
        }
        /**-----------------------------------FOR_IN----------------------------------*/
        else if(currentNode.getName().equals("FOR_IN")){
            finalCode.append("for ");
            unparse(currentNode.getChild(0));
            finalCode.append(" in ");
            for(int i=1 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
            }

        }
        /**-----------------------------------do----------------------------------*/
        else if(currentNode.getName().equals("do")){
            finalCode.append("do\n");
            for(int i=0 ; i<currentNode.getChildCount() ; i++)
                unparse(currentNode.getChild(i));
            finalCode.append("\nend\n");
        }
        /**-----------------------------------for----------------------------------*/
        else if(currentNode.getName().equals("for")){
            finalCode.append("for ");
            unparse(currentNode.getChild(0));
            finalCode.append("=");
            for(int i=1 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
                if(i<currentNode.getChildCount()-2)
                    finalCode.append(",");
                else {
                    finalCode.append(" ");
                }

            }
        }
        /**-----------------------------------goto----------------------------------*/
        else if(currentNode.getName().equals("goto")){
            finalCode.append("goto ");
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
            }
        }
        /**-----------------------------------if----------------------------------*/
        else if(currentNode.getName().equals("if")){
            finalCode.append("if(");
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
            }
            finalCode.append("\nend\n");
        }
        /**----------------------------------- + - ^ ----------------------------------*/
        else if(currentNode.getName().equals("+") || currentNode.getName().equals("-")|| currentNode.getName().equals("^")){
            finalCode.append("(");
            unparse(currentNode.getChild(0));
            finalCode.append(currentNode.getName());
            unparse(currentNode.getChild(1));
            finalCode.append(")");
        }
        /**----------------------------------- / * ----------------------------------*/
        else if(currentNode.getName().equals("/") || currentNode.getName().equals("*")){

            unparse(currentNode.getChild(0));
            finalCode.append(currentNode.getName());
            unparse(currentNode.getChild(1));

        }
        /**------------------------------- == < > <= >= ~= ----------------------------------*/
        else if(currentNode.getName().equals("==") || currentNode.getName().equals(">") ||
                currentNode.getName().equals("<") || currentNode.getName().equals(">=")||
                currentNode.getName().equals("<=")||currentNode.getName().equals("~=")){

            if(currentNode.getParent().getName().equals("while")){
                unparse(currentNode.getChild(0));
                finalCode.append(currentNode.getName());
                unparse(currentNode.getChild(1));
                finalCode.append("\n");
            }
            else{
                unparse(currentNode.getChild(0));
                finalCode.append(currentNode.getName());
                unparse(currentNode.getChild(1));
//                finalCode.append("\n");
//                finalCode.append("");
            }
        }
        /**-----------------------------------return----------------------------------*/
        else if(currentNode.getName().equals("return")){
            finalCode.append("return ");
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
                if(i>=0 && i<currentNode.getChildCount()-1 && currentNode.getChildCount()>1)
                    finalCode.append(",");
            }
            finalCode.append(" ");
        }
        /**-----------------------------------or----------------------------------*/
        else if(currentNode.getName().equals("or")){
            unparse(currentNode.getChild(0));
            finalCode.append(" ");
            finalCode.append(currentNode.getName());
            finalCode.append(" ");
            unparse(currentNode.getChild(1));
//            finalCode.append(")\n");
        }
        /**-----------------------------------and----------------------------------*/
        else if(currentNode.getName().equals("and")){
            unparse(currentNode.getChild(0));
            finalCode.append(" ");
            finalCode.append(currentNode.getName());
            finalCode.append(" ");
            unparse(currentNode.getChild(1));
        }
        /**-----------------------------------while----------------------------------*/
        else if(currentNode.getName().equals("while")){
            finalCode.append("while ");
            unparse(currentNode.getChild(0));
            finalCode.append("\n");
            for(int i=1 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
            }
//            finalCode.append("\n");
        }
        /**-----------------------------------..----------------------------------*/
        else if(currentNode.getName().equals("..")){
            unparse(currentNode.getChild(0));
            finalCode.append(currentNode.getName());
            unparse(currentNode.getChild(1));
//
        }
        /**-----------------------------------repeat----------------------------------*/
        else if(currentNode.getName().equals("repeat")){
            finalCode.append("repeat\n");
            unparse(currentNode.getChild(0));
            finalCode.append("until ");
            unparse(currentNode.getChild(1));
            finalCode.append("\n");

        }
        /**-----------------------------------not----------------------------------*/
        else if(currentNode.getName().equals("not")){
            finalCode.append("not ");
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
            }

        }
        /**-----------------------------------#----------------------------------*/
        else if(currentNode.getName().equals("#")){
            finalCode.append("#");
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
            }

        }
        /**-----------------------------------True----------------------------------*/
        else if(currentNode.getName().equals("True")){
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
            }
        }
        /**-----------------------------------break----------------------------------*/
        else if(currentNode.getName().equals("break")){
            finalCode.append("break\n");
        }

        /**-----------------------------------UNKNOWN VARIABLES AND STRING----------*/
        else if(!keywords.contains(currentNode.getName())){
            if(currentNode.getParent()!=null){
                if(currentNode.getParent().getName().equals("INDEX")){
                    if(currentNode.getName().charAt(0)=='\''){
                        currentNode.setName(stripQuote(currentNode.getName()));
                    }
                    finalCode.append(currentNode.getName());
//                    finalCode.append(" ");
                }
                else{
                    finalCode.append(currentNode.getName());
//                    finalCode.append(" ");
                }
            }
            else{
            finalCode.append(currentNode.getName());
//            finalCode.append(" ");
            }
        }
    }

    public static String stripQuote(String quote){
        String result = "";
        int length = quote.length();
        int startP = 1;
        int endP = length -1 ;
        result = quote.substring(startP,endP);
        return result;
    }

    public String getCode(){
        return code;
    }

}
