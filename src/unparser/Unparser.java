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
        if(currentNode.getName().equals("CHUNK")){
        	finalCode.append("\n");
            for(int i=0 ; i<currentNode.getChildCount() ; i++)
                unparse(currentNode.getChild(i));
        }
        //if we encounter a Funtion ASSIGNMENT
        else if(currentNode.getName().equals("FUNCTION_ASSIGNMENT")){
            finalCode.append("function ");
            finalCode.append(currentNode.getChild(0).getChild(0).getName());

            for (int i=1;i<currentNode.getChildCount();i++)
                unparse(currentNode.getChild(i));
            finalCode.append("end\n");
        }
        
        /**----------------------------------EXPR_LIST----------------------------------**/
        /*Contains the expressions that are assigned to respective variable names*/
        else if(currentNode.getName().equals("EXPR_LIST")){
        		//finalCode.append("Expr_list");
                for(int i=0 ; i<currentNode.getChildCount() ; i++){
                	unparse(currentNode.getChild(i));
                	if(i >= 0 && i < currentNode.getChildCount() -1 && currentNode.getChildCount() > 1){
                		finalCode.append(",");
                	}
                }
                    
                
        }

        /**----------------------------------FUNCTION----------------------------------**/
        /* Contains param list as well as the body of the function*/
        else if(currentNode.getName().equals("FUNCTION")){
        	//finalCode.append("function");
        	if(currentNode.getParent().getParent().getName().equals("LOCAL_ASSIGNMENT") || currentNode.getParent().getName().equals("return")){
                finalCode.append("function ");
                for(int i=0 ; i<currentNode.getChildCount() ; i++)
                    unparse(currentNode.getChild(i));
                finalCode.append("\nend\n");
            }
            else{
            	for(int i=0 ; i<currentNode.getChildCount() ; i++)
            		unparse(currentNode.getChild(i));
            }
            
        }
        
        /**----------------------------------PARAM_LIST----------------------------------**/
        /*contains the formal paraeters within a function declaration*/
        else if(currentNode.getName().equals("PARAM_LIST")){
            finalCode.append(" (");
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
            	//finalCode.append(i);
            	unparse(currentNode.getChild(i));
                if(i >= 0 && i < currentNode.getChildCount()-1)
                    finalCode.append(",");
            }
            finalCode.append(")");
            finalCode.append("\n");
        }

        /**----------------------------------VAR----------------------------------**/
        /*Used when calling object members, or functions*/
        else if(currentNode.getName().equals("VAR")){
        	//finalCode.append("var");
            if(currentNode.getChild(1).getName().equals("CALL")){
                finalCode.append(currentNode.getChild(0).getName());
                for(int i=1 ; i<currentNode.getChildCount() ; i++)
                    unparse(currentNode.getChild(i));
            }
            if(currentNode.getChild(1).getName().equals("INDEX")){
            	for(int i = 0; i < currentNode.getChildCount(); i++)
            		unparse(currentNode.getChild(i));
            }
            //finalCode.append("\n");
        }
        
        /**----------------------------------CALL----------------------------------**/
        /*used to specify a set of arguments when calling a function*/
        else if(currentNode.getName().equals("CALL")){
            finalCode.append("(");
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
            	unparse(currentNode.getChild(i));
                if(i >= 0 && i < currentNode.getChildCount()-1 && currentNode.getChildCount() > 1)
                    finalCode.append(",");
            }
            finalCode.append(") ");
        }

        /**----------------------------------VAR_LIST----------------------------------**/
        /*Indicates a list of variable names within assingments*/
        else if(currentNode.getName().equals("VAR_LIST")){
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
                if(i >= 0 && i < currentNode.getChildCount() - 1 && currentNode.getChildCount() > 1)
                	finalCode.append(",");
            }
        }

        /**----------------------------------ASSIGNMENT----------------------------------**/
        /*used to indicate a variable assignment*/
        else if(currentNode.getName().equals("ASSIGNMENT")){
            unparse(currentNode.getChild(0));
            finalCode.append("=");
            unparse(currentNode.getChild(1));
            finalCode.append("\n");
        }

        /**----------------------------------+, -, ^----------------------------------**/
        /*indicates binary operators for addition, subtraction, and exponentiation*/
        else if(currentNode.getName().equals("+") || currentNode.getName().equals("-") || currentNode.getName().equals("^")){
            finalCode.append("(");
            unparse(currentNode.getChild(0));
            finalCode.append(currentNode.getName());
            unparse(currentNode.getChild(1));
            finalCode.append(")");
        }
        
        /**----------------------------------/, *----------------------------------**/
        /*indicates operators for multiplication and division*/
        else if(currentNode.getName().equals("/") || currentNode.getName().equals("*")){
            unparse(currentNode.getChild(0));
            finalCode.append(currentNode.getName());
            unparse(currentNode.getChild(1));
        }

        /**----------------------------------if----------------------------------**/
        /*if-then-else statement*/
        else if(currentNode.getName().equals("if")){
        	finalCode.append("if(");
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
            }
            finalCode.append("\nendIf\n");
        }

        /**----------------------------------CONDITION----------------------------------**/
        /*contains boolean expressions and event handlers*/
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
        
        /**----------------------------------LOCAL_DEC----------------------------------**/
        /*indicates the function decode64(), which decodes an encoded string*/
        else if(currentNode.getName().equals("LOCAL_DEC")){
        	finalCode.append("local ");
        	for(int i = 0; i < currentNode.getChildCount(); i++){
        		unparse(currentNode.getChild(i));
        		if (i >= 1 && i < currentNode.getChildCount() - 1 && currentNode.getChildCount() > 1)
        			finalCode.append(",");
        	}
        	finalCode.append("\n");
        }

        /**----------------------------------ASSIGNMENT_VAR----------------------------------**/
        /*Used to index through arrays*/
        else if(currentNode.getName().equals("ASSIGNMENT_VAR")){
        	for(int i = 0; i < currentNode.getChildCount(); i++){
        		unparse(currentNode.getChild(i));
        	}
        }
        
        /**----------------------------------FOR_IN----------------------------------**/
        /*indicates a for-in loop. for-in loops are similar to for loops, only they are used to 
         * go through strings by indices.
         */
        else if(currentNode.getName().equals("FOR_IN")){
            finalCode.append("for ");
            unparse(currentNode.getChild(0));
            finalCode.append(" in ");
            for(int i=1 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
            }

        }
        
        /**----------------------------------do----------------------------------**/
        /*indicates a do-while loop*/
        else if(currentNode.getName().equals("do")){
            finalCode.append("do\n");
            for(int i=0 ; i<currentNode.getChildCount() ; i++)
                unparse(currentNode.getChild(i));
            finalCode.append("\nend\n");
        }
        
        /**----------------------------------for----------------------------------**/
        /*indicates a for loop*/
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
        
        /**----------------------------------goto----------------------------------**/
        /*indicates a statement that specifies which label in the code to jump to*/
        else if(currentNode.getName().equals("goto")){
            finalCode.append("goto ");
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
            }
        }
        /*
         * Modified by Gabe Aron
         */
        
        /**----------------------------------<=, >=, <, >, ==, ~=----------------------------------**/
        /*This specifies a binary comparison within an if statement*/
        else if(currentNode.getName().equals("<=") || currentNode.getName().equals(">=") || currentNode.getName().equals("==") 
        		|| currentNode.getName().equals("~=") || currentNode.getName().equals("<") || currentNode.getName().equals(">")){
        	if(currentNode.getParent().getName().equals("while")){
                unparse(currentNode.getChild(0));
                finalCode.append(currentNode.getName());
                unparse(currentNode.getChild(1));
                finalCode.append(")\n");
            }
            else{
                unparse(currentNode.getChild(0));
                finalCode.append(currentNode.getName());
                unparse(currentNode.getChild(1));
//                finalCode.append("\n");
//                finalCode.append("");
            }
        }
        
        /**----------------------------------FIELD_LIST----------------------------------**/
        /*used to specify the names of fields in a table constructor*/
        else if(currentNode.getName().equals("FIELD_LIST")){
        	for (int i = 0; i < currentNode.getChildCount(); i++){
        		unparse(currentNode.getChild(i));
        		if(i >= 0 && i < currentNode.getChildCount() - 1 && currentNode.getChildCount() > 1){
        			finalCode.append(",");
        		}
        	}
        }
        
        /**----------------------------------REQUIRE----------------------------------**/
        /*Specifies a call to a reserved function that is used to load and run libraries*/
        else if (currentNode.getName().equals("REQUIRE")){
        	finalCode.append("require ");
        	for (int i = 0; i < currentNode.getChildCount(); i++){
        		unparse(currentNode.getChild(i));
        		if(i >= 0 && i < currentNode.getChildCount() - 1 && currentNode.getChildCount() > 1){
        			finalCode.append(",");
        		}
        	}
        }
        
        /**----------------------------------FIN_IN----------------------------------**/
        /*I don't know what this does*/
        else if(currentNode.getName().equals("FIN_IN")){
        	
        }
        
        /**----------------------------------TABLE----------------------------------**/
        /*Used to specify a table constructor*/
        else if(currentNode.getName().equals("TABLE")){
        	finalCode.append("{");
        	for (int i = 0; i < currentNode.getChildCount(); i++){
        		unparse(currentNode.getChild(i));
        	}
        	finalCode.append("}");
        }
        
        /**----------------------------------LABEL----------------------------------**/
        /*Used with a goto statement*/
        else if(currentNode.getName().equals("LABEL")){
        	finalCode.append("::");
        	for (int i = 0; i < currentNode.getChildCount(); i++){
        		unparse(currentNode.getChild(i));
        	}
        	finalCode.append("::");
        }
 
        /*
         * Done with modification
         */
        
        /**----------------------------------True----------------------------------**/
        /*Indicates the boolean truth test before the even handler in an if-then-else statement*/
        else if(currentNode.getName().equals("True")){
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
            }
        }
        
        /**----------------------------------COL_CALL----------------------------------**/
        /*This specifies the contents within a call to an object method*/
        else if(currentNode.getName().equals("COL_CALL")){
        	finalCode.append("(");
        	unparse(currentNode.getChild(0));
        	finalCode.append(")");
        }
        
        /**----------------------------------FIELD----------------------------------**/
        /*used to index through tables*/
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
       
        /**----------------------------------INDEX----------------------------------**/
        /*This specifies a call to an object metod*/
        else if(currentNode.getName().equals("INDEX")){
        	//finalCode.append(":");
        	//unparse(currentNode.getChild(0));
        	if(currentNode.getChild(0).getName().charAt(0)=='\''){
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
        
        /**----------------------------------LOCAL_ASSIGNMENT----------------------------------**/
        /*This contains a variable name (L-value) and an expression (R-value)*/
        else if(currentNode.getName().equals("LOCAL_ASSIGNMENT")){
        	finalCode.append("local ");
        	unparse(currentNode.getChild(0));
            finalCode.append("=");
            unparse(currentNode.getChild(1));
            finalCode.append("\n");
        }
        
        /**----------------------------------NAME_LIST----------------------------------**/
        /*This contains a declaration of a local variable*/ 
        else if(currentNode.getName().equals("NAME_LIST")){
        	for(int i = 0; i < currentNode.getChildCount(); i++){
        		unparse(currentNode.getChild(i));
        		if(i >= 0 && i < currentNode.getChildCount() - 1 && currentNode.getChildCount() > 1){
        			finalCode.append(",");
        		}
        	}
        }
        
        /**----------------------------------UNARY_MINUS----------------------------------**/
        /*Used to negate an integer or a floating-point number*/
        else if(currentNode.getName().equals("UNARY_MINUS")){
        	finalCode.append("-");
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
            }
        }

        /**----------------------------------return----------------------------------**/
        /*used to return fields of functions*/
        else if(currentNode.getName().equals("return")){
            finalCode.append("return ");
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
                if(i>=0 && i<currentNode.getChildCount()-1 && currentNode.getChildCount()>1)
                    finalCode.append(",");
            }
            finalCode.append("\n");
        }
        
        /**----------------------------------or----------------------------------**/
        /*Indicates a logical or*/
        else if(currentNode.getName().equals("or")){
            unparse(currentNode.getChild(0));
            finalCode.append(" ");
            finalCode.append(currentNode.getName());
            finalCode.append(" ");
            unparse(currentNode.getChild(1));
//            finalCode.append(")\n");
        }
        
        /**----------------------------------and----------------------------------**/
        /*indicates a logical and*/
        else if(currentNode.getName().equals("and")){
            unparse(currentNode.getChild(0));
            finalCode.append(" ");
            finalCode.append(currentNode.getName());
            finalCode.append(" ");
            unparse(currentNode.getChild(1));
        }
        
        /**----------------------------------while----------------------------------**/
        /*indicates a while loop*/
        else if(currentNode.getName().equals("while")){
            finalCode.append("while(");
            unparse(currentNode.getChild(0));
            finalCode.append(")\n");
            for(int i=1 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
            }
//            finalCode.append("\n");
        }
        
        /**----------------------------------..----------------------------------**/
        /*used to indicate string concatenation*/
        else if(currentNode.getName().equals("..")){
            unparse(currentNode.getChild(0));
            finalCode.append(currentNode.getName());
            unparse(currentNode.getChild(1));
    //
        }
        
        /**----------------------------------repeat----------------------------------**/
        /*indicates a repeat-until statement. This is similar to a do-while loop.*/
        else if(currentNode.getName().equals("repeat")){
            finalCode.append("repeat\n");
            unparse(currentNode.getChild(0));
            finalCode.append("until ");
            unparse(currentNode.getChild(1));
            finalCode.append("\n");

        }
        
        /**----------------------------------#----------------------------------**/
        /*indicates the length operator, a unary operator that returns the number of the last populated element of an array*/
        else if(currentNode.getName().equals("#")){
            finalCode.append("#");
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
            }
        }
        
        /**--------------------------------------------------------------------**/
        /*The key value of the node currently visited is not a keyword. This is the final case.*/
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
