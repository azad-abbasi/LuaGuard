package parser;

import java.io.*;
import java.util.*;

/*
 *  Obfuscator program: obfuscate AST trees of LUA code files
 *  created by Areej Alghamdi
 *  April 28 2014
 *  CIS 523
 */


public class Obfuscator {
    
    //Map obfuscatedVars: keep track of the strings and thier transformations.
    //Key (orignial strings) = Zarray ->> Value(transformed strings) = aaaxxx
    
	public static Map<String, String> obfuscatedVars = new HashMap<String, String>();
    
    /*
     * Minimum Vocab Obfuscation
     * Input: String W
     * Output: String result: obfuscated string
     */
	public static String MinimumVocabObfuscation(String w){
        //System.out.println("Inside the obfuscator");
		String result = "dummy"; //obfuscated word
        
        // the transformation code
        // ...

		return result;
	}
	
    /*
     * FileProcessing
     * Input: String AST (name of the AST file), String output (name for the output file)
     * Reads the AST file, run the obfuscation function and write to a new file the new obfuscated
     * AST file
     */
	public static void FileProcessing(String AST, String Output) throws IOException{
		BufferedReader readAST = new BufferedReader(new FileReader(AST)); // open a buffer reader
		BufferedWriter output = new BufferedWriter(new FileWriter(Output)); // open a buffer writer
        
		int x=0; //Line counter for printing. and testing purposes
        
		String s;
		StringTokenizer tokenizer;
        
		while((s = readAST.readLine()) != null){
			//System.out.println("Line # " + x);
			x++;
			tokenizer = new StringTokenizer(s,"()\t\n ", true);
			while(tokenizer.hasMoreTokens()){
				String token = tokenizer.nextToken();
				// if variable name or function name obfuscate
				if((token.equals("VAR_LIST")) || (token.equals("PARAM_LIST"))){
					// write to the text file
					output.write(token);
                    String space = tokenizer.nextToken();
                    output.write(space);
					String var = tokenizer.nextToken();
					String transformedVar = MinimumVocabObfuscation(var);
					obfuscatedVars.put(var, transformedVar);
					output.write(transformedVar);
                //check if the string following VAR is in the MAP or a name for built in function
                }else if(token.equals("VAR")){
					output.write("VAR");
					String space = tokenizer.nextToken();
                   	output.write(space);
					String var = tokenizer.nextToken();
					if(obfuscatedVars.containsKey(var)){
						output.write(obfuscatedVars.get(var));
					}else{
						output.write(var); // it is a name for a built in function
                    }
                // change any instance of this token if it is in the MAP with the obfuscated version
				}else if(obfuscatedVars.containsKey(token)){
					output.write(obfuscatedVars.get(token));
				}else{
                    // for any other token, just write
					output.write(token);
				}
			}
			output.write("\n"); // a line ended in the AST
		}
		output.close(); // close the writer
		readAST.close(); // close the reader
		System.out.println("\nThe AST File you specified : " + AST + " has been obfuscated.\nThe new obfuscated AST File is saved with the name : " + Output + "\n");
	}
	
	public static void main(String[] args){
		String ast = new String(args[0]); // get the file to obfuscate
		String out = new String(args[1]); // desired name for the obfuscated file
		
		//call the fileProcessing Function
		try{
			FileProcessing(ast, out);
		}catch(Exception e){e.printStackTrace();}
	}
}
