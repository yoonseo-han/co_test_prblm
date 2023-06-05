package Leetcode_100;

import java.util.Arrays;

class Solution {
    public static int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        int product = 1;
        //3 cases: All are positive numbers vs 2 of them are negative and one is positive vs all are negative numbers
        //Compare each cases
        
        //If all are negative numbers
        if(nums[nums.length-1] <0 ) {
            for(int i=3; i>0; i--) product *= nums[nums.length-i];
            return product;
        }

        //All are positive numbers
        for(int i=3; i>1; i--) product *= nums[nums.length-i];

        //2 of them are negative
        int tempProduct = 1;
        for(int i=0; i<2; i++) tempProduct*= nums[i];

        product = Math.max(product, tempProduct);

        return product*nums[nums.length-1];
    }

    public static int maximumProduct(int[] nums) {
        //Always maintain 3 largest numbers

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }

            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1*max2*max3, max1*min1*min2);
    }
    public static void main(String strs[]) {
        int [] nums = { 1,2,3,4};
        System.out.println(maximumProduct(nums));
    }
}