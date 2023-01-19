package Leetcode_100;

import java.util.ArrayList;
import java.util.List;
import java.lang.String;

class Solution {

    public static List<String> fizzBuzz(int n) {
        List<String> returnList = new ArrayList<String>();

        for(int i=1; i<=n; i++) {
            if(i%15 == 0) returnList.add("FizzBuzz");
            else if(i%3 == 0) returnList.add("Fizz");
            else if(i%5 == 0) returnList.add("Buzz");
            else returnList.add(String.valueOf(i));
        }

        return returnList;
    }

    public static void main(String strs[]) {
        int inputNum = 5;
        List<String> resultList = fizzBuzz(inputNum);
        for(String iterator: resultList) {
            System.out.print(iterator + " ");
        }
    }
}