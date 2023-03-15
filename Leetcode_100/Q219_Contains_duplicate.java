package Leetcode_100;

//REDOOOOOO!!!!!!!

import java.util.*;

class Solution{
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        //Use queue: FIFO and hashtable to track elements
        Queue<Integer> store = new PriorityQueue<>();
        HashSet<Integer> exist = new HashSet<>();
        
        //Traverse linearly
        for(int i=0; i<nums.length; i++) {
            //If exist, return true
            if(exist.size() <= k && exist.contains(nums[i])) {
                //System.out.println(nums[i]+","+ i);
                return true;
            }
            //IF does not exist, add to queue
            else {
                if(exist.size() < k) {
                    store.add(nums[i]);
                    exist.add(nums[i]);
                }
                else {
                    //System.out.println("TEST");
                    System.out.println(store.peek() + "," + i);
                    exist.remove(store.peek());
                    store.remove();
                    store.add(nums[i]);
                    exist.add(nums[i]);
                }
            }
        }

        return false;
    }

    public static void main(String strs[]) {
        int [] inputArray = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(inputArray, k));
    }
}