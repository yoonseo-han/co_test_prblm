package Leetcode_100;

import java.util.*;

class Solution {
    public static String simplifyPath(String path) {
        Stack<String> store = new Stack<>();
        StringBuilder res = new StringBuilder();
        
        //Seperate input string based on "/"
        String[] curString = path.split("/");

        for(int i=0; i<curString.length; i++) {
            if(!store.isEmpty() && curString[i].equals("..")) store.pop();
            else if (!curString[i].equals("") && !curString[i].equals(".") && !curString[i].equals("..")) store.push(curString[i]);
        }

        if(store.isEmpty()) return "/";
        while(!store.isEmpty()) {
            res.insert(0,store.pop()).insert(0,"/");
        }

        return res.toString();
    }
    public static void main(String strs[]) {
        String path = "/home/asd/../";
        System.out.println(simplifyPath(path));
    }
}