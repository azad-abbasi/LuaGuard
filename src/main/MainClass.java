/**
 * Created by azadabbasi on 4/10/14.2
 */
package main;
import obfuscator.Obfuscator;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import parser.InputReader;
import parser.LuaLexer;
import parser.LuaParser;
import parser.MyASTgenerator;
import unparser.TreeConstructor;


    public class MainClass {

        public static void main(String[] args) throws Exception {

            if(args.length<3){
                System.out.println("\n    This class takes 3 arguments:" +
                        "\n     1:the path to the input file which contains the Lua code" +
                        "\n     2:the path to the desired output path" +
                        "\n     3:the path to the desired unparser path");
                return;
            }
            LuaLexer lexer = new LuaLexer(new ANTLRFileStream(args[0]));
            LuaParser parser = new LuaParser(new CommonTokenStream(lexer));
            CommonTree tree =  parser.parse().getTree();
            String treeString = tree.toStringTree();

            /**now we feed the common tree "tree" to the createStructuredTree
            and feed the Final string to the input reader to put it in a file.
            **/

            MyASTgenerator myAST = new MyASTgenerator(tree);
            String treeStructure = myAST.getAST();
//            printToSeparateFile(args[1],treeString);
            InputReader.printToFile(args[1], treeStructure);

//            String ast = new String(); // get the file to obfuscate
//            String out = new String(args[2]); // desired name for the obfuscated file
            Obfuscator myOb = new Obfuscator(args[1],args[2]);
            //call the fileProcessing Function
            try{
                myOb.FileProcessing();
            }catch(Exception e){e.printStackTrace();
            }


            TreeConstructor myTree = new TreeConstructor(args[2]);
//            System.out.println(myTree.getRoot().getChild(0).getName());
            InputReader.printToFile(args[2],myTree.toString());
//            myTree.printTreeTokens();


//            System.out.println(treeStructure);
//
        }
    }