import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;

public class Tree {
	public static Vector<String> fileReader(String inp){	
		//open buffered reader 
		BufferedReader br = null;
		
		Vector<String> ast = new Vector<String>();		//stores all lines within the AST tree 
		
		try
		{	
			String str;		//temporarily stores one line at a time
			//int line = 0; 	//number of lines. Used for indexing
					
			//assign input file to buffer reader
			br = new BufferedReader(new FileReader("testIn.txt"));
					
			//read from input file
			while ((str = br.readLine()) != null)
			{
				int blankLine = str.length();		//used to test for blank lines
				int ind = 0;
				char[] temp = new char[100];
				for (int i = 0; i < str.length(); i++){
					if (Character.toString(str.charAt(i)).equals(" ")){				//for each character
						blankLine -= i;
					}
					if (!Character.toString(str.charAt(i)).equals("\t") && !Character.toString(str.charAt(i)).equals("+")){
						temp[ind] = str.charAt(i);
						ind++;
					}
				}
				
				if (blankLine != 0){
					str = new String(temp);
					ast.add(new String(str)); //indentation.addElement(new Integer(count));
				}
			}
		} catch(IOException e){
			e.printStackTrace();
		}
				
		finally 
		{
			try 
			{
				if (br != null)
				{
					br.close();
				}
			} catch (IOException ex){
			ex.printStackTrace();
			}
		}
		//**have to classify tokens in the event of multiple occurance
		int count;			//used for the inner-inner loop
		int i;				//used for the inner loop
		int index = 0;		//used for the outer loop
		for (String s : ast){
			count = 0;	
			i = 0;
			for (String t : ast){
				if (s.equals(t) && !Character.toString(s.charAt(0)).equals(")") && i > index){
					String c = Integer.toString(count);
					
					/**assign c to s*/
					t = c + t;
					
					ast.set(i, t);
					count++;
				}
				i++;
			}
			index++;
		}
		
		return ast;
	}
	
	public static void merge(Vector<Node> forest){					//will merge the suptree into one tree
		Vector<Node> tree = new Vector<Node>();
		Node root = new Node(" ");
		
		
		/**test. prints out subtrees*/
		/**for (Node n : forest)
		{
			System.out.println("name:" + n.name);
			System.out.println("parent:" + n.nameOfParent);
		}*/
		
		int j = 0;		//for inner loop
		int k = 0;		//for outer loop
		for (Node n : forest){
			j = 0;
			for (Node m : forest){
				if (m.nameOfParent.equals(n.nameOfParent) && j > k){
					n.getParent().setChild(m.name);
					tree.add(n.getParent());
				}
				
				j++;
			}
			k++;
		}
		
		for (Node i : tree){
			i.print();
		}
	}
	
	public static void treeBuilder(Vector<String> ast){
		Vector<Node> forest = new Vector<Node>();	//keeps track of trees in forest
		int i;
		int index = 0;
		boolean popOnce = false;
		boolean popTwice = false;
		boolean mightPopOnce = false;
		
		
		for (String line : ast){								//for each line in the AST tree
			
			Stack.push(line);
			
			
			popOnce = false;
			popTwice = false;
			mightPopOnce = false;
		
			for (i = 0; i < line.length(); i++){					//for each character in each line
				
				if (Character.toString(line.charAt(i)).equals("(")){		//we may need to pop once
					mightPopOnce = true;
				}
				if (mightPopOnce && Character.toString(line.charAt(i)).equals(")")){	//enclosed statement in parentheses needs to be popped
					popOnce = true;
				}
				else if (Character.toString(line.charAt(i)).equals(")")){	//need to pop twice
					popTwice = true;
				}
			}
			if (popOnce){		//must pop an item off the stack and find the string value directly preceding it. This is a leaf node.
				String parent = Stack.parent();	//retrieve name of preceding line. This will be a temporary value for parent in the tree
				String child = Stack.pop();	//pop the line that was just pushed onto the stack
				
				Node elem = new Node(child);
				elem.setParent(parent);
				elem.getParent().setChild(elem.name);
				
				//insert node with key of popped stack element onto tree. Assign its temporary parent to the name of the parent//
				forest.add(elem);
				
				//System.out.println("child:"+child);
				//System.out.println("parent:"+parent);
			}
			else if (popTwice){		//must pop two items off the stack and find the string value directly preceding them. child2 is a leaf node.
				//System.out.print("popTwice ");
				String child1 = Stack.pop();
				String parent = Stack.parent();
				String child2 = Stack.pop();

				//System.out.println(" parent" + parent);
				
				//System.out.println("child1"+child1+"Child2:"+child2);
				
				Node elem1 = new Node(child1);
				Node elem2 = new Node(child2);
				
				elem1.setParent(parent);
				elem2.setParent(parent);
				elem1.getParent().setChild(elem1.name);
				elem2.getParent().setChild(elem2.name);
				
				//insert nodes with keys of popped stack element onto tree. Assign their shared temporary parent to the name of the parent//
				forest.add(elem1);
				forest.add(elem2);
				
				//System.out.println("child1:"+child1);
				//System.out.println("child2:"+child2);
				//System.out.println("parent:"+parent);
			}
			else{
				index++;
			}
		}
		Stack.printStack();
		
		merge(forest);
	}

	public static void main(String[] args){
		//call AST retrieval function
		Vector<String> ast = fileReader("testIn.txt");
		
		//test fileReader
		/**for (String line : ast){
			System.out.println(line);
		}
		System.out.println("size:"+ast.size());*/
		
		//execute treeBuilder
		treeBuilder(ast);
	}

}
