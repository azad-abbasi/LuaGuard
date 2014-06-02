package obfuscator;

import unparser.Node;

import java.util.*;

/**
 * Created by azada on 6/1/14.
 */
public class VocabObfuscator {
    Node treeRoot;
    String type;
    int keyNum ;
    public Map<String, String> recVars = new HashMap<String, String>();
    public Map<String,String> recFunc = new HashMap<String, String>();
    public HashSet<String> usedNames = new HashSet<String>();
    public VocabObfuscator(Node treeRoot, String type){
        this.treeRoot = treeRoot;
        this.type = type;
        Random r = new Random();
        keyNum = r.nextInt(900);
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
                        String randomvVar = randomVar(currentNode.getChild(i).getName());
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
                        String randomvVar = randomVar(currentNode.getChild(i).getName());
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
                    String randomvVar = randomVar(currentNode.getChild(i).getName());
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
                        String randomvVar = randomVar(currentNode.getChild(i).getName());
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
            int count = currentNode.getChildCount();
            for(int i=0;i<count ; i++){
                process(currentNode.getChild(i));
            }

        }
        else if(currentNode.getName().equals("CALL")){
            int count = currentNode.getChildCount();
            for(int i=0;i<count ; i++){
                if (recVars.containsKey(currentNode.getChild(i).getName())) {
                    currentNode.getChild(i).setName(recVars.get(currentNode.getChild(i).getName()));
                }
            }
            for(int i=0;i<count ; i++){
                process(currentNode.getChild(i));
            }
        }



        else{
            if (recVars.containsKey(currentNode.getName())) {
                currentNode.setName(recVars.get(currentNode.getName()));
            }
            int count = currentNode.getChildCount();
            for(int i=0;i<count ; i++){
                process(currentNode.getChild(i));
            }
        }


    }

    public String randomVar(String s) {
        /* Key words{ MinVocab,Reverse,XOR,ILOveUO,Boss,Confusing} = obfuName */
        String outputString = "";
        if (type.equals("MinVocab")) {
            outputString = MinimumVocabObfuscation(s);
            while (usedNames.contains(outputString)) {
                outputString = MinimumVocabObfuscation(s);
            }
            usedNames.add(outputString);
        } else if (type.equals("Reverse")) {
            outputString = StringreverseObfuscation(s);
            while (usedNames.contains(outputString)) {
                outputString = StringreverseObfuscation(s);
            }
            usedNames.add(outputString);
        } else if (type.equals("XOR")) {
            outputString = XORObfuscation(s);
            while (usedNames.contains(outputString)) {
                outputString = XORObfuscation(s);
            }
            usedNames.add(outputString);
        } else if (type.equals("ILOveUO")) {
            outputString = ILOveOUObfuscation(s);
            while (usedNames.contains(outputString)) {
                outputString = ILOveOUObfuscation(s);
            }
            usedNames.add(outputString);

        }else if(type.equals("Boss")){
            outputString = BossObfuscation(s);
            while (usedNames.contains(outputString)) {
                outputString = BossObfuscation(s);
            }
            usedNames.add(outputString);
        }else if(type.equals("Confusing")) {
            outputString = confusingString();
            while (usedNames.contains(outputString)) {
                outputString = confusingString();
            }
            usedNames.add(outputString);
        }



        return outputString;
    }

    public static String confusingString(){
        int length = 8;
        String abc = "iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiilllllllllllllllllllljjjjjjjjjjjjjjjjjjjjABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Random r = new Random();

        StringBuilder sb = new StringBuilder(length);
        sb.append("iilii");
        for( int i = 0; i < length; i++ )
            sb.append( abc.charAt( r.nextInt(abc.length()) ) );
        return sb.toString();

    }

    public static String MinimumVocabObfuscation(String w){
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
        int key = keyNum%32;  // the key used in XOR encryption

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
        String s = "iloveuo";
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



}
