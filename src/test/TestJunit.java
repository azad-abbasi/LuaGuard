package test;

import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import org.junit.Test;
import parser.ASTgenerator;
import parser.InputReader;
import parser.LuaLexer;
import parser.LuaParser;
import unparser.TreeConstructor;
import unparser.Unparser;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
/**
 * Created by WH on 5/10/2014.
 */

/**
 * Created by WH on 5/10/2014.
 */
public class TestJunit {
        /*
        if(args.length<3){
            System.out.println("\n    This class takes 3 arguments:" +
                    "\n     1:the path to the input file which contains the Lua code" +
                    "\n     2:the path to the desired output path" +
                    "\n     3:the path to the desired unparser path");
            return;
        }*/
    private void helpTest(String p1, String p2, String p3) throws Exception{
        /**
         * The ARGUMENT HANDLER STARTS HERE
         */
        //------------------------------------------------------------------------
//        if(args.length<3){
//            System.out.println("\n    This class takes 3 arguments:" +
//                    "\n     1:the path to the input file which contains the Lua code" +
//                    "\n     2:the path to the desired output path" +
//                    "\n     3:the path to the desired unparser path");
//            return;
//        }

        /**
         * THE ARGUMENT HANDLER ENDS HERE
         */
        //------------------------------------------------------------------------

        /**
         * THE PARSER STARTS HERE
         */
        //------------------------------------------------------------------------
        LuaLexer lexer = new LuaLexer(new ANTLRFileStream(p1));
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
//            System.out.println(treeString);

        //static method printToFile prints the tree into a file.
        InputReader.printToFile(p2, treeStructure);

        /**
         * PARSER ENDS HERE
         */
        //-------------------------------------------------------------------------

        /**
         * The OBFUSCATOR STARTS HERE
         */
        //-------------------------------------------------------------------------
        //the Obfuscator goes here , whatever level we decide to have
//                            Obfuscator myOb = new Obfuscator(args[1],args[2]);
//                            //call the fileProcessing Function
//                            try{
//                                myOb.FileProcessing();
//                            }catch(Exception e){e.printStackTrace();
//                            }

        /**
         * The OBFUSCATOR ENDS HERE
         */
        //-------------------------------------------------------------------------

        /**
         * The UNPARSER STARTS HERE
         */
        //-------------------------------------------------------------------------
        //read the AST file back to a tree
        TreeConstructor myTree = new TreeConstructor(p2);
        InputReader.printToFile(p3,myTree.toString());
//        Unparser myUnparser = new Unparser(myTree.getRoot());
//        myUnparser.unparse();
//        System.out.println(myUnparser.getCode());
//        InputReader.printToFile(args[3],myUnparser.getCode());

        //-------------------------------------------------------------------------
    }

    private void compareFiles(String p2, String p3, String p4) throws Exception {

        FileInputStream fstream1 = new FileInputStream(p2);
        FileInputStream fstream2 = new FileInputStream(p3);

        DataInputStream in1= new DataInputStream(fstream1);
        DataInputStream in2= new DataInputStream(fstream2);

        BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));

        String strLine1, strLine2;

        String diff="";
        int lineNum=1;
        while((strLine1 = br1.readLine()) != null && (strLine2 = br2.readLine()) != null){
            if((strLine1.equals(strLine2))== false){
                /*System.out.print("line#:"+lineNum+"  ");
                System.out.print("AST:"+strLine1);
                System.out.print("!=  ");
                System.out.print("ExpectedAST:"+strLine2);
                System.out.println();*/
                diff=diff+"line#:"+lineNum+"  "+"AST:"+strLine1+"  !=  "+"ExpectedAST:"+strLine2+"\n";
            }
            lineNum++;
        }
        InputReader.printToFile(p4, diff);
//        File newTextFile3 = new File(p4);
//        FileWriter fw3 = new FileWriter(newTextFile3);
//        fw3.flush();
//        fw3.write(diff);
//        fw3.close();
    }

    @Test
    public void testCase() throws Exception{
        for(int i = 1; i < 16; i++) {
            String p1 = "testCases/T" + i + ".lua";
            String p2 = "RESULT/AstResult/ast"+i+".txt";
            String p3 = "RESULT/ExpectedASTResult/ExpectedAST"+i+".txt";
            String p4 = "RESULT/Difference/diff"+i+".txt";
            System.out.println("********Testing filename t" +i+".txt**********");
            helpTest(p1, p2, p3);
            //compare two AST tree and print out the different lines
            compareFiles(p2,p3,p4);

        }

    }

}