package Leetcode_100;

class Solution {
    static char[] hex = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    
    public static String toHex(int num) {
        StringBuilder result = new StringBuilder();
        boolean flag = num>0? true: false;
        num = num>0? num: (-1)*num;
        int originalNum = num;
        //Edge cases
        if(num==0) return "0";

        while(num>0) {
            result.append(hex[num%16]);
            num/=16;
        }
        result.reverse();
        if(flag) return result.toString();
        
        //Deal with negative    
        int mask = 0xffff_ffff;
        return Integer.toHexString((originalNum^mask) +1);
    }

    public static void main(String strs[]) {
        int num = -2;
        System.out.println(toHex(num));
    }
}