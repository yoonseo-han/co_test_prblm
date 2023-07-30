package Leetcode_100;

class Solution {
    //Global variable defined
    static Boolean mem[][];
    
    public static boolean subsetSum(int[] nums, int pos, int sum) {
        //pos: Current elements position, sum: desired sum of remaining element subset
        if(sum==0) return true;
        //When considered all elements but cant reach the desired sum value
        else if (pos>=nums.length || sum<0) return false;

        //IF there is one case where sum of subset can reach the desired value "sum", then return true
        if(mem[pos][sum]!=null) return mem[pos][sum];

        //2 cases: Take the element or discard it
        return mem[pos][sum] = subsetSum(nums, pos+1, sum) || subsetSum(nums, pos+1, sum - nums[pos]);
    }

    public static boolean canPartition(int[] nums) {
        //Partition to 2 subsets: Means that there is a pivot to separate array
        //Memoization method: Top down approach 

        int sum = 0;
        int n = nums.length;
        
        for(int i : nums) sum+=i;
        
        //Case where cant be partitioned into 2 subset
        if(sum%2!=0) return false;
        //Total Sum value of each of the 2 subsets
        sum /= 2;
        
        //For each element in nums: Determine whether to take it or not
        mem = new Boolean[n+1][sum+1];
        
        return subsetSum(nums,0,sum);
    }
    public static void main(String strs[]) {
        int [] nums = {2,2,1,1};
        System.out.println(canPartition(nums));
    }
}