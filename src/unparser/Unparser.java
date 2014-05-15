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

        else if(currentNode.getName().equals("EXPR_LIST")){
                for(int i=0 ; i<currentNode.getChildCount() ; i++)
                    unparse(currentNode.getChild(i));
        }

        else if(currentNode.getName().equals("FUNCTION")){
        	//finalCode.append("function");
            for(int i=0 ; i<currentNode.getChildCount() ; i++)
                unparse(currentNode.getChild(i));
        }
        else if(currentNode.getName().equals("PARAM_LIST")){
            finalCode.append(" (");
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                if(i>0&& i<=currentNode.getChildCount()-1)
                    finalCode.append(",");
                finalCode.append(currentNode.getChild(i).getName());

            }
            finalCode.append(")");
            finalCode.append("\n");
        }

        else if(currentNode.getName().equals("VAR")){
        	//finalCode.append("var");
            if(currentNode.getChild(1).getName().equals("CALL") || currentNode.getChild(1).getName().equals("INDEX")){
                finalCode.append(currentNode.getChild(0).getName());
                for(int i=1 ; i<currentNode.getChildCount() ; i++)
                    unparse(currentNode.getChild(i));
            }
            //finalCode.append("\n");
        }
        else if(currentNode.getName().equals("CALL")){
            finalCode.append("(");
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                if(i>0&& i<=currentNode.getChildCount()-1)
                    finalCode.append(",");
                unparse(currentNode.getChild(i));
            }
            finalCode.append(")");
        }

        else if(currentNode.getName().equals("VAR_LIST")){
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
            }
        }


        else if(currentNode.getName().equals("ASSIGNMENT")){
            unparse(currentNode.getChild(0));
            finalCode.append("=");
            unparse(currentNode.getChild(1));
            finalCode.append("\n");
        }

        else if(currentNode.getName().equals("+") || currentNode.getName().equals("-")){
            finalCode.append("(");
            unparse(currentNode.getChild(0));
            finalCode.append(currentNode.getName());
            unparse(currentNode.getChild(1));
            finalCode.append(")");
        }
        else if(currentNode.getName().equals("/") || currentNode.getName().equals("*")){

            unparse(currentNode.getChild(0));
            finalCode.append(currentNode.getName());
            unparse(currentNode.getChild(1));

        }

        else if(currentNode.getName().equals("if")){
        	finalCode.append("if");
        	finalCode.append(" ");
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
            }
            //finalCode.append(" ");
        }

        else if(currentNode.getName().equals("CONDITION")){
        	//finalCode.append("condition");
            for(int i=0 ; i<currentNode.getChildCount() ; i++){
                unparse(currentNode.getChild(i));
            }
        }
        
        /*
         * Modified by Gabe Aron
         */
        
        /*This specifies a binary comparison within an if statement*/
        else if(currentNode.getName().equals("<=") || currentNode.getName().equals(">=") || currentNode.getName().equals("==")){
        	finalCode.append(currentNode.getChild(0).getName());
        	finalCode.append(currentNode.getName());
        	finalCode.append(currentNode.getChild(1).getName());
        	finalCode.append(" then");
        }

        else if(currentNode.getName().equals("ASSIGNMENT_VAR")){
        	
        }
        
        /*This specifies the contents within a call to an object method*/
        else if(currentNode.getName().equals("COL_CALL")){
        	finalCode.append("(");
        	unparse(currentNode.getChild(0));
        	finalCode.append(")");
        }
        
        else if(currentNode.getName().equals("FIELD")){
        	
        }
        
        else if(currentNode.getName().equals("FIELD_LIST")){
        	
        }
        
        else if(currentNode.getName().equals("FIN_IN")){
        	
        }
        
        /*This specifies a call to an object metod*/
        else if(currentNode.getName().equals("INDEX")){
        	finalCode.append(":");
        	unparse(currentNode.getChild(0));
        }
        
        else if(currentNode.getName().equals("LABEL")){
        	
        }
        
        /*This contains a variable name (L-value) and an expression (R-value)*/
        else if(currentNode.getName().equals("LOCAL_ASSIGNMENT")){
        	 unparse(currentNode.getChild(0));
             finalCode.append("=");
             unparse(currentNode.getChild(1));
        }
        
        else if(currentNode.getName().equals("NAME_LIST")){
        	
        }
        
        else if(currentNode.getName().equals("TABLE")){
        	
        }
        
        else if(currentNode.getName().equals("UNARY_MINUS")){
        	
        }
        
        else if(currentNode.getName().equals("FUNCTION_FUNCTIONS")){
        	
        }

        else if(!keywords.contains(currentNode.getName())){
            finalCode.append(currentNode.getName());
        }



    }


    public String getCode(){
        return code;
    }

}
