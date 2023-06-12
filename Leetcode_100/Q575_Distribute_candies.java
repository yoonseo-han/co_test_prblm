import java.util.*;

class Solution {
    public static int distributeCandies(int[] candyType) {
        Set<Integer> storeType = new HashSet<>();
        int count = 0;

        for(int i:candyType) {
            if(!storeType.contains(i)) {
                storeType.add(i);
                count++;
            }
        }

        return candyType.length/2 > count? count: candyType.length/2;
    }
    public static void main(String strs[]) {
        int [] candyType = {1,1,2,2,3,3};
        System.out.println(distributeCandies(candyType));
    }

}