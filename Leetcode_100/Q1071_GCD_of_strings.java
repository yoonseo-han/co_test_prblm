package Leetcode_100;

class Solution {
    public static String gcd(String str1, String str2) {
        if(str2.length() > str1. length()) return gcd(str2, str1);

        else if(!str1.startsWith(str1)) return "";

        else if(str2.isEmpty()) return str1;

        else return gcd(str1.substring(str2.length()), str2);
    }

    public static String gcdOfStrings(String str1, String str2){
        String returnString = new String();

        if(!(str1 + str2).equals(str2+str1)) return "";

        else returnString = gcd(str1, str2);

        return returnString;
    }

    public static void main(String strs[]) {
        String str1 = "ABCABC";
        String str2 = "ABC";

        System.out.println(gcdOfStrings(str1, str2));
    }
}