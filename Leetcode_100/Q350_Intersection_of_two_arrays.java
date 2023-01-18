package Leetcode_100;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int[] interSect(int [] nums1, int [] nums2) {
        //Edge cases
        if(nums1 == null || nums2 == null) return null;

        //Define first (smaller array)
        int [] tempArray = (nums1.length > nums2.length) ? nums2 : nums1;

        //Define 2 hashmaps
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();

        //Input all elements in smaller array into hashmap
        for(int i=0; i<tempArray.length; i++) {
            if(!hashMap1.containsKey(tempArray[i])) hashMap1.put(tempArray[i], 1);
            else hashMap1.put(tempArray[i], hashMap1.get(tempArray[i])+1);
        }

        //ADd all elements in larger array into second hashmap only if value is inside first hashamp
        //First change temparray to other one
        tempArray = (nums1.length > nums2.length) ? nums1 : nums2;
        //Counter for number of elements
        int counter = 0;
        for(int i=0; i<tempArray.length; i++) {
            //IF element is contained in 1st hashmap and not yet in 2nd hashmap, set value to 1
            if(hashMap1.containsKey(tempArray[i]) && !hashMap2.containsKey(tempArray[i])) {
                hashMap2.put(tempArray[i], 1);
                counter++;
            }
            //If element is contained in both hashmap, update value stored in 2nd hashmap adn has count smalleer than 1st hashmap
            else if(hashMap1.containsKey(tempArray[i]) && hashMap2.containsKey(tempArray[i]) && (hashMap1.get(tempArray[i]) > hashMap2.get(tempArray[i]))) {
                hashMap2.put(tempArray[i], hashMap2.get(tempArray[i])+1);
                counter++;
            }
        }

        //Now transform hashmamp 2 into int array and return
        int [] resultArray = new int[counter];
        int indexIterator = 0;
        for(Map.Entry<Integer, Integer> iterator : hashMap2.entrySet()) {
            int key = iterator.getKey();
            int value = iterator.getValue();
            for(int i=0; i<value; i++) {
                resultArray[indexIterator++] = key;
            }
        }

        return resultArray;
    }

    public static void main(String strs[]) {
        int [] inputArray1 = {4,9,5};
        int [] inputArray2 = {9,4,9,8,4};

        int [] resultArray = interSect(inputArray1, inputArray2);
        for(int i : resultArray) {
            System.out.print(i);
        }
    }
}