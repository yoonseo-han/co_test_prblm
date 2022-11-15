package Leetcode_100;

import java.util.HashMap;

class Solution {
    public static int romanToInt(String s) {
        //Define hashmap of the key values
        HashMap <Character, Integer> Dictionary = new HashMap<>();

        //Add Roman numerals and there corresponding values
        Dictionary.put('I', 1);
        Dictionary.put('V', 5);
        Dictionary.put('X', 10);
        Dictionary.put('L', 50);
        Dictionary.put('C', 100);
        Dictionary.put('D', 500);
        Dictionary.put('M', 1000);

        //Convert input string to character
        char[] ch = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            //Check if character exists in dictionary
            if(Dictionary.containsKey(ch[i])) {
                //Retrieve the following value of the corresponding key
                
            }
        }
        return 0;
    }
    public static void main(String[] args){
        int output = romanToInt("III");
        System.out.println(output);
    }
}

