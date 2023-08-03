package Leetcode_100;

class Solution {
    public static int compareVersion(String version1, String version2) {
        //Separate based on "."

        int index1 = 0;
        int index2 = 0;
        int n1 = version1.length();
        int n2 = version2.length();

        int num1 = 0;
        int num2 = 0;

        while(index1 < n1 || index2 < n2) {
            //Calculate number till first "." appears
            while(index1 < n1 && version1.charAt(index1) != '.') {
                num1 = (num1*10) + (version1.charAt(index1)-'0');
                index1++;
            }
            while(index2 < n2 && version2.charAt(index2) != '.') {
                num2 = (num2*10) + (version2.charAt(index2)-'0');
                index2++;
            }

            if(num1>num2) return 1;
            else if(num1 < num2) return -1;

            num1 = 0;
            num2 = 0;
            index1++;
            index2++;
        }

        return 0;
    }
    public static void main(String strs[]) {
        String version1 = "1.01";
        String version2 = "1.001";
        System.out.println(compareVersion(version1, version2));
    }
}