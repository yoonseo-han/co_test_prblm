package Leetcode_100;

class Solution {
    public static String count(String returnString) {
        StringBuilder tempString = new StringBuilder();
        int count = 1;
        char compareChar = returnString.charAt(0);

        for(int i=1; i<returnString.length(); i++) {
            //If equal to comparing character
            if(returnString.charAt(i) == compareChar) count++;
            //IF not equal to char, append the count and char
            else {
                //Append count and char
                tempString.append(count);
                tempString.append(compareChar);
                count = 1;
                compareChar = returnString.charAt(i);
            }
        }
        tempString.append(count);
        tempString.append(compareChar);

        returnString = tempString.toString();
        return returnString;
    }

    public static String countAndSay(int n) {
        String returnString = "1";

        for(int i=1; i<n; i++) {
            returnString = count(returnString);
        }

        return returnString;
    }

    public static void main(String strs[]) {
        int inputNumber = 4;
        System.out.println(countAndSay(inputNumber));
    }
}