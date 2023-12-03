package Leetcode_100;

class Solution {
    public static int[] sortArrayByParityII(int[] A) {
        int[] res = new int[A.length];

        //Get first even entry at wrong index and odd entry at wrong index
        int even = 0;
        int odd = 1;

        while(true){
            while(even < A.length && A[even] % 2 == 0) /*(1)*/
                even += 2;
            while(odd < A.length && A[odd] % 2 != 0) /*(2)*/
                odd += 2;
            if(odd >= A.length || even >= A.length) return A;
			
			/*(3)*/
            int temp = A[even];
            A[even] = A[odd];
            A[odd] = temp;
        }
    }
    public static void main(String strs[]) {
        int [] nums = {4,2,5,7};
        System.out.println(sortArrayByParityII(nums));
    }
}