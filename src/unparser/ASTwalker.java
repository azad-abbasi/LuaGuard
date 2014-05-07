/**
 * Created by Azad on 5/5/2014.
 * this file will walk through an AST
 * file and regenerates the tree
 */
package unparser;
public class ASTwalker {


    public static void main(String[] args) {
        TreeConstructor tree = new TreeConstructor(args[0]);
        tree.printTree();

    }
}
