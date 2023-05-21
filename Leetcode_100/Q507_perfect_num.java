package Leetcode_100;

class Solution {
    public static boolean checkPerfectNumber(int num) {
        int res = 0;
        for(int i=1; i<num; i++) {
            if(num%i==0) res+=i;
        }
        return (res==num)? true: false;
    }

    public static void main(String strs[]) {
        int num = 28;
        System.out.println(checkPerfectNumber(num));
    }
}