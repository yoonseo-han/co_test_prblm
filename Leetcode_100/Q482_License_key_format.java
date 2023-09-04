package Leetcode_100;

class Solution {
    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();

        int count = 0;
        
        //Reverse order
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) == '-') continue;

            // put a '-' first if we already append K characters
            if (count == k) {
                sb.append('-');
                count = 0;
            }

            sb.append(Character.toUpperCase(s.charAt(i)));
            ++count;
        }

        return sb.reverse().toString();
    }
    public static void main(String strs[]) {
        String s = "5F3Z-2e-9-w";
        int k = 4;
        System.out.println(licenseKeyFormatting(s, k));
    }
}