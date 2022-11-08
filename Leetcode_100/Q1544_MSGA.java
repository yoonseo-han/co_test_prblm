package Leetcode_100;

import java.io.*;
import java.util.*;

class Solution {
    public static String makeGood(String s) {
        char[] ch = s.toCharArray();
        int count = 0;
        while(true) {
            count = 0;
            for(int i=0; i<s.length()-1; i++) {
                //If inappropriate then remove both i and i+1
                if(ch[i]-ch[i+1]==32) {

                }
            }
            if(count == 0) {
                break;
            }
        }

        String newS = s.substring(0, 1) + s.substring(4);
        return newS;
    }
    public static void main(String[] args){
        String output = makeGood("leEeetcode");
        System.out.println(output);
    }
}