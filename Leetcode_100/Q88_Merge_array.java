package Leetcode_100;

//Solution from internet: Using 2 pointer approach

class Solution {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int p1 = m-1 , p2 = n-1 ,i = m+n-1;
        while(p2 >=0 ){
            if(p1 >=0 && nums1[p1] > nums2[p2]){
                nums1[i--] = nums1[p1--];
            } 
            else{
                nums1[i--] = nums2[p2--];
            }
        }
    }

    public static void main (String strs[]) {
        int nums1[] = {2,2,3,5,0,0,0};
        int m = 4;
        int nums2[] = {1,1,3};
        int n = 3;

        merge(nums1, m, nums2, n);

        for(int i=0; i<m+n; i++) {
            System.out.print(nums1[i]);
        }
    }
}