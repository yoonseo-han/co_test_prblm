package Leetcode_100;

class Solution {

    public static boolean isPowerOfThree(int n){
        //Edge cases
        if(n==1) return true;
        if(n<0) return false;
        while(n>1) {
            if(n/3==1 && n%3==0) return true;
            else if(n%3 !=0 ) return false;
            n/=3;
        }
        return false;
    }
    public static void main(String strs[]) {
        int inputNum = 27;
        System.out.println(isPowerOfThree(inputNum));
    }
}