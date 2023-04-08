package Leetcode_100;

class Solution {
    public static String intToRoman(int num) {
        String result = "";

        int [] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9,5,4,1};
        String[] roman = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        for(int i=0; i<values.length; i++) {
            while(num>=values[i]) {
                num-=values[i];
                result += roman[i];
            }
        }

        return result;
    }
    public static void main(String strs[]) {
        int inputNumber = 3994;
        System.out.println(intToRoman(inputNumber));
    }
}