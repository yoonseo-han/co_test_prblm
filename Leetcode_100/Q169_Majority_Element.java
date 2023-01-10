package Leetcode_100;

import java.lang.Math;

class Solution {

    public static void merge(int [] nums, int l, int q, int r) {
        int [] leftArray = new int [q-l+1];
        int [] rightArray = new int [r-q];

        for(int i=0; i<leftArray.length; i++) {
            leftArray[i] = nums[l+i];
        }
        for(int i=0; i<rightArray.length; i++) {
            rightArray[i] = nums[q+1+i];
        }

        int i=0; 
        int j=0;

        int k=l;
        //Merge into main array
        while(i<leftArray.length && j<rightArray.length) {
            if(leftArray[i] <= rightArray[j]) {
                nums[k] = leftArray[i];
                i++;
            }
            else {
                nums[k] = rightArray[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < leftArray.length) {
            nums[k] = leftArray[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < rightArray.length) {
            nums[k] = rightArray[j];
            j++;
            k++;
        }

        return;
    }

    public static void mergeSort(int [] nums, int l, int r){
        if(l == r) return;
        
        int q = Math.floorDiv((l+r), 2);

        //Recursive call
        mergeSort(nums, l, q);
        mergeSort(nums, q+1, r);
        merge(nums, l,q,r);
        return;
    }  

    public static int majorityElement(int[] nums) {

        //Sort input array based on merge sort
        mergeSort(nums, 0, nums.length-1);

        //Pivot qualification
        int minNum = Math.floorDiv(nums.length, 2);

        //Base case
        if(nums.length == 1) return nums[0];

        int currentCount = 1;
        for(int i=1; i<nums.length; i++) {
            if(nums[i] == nums[i-1]) currentCount++;
            else currentCount=1;
            if(currentCount > minNum) return nums[i];
        }

        return 0;
    }
    public static void main(String srts[]) {
        int [] inputArray = {3,2,3};
        System.out.println(majorityElement(inputArray));
    }
}