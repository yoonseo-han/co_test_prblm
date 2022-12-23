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

        //Recrod sum
        int sum=0;

        //Convert input string to character
        char[] ch = s.toCharArray();
        for(int i=0; i<s.length(); i++){
            //Check if character exists in dictionary
            if(Dictionary.containsKey(ch[i])) {
                //Retrieve the following value of the corresponding key
                int temp = Dictionary.get(ch[i]);
                //compare to its next value 
                if(i<s.length()-1) {
                    //Retrieve the next value and compare if situation such as IV need to be covered
                    int nextVal = Dictionary.get(ch[i+1]);
                    if(temp*5==nextVal || temp*10==nextVal){
                        temp = nextVal-temp;
                        i++;
                    }
                }
                sum += temp;
            }
        }
        return sum;
    }
    public static void main(String[] args){
        int output = romanToInt("MCMXCIV");
        System.out.println(output);
    }
}

