package obfuscator;
import java.io.*;
import java.util.*;

/*
 *  Obfuscator program: obfuscate AST trees of LUA code files
 *  created by Areej Alghamdi
 *  April 28 2014
 *  CIS 523
 */

/*
 *  Obfuscator program: obfuscate AST trees of LUA code files
 *  updated by Dongyu Zhao
 *  May 21 2014
 *  Add some obfuscate functions
 *  use them  while obfuscating
 */


public class Obfuscator {
    String ast ;
    String out;
    //Map obfuscatedVars: keep track of the strings and thier transformations.
    //Key (orignial strings) = Zarray ->> Value(transformed strings) = aaaxxx
    
    public Obfuscator(String ast, String out){
        this.ast = new String(ast); // get the file to obfuscate
        this.out = new String(out);
    }
	public  Map<String, String> obfuscatedVars = new HashMap<String, String>();
    
    /*
     * Minimum Vocab Obfuscation
     * Input: String W
     * Output: String result: obfuscated string
     */
	public  String MinimumVocabObfuscation(String w){
		StringBuilder result = new StringBuilder(w.length()); //obfuscated word
        //		System.out.println(w);
		for(int i=0; i < w.length(); i++){
			char c = w.charAt(i);
			//System.out.println(c);
			int k= c - 96;
			//System.out.println(k);
			int num = k%26;
			k = k/26;
			int out = num+1+96;
			//System.out.println((char)out);
			result.append(Character.toString((char)(out)));
        }
        
        //		System.out.println(result.toString());
		return result.toString();
    }
	/*****************************************************************************************************/
	//added by dongyuzhao
	/*
     * String reverse Obfuscation
     * Input: String W e.g. abcde
     * Output: String result: obfuscated string  e.g. abced->decba
     */
	
	public String StringreverseObfuscation(String w){
		StringBuilder result = new StringBuilder(w.length()); //obfuscated word
		for(int i = w.length()-1 ; i>=0 ; i--){
			char c = w.charAt(i);
			result.append(c);
		}
		return result.toString();
	}
	
	/*
     * String XOR Obfuscation
     * Input: String W
     * Output: String result: obfuscated string
     */
	
	public String XORObfuscation(String w){
		
		int key = ast.length()%32;  // the key used in XOR encryption
		
		StringBuilder result = new StringBuilder(w.length()); //obfuscated word
		
		for(int i = 0 ; i < w.length() ; i++){
			char c = w.charAt(i);
			char _c = (char) (c ^ key);
			if(_c < 'A' || _c >'z' || (_c > 'Z' && _c < 'a'))
			{
				_c = c;
			}
			result.append(_c);
		}
		return result.toString();
	}
	
	/*
     * I love UO Obfuscation
     * Input: String W
     * Output: String result: obfuscated string
     */
	
	public String ILOveOUObfuscation(String w){
		String s = "iloveou";
		StringBuilder result = new StringBuilder(w.length()); //obfuscated word
		result.append('_');
		for(int i = 0 ; i < w.length() ; i++){
			char c = w.charAt(i);
			result.append(c);
			result.append(s.charAt(i%7));
		}
		return result.toString();
	}
	
	
	
	/*
     * BossObfuscation
     * this obfuscate uses a random number to chose which Obfuscation function to use
     * it is a union of obfuscation functions
     * Input: String W
     * Output: String result: obfuscated string
     *
     */
	
	public String BossObfuscation(String w){
		int a = (int)(1+ Math.random()*1000);
		System.out.println(a );
		StringBuilder result = new StringBuilder(w.length());
		switch(a%4)
		{
			case 0:
				result.append(MinimumVocabObfuscation(w));
				break;
			case 1:
				result.append(ILOveOUObfuscation(w));
				break;
			case 2:
				result.append(StringreverseObfuscation(w));
				break;
			case 3:
				result.append(XORObfuscation(w));
				break;
		}
		return result.toString();
	}
	
	/*****************************************************************************************************/
	
    /*
     * FileProcessing
     * Input: String AST (name of the AST file), String output (name for the output file)
     * Reads the AST file, run the obfuscation function and write to a new file the new obfuscated
     * AST file
     */
	public void FileProcessing(String obfuName) throws IOException{
		BufferedReader readAST = new BufferedReader(new FileReader(ast)); // open a buffer reader
		BufferedWriter output = new BufferedWriter(new FileWriter(out)); // open a buffer writer
        
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
//-----------------------------------------------------------------------
                    String transformedVar;
					if(obfuName.equals("MinVocab")){
						transformedVar = MinimumVocabObfuscation(var);
					}else if (obfuName.equals("Reverse")){
						transformedVar = StringreverseObfuscation(var);
					}else if (obfuName.equals("XOR")){
						transformedVar = XORObfuscation(var);
					}else if (obfuName.equals("ILOveOU")){
						transformedVar = ILOveOUObfuscation(var);
					}else{
						transformedVar = BossObfuscation(var);
					}
//-----------------------------------------------------------------------
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
		System.out.println("\nThe AsT File you specified : " + this.ast + " has been obfuscated.\nThe new obfuscated AST File is saved with the name : " + this.out + "\n");
	}
    
}
