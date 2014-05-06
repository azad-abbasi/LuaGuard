

/**
 * Created by azada on 4/24/14.
 */
package unparser;

import parser.InputReader;
public class Unparser {
















    public static void main(String[] args) {
        InputReader input = new InputReader(args[0]);
        String inputString = input.getString();
        System.out.println(inputString);
    }

}
