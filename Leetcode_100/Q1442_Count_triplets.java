package Leetcode_100;

class Solution {
    public static int countTriplets(int[] arr) {
        //a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
        //b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]

        // a == b -> a^a == b^a --> 0 == b^a : arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1] ^ arr[j] ^ arr[j + 1] ^ ... ^ arr[k] == 0

        //If define prefix[j+1] = arr[0] ^ arr[1] ^ ... ^ arr[j]
        //Note that arr[i] ^ arr[i+1] ^ ... ^ arr[j] = prefix[j+1] ^ prefix[i]

        //Objective: Find pair (i,k) in which prefix[k+1] == prefix[i] (Shows that value of j does not matter if it is within range of i,k)
        int res = 0;
        int n = arr.length+1;
        int [] prefix = new int[n];

        for(int i=1; i<n; i++) prefix[i] = arr[i-1] ^ prefix[i-1];

        for(int i=0; i<n-1; i++) {
            for(int j=i+1; j<n; j++) {
                if(prefix[i] == prefix[j]) res += j - i - 1;
            }
        }

        return res;
    }
    public static void main(String strs[]) {
        int [] arr = {2,3,1,6,7};
        System.out.println(countTriplets(arr));
    }
}