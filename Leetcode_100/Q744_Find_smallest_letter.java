package Leetcode_100;

class Solution {
    public static char nextGreatestLetter(char[] letters, char target) {
        int low = 0;
        int high = letters.length;

        while(low<high) {
            int mid = low + (high - low)/2;
            if(letters[mid] > target) high = mid;
            else low = mid+1;
        }
        return letters[low%letters.length];
    }
    public static void main(String strs[]) {
        char[] letters = {'c','f','j'};
        char target = 'a';
        System.out.println(nextGreatestLetter(letters, target));
    }
}