package Leetcode_100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    //Recursive function
    public static void generateCombinations(String digits, int index, StringBuilder currentString, HashMap<Character, String>  storeMap, List<String> returnList) {
        //Termination condition
        if(digits.length() == index) {
            //ADd current string to List
            returnList.add(currentString.toString());
            return;
        }

        //Else retrieve all characters for corresponding index's digit and append to current string
        else {
            //Retrive index's digit
            char digit = digits.charAt(index);
            String possibleChar = storeMap.get(digit);
            //Iterate over all the characters and append them in current string
            for(char newChar: possibleChar.toCharArray()) {
                generateCombinations(digits, index+1, currentString.append(newChar), storeMap, returnList);
                //Must delete the char appended 
                currentString.deleteCharAt(index);
            }
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> returnList= new ArrayList<String>();

        HashMap <Character, String> storeMap = new HashMap<>();
        storeMap.put('2', "abc");
        storeMap.put('3', "def");
        storeMap.put('4', "ghi");
        storeMap.put('5', "jkl");
        storeMap.put('6', "mno");
        storeMap.put('7', "pqrs");
        storeMap.put('8', "tuv");
        storeMap.put('9', "wxyz");

        if(digits.length() != 0 ) generateCombinations(digits, 0, new StringBuilder(), storeMap, returnList);

        return returnList;
    }
    public static void main(String strs[]){
        String inputString = "23";
        System.out.println(letterCombinations(inputString));
    }
}