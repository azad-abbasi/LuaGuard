/** 
 * created by Gabe Aron 5/13/2014 to test Unparser
 */
package unparser;

public class main {
	public static void main(String[] args){
		TreeConstructor tr = new TreeConstructor("ast1.txt");
		tr.printTree();
		
		Unparser up = new Unparser(tr.getRoot());
		up.unparse();
		System.out.println("Unparse");
		System.out.println(up.getCode());
	}
}
