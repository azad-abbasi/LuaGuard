package unparser;

import java.io.*;


//-------------------------------------------------------------
//Class Name : InputReader
//Purpose    : This Class is responsible to read and write to files.
//            as it's constructor argument and creates a structured proper
//            AST root and it will be available using the getAST method
//-------------------------------------------------------------
public class InputReader {
  private String output;

//-------------------------------------------------------------
//Method Name : Constructor
//Purpose    : This constructor takes the path to the target file
//            and reads that file into a global variable output
//-------------------------------------------------------------
  public InputReader(String path){

      try{

          //Create object of FileReader
          FileReader inputFile = new FileReader(path);

          //Instantiate the BufferedReader Class
          BufferedReader bufferReader = new BufferedReader(inputFile);

          //Variable to hold the one line data
          String line = new String();
          String temp;
          // Read file line by line and print on the console
          while ((temp = bufferReader.readLine()) != null)   {
              line += temp;
          }
          //Close the buffer reader
          this.output = line;
          bufferReader.close();
      }catch(Exception e){
          System.out.println("Error while reading file line by line:"
                  + e.getMessage());
      }


  }
//-------------------------------------------------------------
//Static Method Name: printToFile
//arguments: the path to the desired output & the String you wish to print to the file
//Purpose    : Print any desired string to the output
//-------------------------------------------------------------
  public static void printToFile(String path, String finalStr) {

      //creating a writer
      try {
          File file = new File(path);


          BufferedWriter output = new BufferedWriter(new FileWriter(file));

          output.write(finalStr);
          output.close();
      } catch ( IOException e ) {
          e.printStackTrace();
      }

  }
//-------------------------------------------------------------
//Static Method Name : PrintToSeparateFile
//arguments: path to the desired file, target String to print
//Purpose    : This method prints the target String to a file, if the file
//            exists, it will generate a separate file and prints the String into that
//-------------------------------------------------------------
  private static void printToSeparateFile(String path, String finalStr) {

      //creating a writer
      try {
          File file = new File(path+".txt");
          for (int i = 0 ; i<100 ; i++){
              if(file.exists()){
                  file = new File(path+i+".txt");
              }
              else{
                  break;
              }
          }

          BufferedWriter output = new BufferedWriter(new FileWriter(file));

          output.write(finalStr);
          output.close();
      } catch ( IOException e ) {
          e.printStackTrace();
      }

  }
//-------------------------------------------------------------
//Method Name : getString
//Purpose    : returns the string read by the constructor
//-------------------------------------------------------------
  public String getString(){
      return output;
  }
}

