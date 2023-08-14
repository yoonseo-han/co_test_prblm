package Leetcode_100;

import java.util.*;

class Solution {
    public static boolean selfDividing(int i) {
        int record = i;
        while(record > 0) {
            if(record%10==0) return false;
            else if(i%(record%10)!=0) return false;
            record/=10;
        }
        return true;
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for(int i=left; i<=right; i++) {
            if(selfDividing(i)) result.add(i) ;
        }
        return result;
    }
    public static void main(String strs[]) {
        int left = 1;
        int right = 22;
        List<Integer> result = selfDividingNumbers(left, right);
        for(int i: result) System.out.print(i + ",");
    }
}