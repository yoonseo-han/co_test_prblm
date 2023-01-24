package Leetcode_100;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

class Solution {

    public static List<List<Integer>> threeSum(int [] nums) {
        HashSet<List<Integer>> returnList = new HashSet<List<Integer>>();

        //First sort the input Array in ascending order
        Arrays.sort(nums);
        //Iterate based on selected element
        for(int select = 0 ; select<nums.length - 2; select ++) {
            int i = select + 1;
            int j = nums.length - 1;
            int target = (-1)*nums[select];
            while(i<j) {
                if(nums[i] + nums[j] == target) {
                    //ADd to Hashmap
                    returnList.add(Arrays.asList(nums[i], nums[j], nums[select]));

                    while(i<j && nums[i] == nums[i+1]) i++;
                    while(i<j && nums[j] == nums[j-1]) j--;

                    i++;
                    j--;

                }
                else if (nums[i] + nums[j]<target) i++;
                else j--;
            }
        }
        //Type cast hashset into array list
        return new ArrayList<>(returnList);
    }
    public static void main(String strs[]){
        int [] inputArray = {-1,0,1,2,-1,-4};  
        System.out.println(threeSum(inputArray));
    }
}