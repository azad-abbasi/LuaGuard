/**
 * Created by azadabbasi on 4/10/14.2
 */
package parser;
import org.antlr.runtime.ANTLRFileStream;
    import org.antlr.runtime.CommonTokenStream;
    import org.antlr.runtime.tree.CommonTree;
//    import java.util.ArrayList;
//    import java.util.Arrays;

    public class MainClass {
//        public static ArrayList<String> places = new ArrayList<String>(
//                Arrays.asList("empty", "empty", "empty", "empty", "ASSIGNMENT", "ASSIGNMENT_VAR", "Add", "And", "Any",
//                        "Assign", "BinaryExponent", "Break", "CALL", "CBrace", "CBrack", "CHUNK", "COL_CALL",
//                        "CONDITION", "CPar", "Col", "ColCol", "Comma", "Comment", "Digit", "Div", "Do", "Dot",
//                        "DotDot", "DotDotDot", "EXPR_LIST", "Else", "Elseif", "End", "Eq", "EscapeSequence",
//                        "Exponent", "FIELD", "FIELD_LIST", "FOR_IN", "FUNCTION", "False", "For", "Function", "GT",
//                        "GTEq", "Goto", "HexDigit", "HexDigits", "INDEX", "If", "In", "LABEL",
//                        "LOCAL_ASSIGNMENT", "LT", "LTEq", "Length", "Letter", "LineBreak", "Local", "LongBracket",
//                        "Minus", "Mod", "Mult", "NAME_LIST", "NEq", "Name", "Nil", "Not", "Number",
//                        "OBrace", "Obrack", "OPar", "Or", "PARAM_LIST", "Pow", "Reapeat", "Return", "Scol", "Space",
//                        "String", "TABLE", "Then", "True", "UNARY_MINUS", "Until", "VAR", "VAR_LIST", "While"));
        public static String FinalTreeString = "";
        private static void printSimpleAST(CommonTree tree){
            System.out.println(tree.toStringTree());
        }


        //this file creates the structured Tree String with a CommonTree as the input
        //and puts the tree in the FinalTreeString variable(static)
        private static void createStructuredTree(CommonTree tree, int Indention){

            //Create the indention first
            String indent="";
            if (Indention > 0 ) {
                indent = new String(new char[Indention]).replace('\0', '\t');
            }
            //add indents to the final tree
            FinalTreeString += indent;
            //add the beginning parenthesis
            FinalTreeString += " ( ";
            //now we add the current Tree's name
            String tokenName = LuaParser.tokenNames[tree.getType()];
            String tokenText = tree.getText();

                if(tokenName.equals("String")){
                    FinalTreeString = FinalTreeString + " ' " + tree.toString() + " ' ";
                }
                else{
                    FinalTreeString += tree.toString();
                }


            //now we will have to print the children
            if(tree.getChildCount() > 0 ) {
                for (int i = 0 ; i<tree.getChildCount() ; i++){
                    //if this child didn't have any children
                    if(tree.getChild(i).getChildCount() == 0 ){
                        tokenName = LuaParser.tokenNames[tree.getChild(i).getType()];
                        tokenText = tree.getChild(i).getText();

                        if(tokenName.equals("String")){
                            FinalTreeString = FinalTreeString + " " + " ' " + tree.getChild(i).toString() + " ' ";
                        }
                        else{
                            FinalTreeString = FinalTreeString + " " + tree.getChild(i).toString();
                        }

                    }
                    else{
                        FinalTreeString += "\n";
                        for(int j = i ; j<tree.getChildCount(); j++){
                            createStructuredTree((CommonTree) tree.getChild(j), Indention + 1);
                        }
                        FinalTreeString = FinalTreeString + indent + " )\n";
                        break;
                    }
                    if(i == tree.getChildCount()-1)
                        FinalTreeString += " )\n";
                }
            }
            //else if you don't have any children
            else{
                FinalTreeString += " )\n";
            }
        }
        public static void main(String[] args) throws Exception {
            LuaLexer lexer = new LuaLexer(new ANTLRFileStream(args[0]));
            LuaParser parser = new LuaParser(new CommonTokenStream(lexer));
            CommonTree tree =  parser.parse().getTree();
            String treeString = tree.toStringTree();
            //now we feed the common tree "tree" to the createStructuredTree
            //and feed the Final string to the input reader to put it in a file.
            createStructuredTree(tree, 0);
//            printToSeparateFile(args[1],treeString);
            InputReader.printToFile(args[1], FinalTreeString);
            System.out.println(FinalTreeString);
//
        }
    }