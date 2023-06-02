package Leetcode_100;

class Solution {
    public static boolean checkRecord(String s) {
        int consecutiveLate = 0;
        int totalAbsent = 0;

        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) != 'L') consecutiveLate = 0;
            if(s.charAt(i) == 'A') totalAbsent++;
            if(s.charAt(i) == 'L') consecutiveLate++;

            if(totalAbsent>=2) return false;
            else if(consecutiveLate>=3) return false;
        }

        return true;
    }
    public static void main(String strs[]) {
        String s = "PPALLP";
        System.out.println(checkRecord(s));
    }
}