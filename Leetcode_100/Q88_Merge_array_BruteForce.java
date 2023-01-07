package Leetcode_100;

class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //Iterator for both array
        int counter1=0;
        int counter2=0;

        //Record the remaining elements to deal with in nums1
        int remainingElement = m;

        for(int i=0; i<m+n; i++) {
            if(nums1[counter1] <= nums2[counter2]) {
                //No new insertion held to nums1 array
                counter1 = (remainingElement>0) ? counter1+1 : counter1;
                //Decrease the remaining elements to deal with
                remainingElement--;
            }
            else {
                //First move the remaining elements to right
                for(int j=remainingElement; j>=0 ; j--) {
                    nums1[counter1+j+1] = nums1[counter1+j];
                }
                //Insert nums2 element into nums1 array
                nums1[counter1] = nums2[counter2];
                //Move both iterator
                counter2++;
                counter1 = (remainingElement>0) ? counter1+1 : counter1;
            }
        }
    }

    public static void main(String strs[]) {
        int nums1[] = {1,2,3,0,0,0};
        int m = 3;
        int nums2[] = {2,5,6};
        int n = 3;

        merge(nums1, m, nums2, n);

        for(int i=0; i<m+n; i++) {
            System.out.print(nums1[i]);
        }
    }
}