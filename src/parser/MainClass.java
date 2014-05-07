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

        public static void main(String[] args) throws Exception {
            LuaLexer lexer = new LuaLexer(new ANTLRFileStream(args[0]));
            LuaParser parser = new LuaParser(new CommonTokenStream(lexer));
            CommonTree tree =  parser.parse().getTree();
            String treeString = tree.toStringTree();
            //now we feed the common tree "tree" to the createStructuredTree
            //and feed the Final string to the input reader to put it in a file.
            MyASTgenerator myAST = new MyASTgenerator(tree);
            String treeStructure = myAST.getAST();
//            printToSeparateFile(args[1],treeString);
            InputReader.printToFile(args[1], treeStructure);



//            TreeConstructor myTree = new TreeConstructor(args[1]);
//            InputReader.printToFile(args[2],myTree.toString());
//            myTree.printTreeTokens();


            System.out.println(treeStructure);
//
        }
    }