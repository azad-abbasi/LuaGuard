/**
 * Created by azadabbasi on 4/17/14.
 */
package parser;
import java.io.*;

public class InputReader {
    private String output;

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

    public String getString(){
        return output;
    }
}

