package Leetcode_100;

class Solution {
    public static int[] shortestToChar(String s, char c) {
        int [] res = new int[s.length()];
        //Observation: Always consider 2 locations of char c appearance and compare from there
        //Using 2 pass: One from left to right and other from right to left
        
        //Initialize pos so that when one pass: Able to calculate distance from direct left position of c appearance
        int pos = -s.length();
        
        for(int i=0; i<s.length(); i++) {
            if (s.charAt(i) == c) pos = i;
            res[i] = i - pos;
        }
        //pos = s.length();
        for(int i=pos; i>=0; i--) {
            if (s.charAt(i) == c) pos = i;
            res[i] = Math.min(res[i], pos-i);
        }

        return res;
    }
    public static void main(String strs[]) {
        String s = "loveleetcode";
        char c = 'e';
        for(int i: shortestToChar(s, c)) System.out.println(i);
    }
}