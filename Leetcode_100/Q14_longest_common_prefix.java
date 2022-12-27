package Leetcode_100;

class Solution {

    public static String longestCommonPrefix(String[] strs) {
        //First array for comparison: Convert string to char array for index access
        char [] compare = strs[0].toCharArray();
        int length = compare.length;
        if(strs.length>1) {
            for(int i=1; i<strs.length; i++) {
                //Before comparison, first check if "length" is shorter than legnth of comparing string
                length = (length<strs[i].length()) ? length : strs[i].length();
                for(int j=0; j<length; j++) {
                    char [] temp = strs[i].toCharArray();
                    if(compare[j] != temp[j]) {
                        //Update length of subarray
                        length = (j)>=0 ? (j) : 0;
                        break;
                    }
                }
            }
        }

        //Based on the retrieved length get the longest common prefix
        char [] LCP = new char[length];
        for(int i=0; i<length; i++) {
            LCP[i] = compare[i];
        }
        String LCP_String = new String(LCP);
        return LCP_String;
    }

    public static void main(String [] strs) {
        String[] inputArray = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(inputArray));
    }
}