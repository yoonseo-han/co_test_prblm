package Leetcode_100;

class Solution {
    public static boolean isPalindrome(String s) {
        //Define storage
        char [] tempString = new char[s.length()];

        int charCount = 0;
        //Add alphaneumericals characters only
        for(int i=0; i<s.length(); i++) {
            //Check if char is alphaneumeric
            if((s.charAt(i) >='a' && s.charAt(i)<='z') || (s.charAt(i) >='A' && s.charAt(i)<='Z') || (s.charAt(i) >='0' && s.charAt(i)<='9')) {
                //Convert uppercase letter to lower case letter
                char storeChar = (char) ((s.charAt(i) >='A' && s.charAt(i)<='Z') ? (s.charAt(i)+('a'-'A')) : (s.charAt(i)));
                tempString[charCount] = storeChar;
                charCount++;
            }
        }

        //Compare start and end pair
        int startIndx = 0;
        int endIndx = charCount-1;
        while(startIndx<=endIndx) {
            if(tempString[startIndx]!=tempString[endIndx]) return false;
            startIndx++;
            endIndx--;
        }

        return true;
    }

    public static void main(String strs[]) {
        String inputString ="0P";
        System.out.println(isPalindrome(inputString));
    }
}