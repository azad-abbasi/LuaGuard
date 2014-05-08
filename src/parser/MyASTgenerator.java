package parser;

import org.antlr.runtime.tree.CommonTree;

/**
 * Created by azada on 5/7/14.
 */
public class MyASTgenerator {

    private static String finalTreeString = "";
    public CommonTree tree;
    //you just have to pass the common tree to the parser to greate the AST tree
    //and print it to the output
    public MyASTgenerator(CommonTree tree){
        this.tree = tree;
        createStructuredTree(tree,0);
    }
    public String getAST(){
        return finalTreeString;
    }

    public void printSimpleAST(){
        System.out.println(tree.toStringTree());
    }


    //this file creates the structured Tree String with a CommonTree as the input
    //and puts the tree in the finalTreeString variable(static)
    public static void createStructuredTree(CommonTree tree, int Indention){

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
        String tokenName = LuaParser.tokenNames[tree.getType()];
        String tokenText = tree.getText();

        if(tokenName.equals("String")){
            finalTreeString = finalTreeString + " ' " + tree.toString() + " ' ";
        }
        else{
            finalTreeString += tree.toString();
        }


        //now we will have to print the children
        if(tree.getChildCount() > 0 ) {
            for (int i = 0 ; i<tree.getChildCount() ; i++){
                //if this child didn't have any children
                if(tree.getChild(i).getChildCount() == 0 ){
                    tokenName = LuaParser.tokenNames[tree.getChild(i).getType()];
                    tokenText = tree.getChild(i).getText();

                    if(tokenName.equals("String")){
                        finalTreeString = finalTreeString + " " + " ' " + tree.getChild(i).toString() + " ' ";
                    }
                    else{
                        finalTreeString = finalTreeString + " " + tree.getChild(i).toString();
                    }

                }
                else{
                    finalTreeString += "\n";
                    for(int j = i ; j<tree.getChildCount(); j++){
                        createStructuredTree((CommonTree) tree.getChild(j), Indention + 1);
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
