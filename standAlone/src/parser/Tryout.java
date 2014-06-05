/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2014 by Bart Kiers
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * Project      : lua-parser; a Lua 5.2 grammar/parser
 * Developed by : Bart Kiers, bart@big-o.nl
 */
package parser;
import org.antlr.runtime.ANTLRFileStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.tree.CommonTree;

import java.util.ArrayList;
import java.util.List;

/**
 * A small demo class that demonstrates how to use the
 * generated parser classes.
 */
public class Tryout {

    @SuppressWarnings("unchecked")
    private static void walk(CommonTree tree, StringBuilder builder) {

        List<CommonTree> firstStack = new ArrayList<CommonTree>();
        firstStack.add(tree);

        List<List<CommonTree>> childListStack = new ArrayList<List<CommonTree>>();
        childListStack.add(firstStack);

        while (!childListStack.isEmpty()) {

            List<CommonTree> childStack = childListStack.get(childListStack.size() - 1);

            if (childStack.isEmpty()) {
                childListStack.remove(childListStack.size() - 1);
            }
            else {
                tree = childStack.remove(0);

                String indent = "";

                for (int i = 0; i < childListStack.size() - 1; i++) {
                    indent += (childListStack.get(i).size() > 0) ? "|  " : "   ";
                }

                String tokenName = LuaParser.tokenNames[tree.getType()];
                String tokenText = tree.getText();

                builder.append(indent)
                        .append(childStack.isEmpty() ? "'- " : "|- ")
                        .append(tokenName)
                        .append(!tokenName.equals(tokenText) ? "='" +
                                tree.getText().replace("\n", "\\n").replace("\r", "\\r").replace("'", "\\'")
                                + "'" : "")
                        .append("\n");

                if (tree.getChildCount() > 0) {
                    childListStack.add(new ArrayList<CommonTree>((List<CommonTree>)tree.getChildren()));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        if(args.length == 0) {
            throw new IllegalArgumentException("no Lua file(s) provided as a command line parameter");
        }

        for (String fileName : args) {

            System.out.printf("\nParsing `%s`...\n\n", fileName);

            // Create the lexer and parser.
            LuaLexer lexer = new LuaLexer(new ANTLRFileStream(fileName));
            LuaParser parser = new LuaParser(new CommonTokenStream(lexer));

            // Print the AST of the source file by manually traversing the AST.
            CommonTree ast = parser.parse().getTree();
            System.out.println(ast.toStringTree());
            StringBuilder builder = new StringBuilder();
            walk(ast, builder);
            System.out.println(builder);

            // Now let the root walker traverse the AST and print some
            // information about the `assignment` rule.
//            LuaWalker walker = new LuaWalker(new CommonTreeNodeStream(ast));
//            walker.walk();
        }
    }
}