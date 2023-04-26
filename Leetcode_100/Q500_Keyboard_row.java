package Leetcode_100;

import java.util.*;

class Solution {
    public static Set<Character> stringToCharSet(String str){
        Set<Character> set = new HashSet();
        for(char c: str.toCharArray()) set.add(c);  
        return set;
    }

    public static boolean isValid(Set<Character> row, String word) {
        for(char c: word.toCharArray()) {
            if(!row.contains(Character.toLowerCase(c))) return false;
        }
        return true;
    }

    public static String[] findWords(String[] words) {
        //Add following characters to set
        Set<Character> row1 = stringToCharSet("qwertyuiop"); 
        Set<Character> row2 = stringToCharSet("asdfghjkl");
        Set<Character> row3 = stringToCharSet("zxcvbnm");
        
        List<String> res = new ArrayList();

        //Check for each string if valid or not
        for(String word: words){
            //Compare string to each char set
            if(isValid(row1, word) || isValid(row2, word) || isValid(row3, word)){
            res.add(word);    
            }
        }
        
        return res.toArray(new String[0]);
    }
    public static void main(String strs[]) {
        String [] words = {"Hello","Alaska","Dad","Peace"};
        String [] result = findWords(words);
        for(String i : result) System.out.print(i + ",");
    }
}