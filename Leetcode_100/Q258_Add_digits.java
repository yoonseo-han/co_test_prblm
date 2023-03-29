package Leetcode_100;

class Solution {
    public static int addDigits(int num) {
        char[] chars = ("" + num).toCharArray();
        int sum = 0;

        do {
            sum = 0;
            for(int i=0; i<chars.length; i++) {
                sum += (chars[i] - '0');
            }
            System.out.println(chars);
            chars = ("" + sum).toCharArray();
        } while(sum >= 10);
        
        return sum;
    }

    public static void main(String strs[]) {
        int num = 28;
        System.out.println(addDigits(num));
    }
}