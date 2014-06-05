/**
 * Created by azadabbasi on 4/10/14.2
 */
package main;
import obfuscator.Obfuscator;
import obfuscator.ControlFlowObfuscator;
import obfuscator.ParameterObfuscator;

import obfuscator.VocabObfuscator;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;
import parser.ASTgenerator;
import parser.InputReader;
import parser.LuaLexer;
import parser.LuaParser;

import unparser.TreeConstructor;
import unparser.Unparser;
import org.apache.commons.cli.*;

import java.util.ArrayList;

public class MainClass {

        public static void main(String[] args) throws Exception {
            String obfuName; // used to select obfuscation


            /**
             * THE PARSER STARTS HERE
             */
            //------------------------------------------------------------------------


            /**
             * PARSER ENDS HERE
             */
            //-------------------------------------------------------------------------
            /**
             * The ARGUMENT HANDLER STARTS HERE
             */
            //------------------------------------------------------------------------
            if (args.length < 2) {
                System.out.println("Welcome to LuaGuard Project \n");

                System.out.println("\n\nYou need at least two parameters to run this program");
                System.out.println("\t1: the path to the lua code you wish to obfuscate");
                System.out.println("\t2: the path to the output file you wish to have the results\n");
                System.out.println("You can run this code with the following options");
                System.out.println("\n\n\t-help\t this option brings up the help menu");
                System.out.println("\t-v\t\t performs the vocabulary obfuscation followed by the String manipulation technique");
                System.out.println("\t\t\t\t MinVocab");
                System.out.println("\t\t\t\t Reverse");
                System.out.println("\t\t\t\t XOR");
                System.out.println("\t\t\t\t ILOveOU");
                System.out.println("\t\t\t\t Boss");
                System.out.println("\t\t\t\t Confusing\n");
                System.out.println("\t-p\t\t performs parameter adding option");
                System.out.println("\t-s\t\t performs no Spacing Option");
                System.out.println("\t-c\t\t performs Control Flow obfuscation option");
                return;
            }
            LuaLexer lexer = new LuaLexer(new ANTLRFileStream(args[args.length - 2]));
            LuaParser parser = new LuaParser(new CommonTokenStream(lexer));
            CommonTree tree = parser.parse().getTree();

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
            InputReader.printToFile("output.txt", treeStructure);
            //control flag
            boolean flag = true;
            if (args.length >= 3) {
                for (int i = 0; i < args.length - 2; i++) {
                    if (args[i].charAt(0) == '-') {
                        //if we have options
                        if (args[i].contains("v")) {
                            //if we have the minimum vocabulary option
                /* Key words{ MinVocab,Reverse,XOR,ILOveOU,Boss,Confusing} = obfuName */
                            ArrayList<String> listofvocab = new ArrayList<String>();
                            listofvocab.add("MinVocab");
                            listofvocab.add("Reverse");
                            listofvocab.add("XOR");
                            listofvocab.add("ILOveOU");
                            listofvocab.add("Boss");
                            listofvocab.add("Confusing");

                            if (listofvocab.contains(args[args.length - 3])) {
                                TreeConstructor t3 = new TreeConstructor("output.txt");
                                VocabObfuscator vo = new VocabObfuscator(t3.getRoot(), args[args.length - 3]);
                                vo.obfuscate();
                                InputReader.printToFile("output.txt", t3.toString());
                            } else {
                                System.out.println("No such option for vocab obfuscation");
                                System.out.println("Try one of these options : ");
                                System.out.println("MinVocab Reverse XOR ILOveOU Boss Confusing");
                                return;
                            }
                        }
                        if (args[i].contains("p")) {
                            //if we have the parameter adding option:
                            TreeConstructor t2 = new TreeConstructor("output.txt");
                            ParameterObfuscator o = new ParameterObfuscator(t2.getRoot());
                            //call the Function
                            o.addParams();
                            InputReader.printToFile("output.txt", t2.toString());
                        }
                        if (args[i].contains("c")) {
                            TreeConstructor t = new TreeConstructor("output.txt");
                            ControlFlowObfuscator cfo = new ControlFlowObfuscator(t.getRoot());
                            //call the Function
                            cfo.CFOObfuscate();
                            InputReader.printToFile("output.txt", t.toString());
                        }
                        if (args[i].contains("s")) {
                            flag = false;
                        }

                        if (args[i].contains("help")) {
                            System.out.println("Welcome to LuaGuard Project \n");

                            System.out.println("\n\n You need at least two parameters to run this program");
                            System.out.println("\t1: the path to the lua code you wish to obfuscate");
                            System.out.println("\t2: the path to the output file you wish to have the results\n");
                            System.out.println("You can run this code with the following options");
                            System.out.println("\n\n\t-help\t this option brings up the help menu");
                            System.out.println("\t-v\t\t performs the vocabulary obfuscation followed by the String manipulation technique");
                            System.out.println("\n\t\t MinVocab");
                            System.out.println("\t\t Reverse");
                            System.out.println("\t\t XOR");
                            System.out.println("\t\t ILOveOU");
                            System.out.println("\t\t Boss");
                            System.out.println("\t\t Confusing\n");
                            System.out.println("\t-p\t\t performs parameter adding option");
                            System.out.println("\t-s\t\t performs no Spacing Option");
                            System.out.println("\t-c\t\t performs Control Flow obfuscation option");
                            return;

                        }

                    }
                }



                /**
                 * THE ARGUMENT HANDLER ENDS HERE
                 */
                //------------------------------------------------------------------------

                /**
                 * The OBFUSCATOR STARTS HERE
                 */

            }
            if (flag) {
                TreeConstructor myTree = new TreeConstructor("output.txt");
                InputReader.printToFile("output.txt", myTree.toString());
                Unparser myUnparser = new Unparser(myTree.getRoot());
                //if you want to unparse with spacing and new lines , pass "Spacing" to the unparse mehtod.
                // other wise, pass "noSpace";
                myUnparser.unparse("Spacing");
                System.out.println(myUnparser.getCode());
                InputReader.printToFile(args[1], myUnparser.getCode());
            } else {
                TreeConstructor myTree = new TreeConstructor("output.txt");
                InputReader.printToFile("output.txt", myTree.toString());
                Unparser myUnparser = new Unparser(myTree.getRoot());
                //if you want to unparse with spacing and new lines , pass "Spacing" to the unparse mehtod.
                // other wise, pass "noSpace";
                myUnparser.unparse("noSpace");
                System.out.println(myUnparser.getCode());
                InputReader.printToFile(args[1], myUnparser.getCode());
            }
        }

    }