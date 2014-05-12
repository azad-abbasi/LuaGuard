/**
 * Created by azadabbasi on 4/10/14.2
 */
package main;
import obfuscator.Obfuscator;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import parser.ASTgenerator;
import parser.InputReader;
import parser.LuaLexer;
import parser.LuaParser;
import unparser.TreeConstructor;


    public class MainClass {

        public static void main(String[] args) throws Exception {
            /**
             * The ARGUMENT HANDLER STARTS HERE
             */
            //------------------------------------------------------------------------
            if(args.length<3){
                System.out.println("\n    This class takes 3 arguments:" +
                        "\n     1:the path to the input file which contains the Lua code" +
                        "\n     2:the path to the desired output path" +
                        "\n     3:the path to the desired unparser path");
                return;
            }

            /**
             * THE ARGUMENT HANDLER ENDS HERE
             */
            //------------------------------------------------------------------------

            /**
             * THE PARSER STARTS HERE
             */
            //------------------------------------------------------------------------
            LuaLexer lexer = new LuaLexer(new ANTLRFileStream(args[0]));
            LuaParser parser = new LuaParser(new CommonTokenStream(lexer));
            CommonTree tree =  parser.parse().getTree();

            // we can create an unstructured tree using the following method
            String treeString = tree.toStringTree();

            /**now we feed the common root "root" to the createStructuredTree
            and feed the Final string to the input reader to put it in a file.
            **/
            //ASTgenerator reads the tree into a structured tree
            ASTgenerator myAST = new ASTgenerator(tree);
            String treeStructure = myAST.getAST();

            //static method printToFile prints the tree into a file.
            InputReader.printToFile(args[1], treeStructure);

            /**
             * PARSER ENDS HERE
             */
            //-------------------------------------------------------------------------

            /**
             * The OBFUSCATOR STARTS HERE
             */
            //-------------------------------------------------------------------------
            //the Obfuscator goes here , whatever level we decide to have
            Obfuscator myOb = new Obfuscator(args[1],args[2]);
            //call the fileProcessing Function
            try{
                myOb.FileProcessing();
            }catch(Exception e){e.printStackTrace();
            }

            /**
             * The OBFUSCATOR ENDS HERE
             */
            //-------------------------------------------------------------------------

            /**
             * The UNPARSER STARTS HERE
             */
            //-------------------------------------------------------------------------
            //read the AST file back to a tree
            TreeConstructor myTree = new TreeConstructor(args[2]);
            InputReader.printToFile(args[2],myTree.toString());

            //-------------------------------------------------------------------------
        }
    }