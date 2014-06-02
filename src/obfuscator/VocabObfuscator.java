package obfuscator;

import unparser.Node;

import java.util.*;

/**
 * Created by azada on 6/1/14.
 */
public class VocabObfuscator {
    Node treeRoot;
    public Map<String, String> recVars = new HashMap<String, String>();
    public Map<String,String> recFunc = new HashMap<String, String>();
    public HashSet<String> usedNames = new HashSet<String>();
    public VocabObfuscator(Node treeRoot){
        this.treeRoot = treeRoot;
    }

    public void obfuscate(){
        process(treeRoot);
    }
    public void process(Node currentNode){
        if(currentNode.getName().equals("ASSIGNMENT")){
            int count = currentNode.getChildCount();
            for(int i=0;i<count ; i++){
                process(currentNode.getChild(i));
            }
        }
        else if(currentNode.getName().equals("LOCAL_ASSIGNMENT")){



            int count = currentNode.getChildCount();
            for(int i=0;i<count ; i++){
                process(currentNode.getChild(i));
            }
        }
        else if(currentNode.getName().equals("FUNCTION_ASSIGNMENT")){



            int count = currentNode.getChildCount();
            for(int i=0;i<count ; i++){
                process(currentNode.getChild(i));
            }
        }
        else if(currentNode.getName().equals("VAR_LIST")) {
            if(currentNode.getParent().getName().equals("ASSIGNMENT")) {
                for (int i = 0; i < currentNode.getChildCount(); i++) {
                    if (recVars.containsKey(currentNode.getChild(i).getName())) {
                        currentNode.getChild(i).setName(recVars.get(currentNode.getChild(i).getName()));
                    } else {
                        String randomvVar = randomVar();
                        recVars.put(currentNode.getChild(i).getName(), randomvVar);
                        currentNode.getChild(i).setName(randomvVar);
                    }
                }
            }
            else if(currentNode.getParent().getName().equals("FUNCTION_ASSIGNMENT")) {
                for (int i = 0; i < currentNode.getChildCount(); i++) {
                    if (recFunc.containsKey(currentNode.getChild(i).getName())) {
                        currentNode.getChild(i).setName(recFunc.get(currentNode.getChild(i).getName()));
                    }
                    else {
                        String randomvVar = randomVar();
                        recFunc.put(currentNode.getChild(i).getName(), randomvVar);
                        currentNode.getChild(i).setName(randomvVar);
                    }
                }
            }

        }
        else if(currentNode.getName().equals("NAME_LIST")){

            for (int i = 0; i < currentNode.getChildCount(); i++) {
                if (recVars.containsKey(currentNode.getChild(i).getName())) {
                    currentNode.getChild(i).setName(recVars.get(currentNode.getChild(i).getName()));
                } else {
                    String randomvVar = randomVar();
                    recVars.put(currentNode.getChild(i).getName(), randomvVar);
                    currentNode.getChild(i).setName(randomvVar);
                }
            }
        }
        else if(currentNode.getName().equals("PARAM_LIST")){
            if(currentNode.getParent().getName().equals("FUNCTION")) {
                for (int i = 0; i < currentNode.getChildCount(); i++) {
                    if (recVars.containsKey(currentNode.getChild(i).getName())) {
                        currentNode.getChild(i).setName(recVars.get(currentNode.getChild(i).getName()));
                    } else {
                        String randomvVar = randomVar();
                        recVars.put(currentNode.getChild(i).getName(), randomvVar);
                        currentNode.getChild(i).setName(randomvVar);
                    }
                }
            }
        }

        else if(currentNode.getName().equals("VAR")){
            if(currentNode.getChild(1).getName().equals("CALL")){
                if(recFunc.containsKey(currentNode.getChild(0).getName())){
                    currentNode.getChild(0).setName(recFunc.get(currentNode.getChild(0).getName()));
                }

            }

        }
        else if(currentNode.getName().equals("CALL")){
            int count = currentNode.getChildCount();
            for(int i=0;i<count ; i++){
                if (recVars.containsKey(currentNode.getChild(i).getName())) {
                    currentNode.getChild(i).setName(recVars.get(currentNode.getChild(i).getName()));
                }
            }
        }


        else{
            int count = currentNode.getChildCount();
            for(int i=0;i<count ; i++){
                process(currentNode.getChild(i));
            }
        }


    }

    public String randomVar(){
        String outputString = confusingString();
        while(usedNames.contains(outputString)){
            outputString = confusingString();
        }
        usedNames.add(outputString);
        return outputString;
    }

    public static String confusingString(){
        int length = 8;
        String abc = "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiilllllllllllllllllllljjjjjjjjjjjjjjjjjjjjabcdefghijklmnopqrstuvwxyz";
        Random r = new Random();

        StringBuilder sb = new StringBuilder(length);
        sb.append("iilii");
        for( int i = 0; i < length; i++ )
            sb.append( abc.charAt( r.nextInt(abc.length()) ) );
        return sb.toString();

    }
}
