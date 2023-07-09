package Leetcode_100;

//Find min number in array : Array increases and decreased to min at some point

//Able to use binary search to find min: Check middle element and 
// (1) If smaller than left element -> return min
// (2) Else -> If Right element and Left element is smaller than middle: Iterate right side
//          -> Else : Iterate left side

class Solution {
    public static int findMin(int[] num) {
        //Base case
        if (num == null || num.length == 0) return 0;
        if (num.length == 1) return num[0];

        //Recursive case
        int left = 0;
        int right = num.length-1;

        while(left<right) {
            int mid = (left+right)/2;
            //Case for directly finding smallest element
            if (mid > 0 && num[mid] < num[mid - 1]) return num[mid];

            else {
                //Case for iterating on right half
                if(num[left]<num[mid] && num[right]<num[mid]) left = mid+1;
                else right = mid-1;
            }
        }

        return num[left];
    }
    public static void main(String strs[]) {
        int [] nums = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }
}