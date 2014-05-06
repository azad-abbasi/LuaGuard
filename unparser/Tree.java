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
		return ast;
	}
	
	public static void treeBuilder(Vector<String> ast){
		int i;
		int index = 0;
		boolean popOnce = false;
		boolean popTwice = false;
		boolean mightPopOnce = false;
		boolean mightPopTwice = false;
		
		
		for (String line : ast){								//for each line in the AST tree
			
			Stack.push(line);
			
			
			popOnce = false;
			popTwice = false;
			mightPopOnce = false;
		
			for (i = 0; i < line.length(); i++){					//for each character in each line
				
				if (Character.toString(line.charAt(i)).equals("(")){		//we may need to pop once
					mightPopOnce = true;
					mightPopTwice = true;
					System.out.println("hi");
				}
				if (mightPopOnce && Character.toString(line.charAt(i)).equals(")")){	//enclosed statement in parentheses needs to be popped
					popOnce = true;
				}
				else if (mightPopTwice && Character.toString(line.charAt(i)).equals(")")){	//need to pop twice
					popTwice = true;
					mightPopTwice = false;			//only is negated here, since it is testing the next line for ")"
				}
			}
			if (popOnce){		//must pop an item off the stack and find the string value directly preceding it. This is a leaf node.
				String child = Stack.pop();	//pop the line that was just pushed onto the stack
				String parent = Stack.parent();	//retrieve name of preceding line. This will be a temporary value for parent in the tree
				
				//insert node with key of popped stack element onto tree. Assign its temporary parent to the name of the parent//
				//Node elem = new Node(child, parent);
			}
			else if (popTwice){		//must pop two items off the stack and find the string value directly preceding them. child2 is a leaf node.
				String child1 = Stack.pop();
				String child2 = Stack.pop();
				String parent = Stack.parent();
				
				System.out.println("pop twice " + "Child1:" + "Child2:"+child2);
				
				//insert nodes with keys of popped stack element onto tree. Assign their shared temporary parent to the name of the parent//
				//Node elem1 = new Node(child1, parent);
				//Node elem2 = new Node(child2, parent);
			}
			else{
				index++;
			}
		}
		Stack.printStack();
	}

	public static void main(String[] args){
		//call AST retrieval function
		Vector<String> ast = fileReader("testIn.txt");
		
		//test fileReader
		for (String line : ast){
			System.out.println(line);
		}
		System.out.println("size:"+ast.size());
		
		//execute treeBuilder
		treeBuilder(ast);
	}


}
