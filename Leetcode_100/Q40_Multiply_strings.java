package Leetcode_100;

class Solution {
    public static String multiply(String num1, String num2) {
        StringBuilder result = new StringBuilder();

        long firstNum = 0;
        long secondNum = 0;

        for(int i=0; i<num1.length(); i++) firstNum = (firstNum*10) + (num1.charAt(i) - '0');
        for(int i=0; i<num2.length(); i++) secondNum = (secondNum*10) + (num2.charAt(i) - '0');

        long resultNum = firstNum*secondNum;

        while(resultNum > 0) {
            result.append((char)('0' + (resultNum%10)));
            resultNum /= 10;
        }
        return result.length() == 0 ? "0" : result.reverse().toString();
    }
    public static void main(String strs[]) {
        String num1 = "498828660196";
        String num2 = "840477629533";
        System.out.println(multiply(num1, num2));
    }
}