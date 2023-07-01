package Leetcode_100;

class Solution {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count = 0;
        for(int i=0; i<flowerbed.length && count < n; i++) {
            if(flowerbed[i] == 0) {
                //get next and prev flower bed slot values. If i lies at the ends the next and prev are considered as 0. 
                    int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1]; 
                    int prev = (i == 0) ? 0 : flowerbed[i - 1];
                    //Condition to place flower
                    if(next == 0 && prev == 0) {
                        flowerbed[i] = 1;
                        count++;
                    }
                }
        }
        return count == n;
    }
    public static void main(String strs[]) {
        int [] flowerbed = {1,0,0,0,1};
        int n = 2;
        System.out.println(canPlaceFlowers(flowerbed,n));
    }
}