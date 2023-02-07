package Leetcode_100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution{
    public static void printString(List<List<String>> inputString) {
        for(int i=0; i<inputString.size(); i++) {
            System.out.print(inputString.get(i));
        }
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> resultList = new ArrayList<List<String>>();
        
        String [] tempStorage = new String[strs.length];
        //Order each string reamining same order
        for(int i=0; i<tempStorage.length; i++) {
            char[] tempChar = strs[i].toCharArray();
            Arrays.sort(tempChar);
            tempStorage[i] = String.valueOf(tempChar);
        }

        //USe 2d array to sort
        for(int i=0; i<tempStorage.length-1; i++) {
            if(tempStorage[i] != null) {
                //ADd current compairng string to resultList
                List<String> temp = new ArrayList<>();
                temp.add(strs[i]);
                for(int j=i+1; j<tempStorage.length; j++) {
                    if(tempStorage[j] !=null && tempStorage[i].equals(tempStorage[j])) {
                        temp.add(strs[j]);
                        tempStorage[j] = null;
                    }
                }   
                resultList.add(temp);
            }
        }

        //Add last index or not
        if(tempStorage[tempStorage.length-1] !=null) {
            List<String> temp = new ArrayList<>();
            temp.add(strs[tempStorage.length-1]);
            resultList.add(temp);
        }

        printString(resultList);
        return resultList;
    }

    public static void main(String strs[]) {
        String [] inputString = {"eat","tea","tan","ate","nat","bat"};
        groupAnagrams(inputString);
    }
}