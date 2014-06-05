/**
 * Created by azadabbasi on 4/10/14.
 */

//import org.antlr.runtime.*;
//
//import java.io.FileInputStream;
//import java.io.InputStream;
//
//public class Demo {
//    public static void main(String[] args) throws Exception {
//        InputReader file = new InputReader(args[0]);
//
//        ANTLRStringStream in = new ANTLRStringStream(file.getString());
//        ExpLexer lexer = new ExpLexer(in);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        ExpParser parser = new ExpParser(tokens);
//        parser.parse();
//        System.out.println("Done");
//    }
//}

package parser;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;

public class Demo {

    private static void findFunctions(CommonTree tree) {
        if (tree == null) return;

        if(tree.getType() == LuaParser.ASSIGNMENT) {

            String name = tree.getChild(0).getChild(0).getText();
            CommonTree expressions = (CommonTree) tree.getChild(1);

            if(expressions.getChildCount() > 0 &&
                    expressions.getChild(0).getType() == LuaParser.FUNCTION) {

                System.out.println("walk the tree:\n  " + expressions.toStringTree() +
                        "\ntoo find all strings for event: '" + name + "'");
            }
        }
        else {
            for (int i = 0; i < tree.getChildCount(); i++) {
                findFunctions((CommonTree) tree.getChild(i));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        LuaLexer lexer = new LuaLexer(new ANTLRFileStream(args[0]));
        LuaParser parser = new LuaParser(new CommonTokenStream(lexer));
        CommonTree tree = (CommonTree) parser.parse().getTree();
        findFunctions(tree);
    }
}