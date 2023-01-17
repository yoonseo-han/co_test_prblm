package Leetcode_100;

import java.util.HashMap;
import java.lang.Math;

class Solution {
    public static boolean isHappy(int n) {
        HashMap <Integer, Integer> tempStore = new HashMap<Integer, Integer>();
        int inputNum = n;
        while(true) {
            int sum = 0;
            while(inputNum != 0) {
                sum += Math.pow((inputNum%10), 2);
                inputNum /= 10;
            }

            inputNum = sum;

            if(sum==1) return true;
            else if(tempStore.containsKey(sum)) return false;
            else {
                //ADd following new sum as key
                tempStore.put(sum, 1);
            }
        }
    }

    public static void main(String strs[]) {
        int inputNumber = 19;
        System.out.println(isHappy(inputNumber));
    }
}