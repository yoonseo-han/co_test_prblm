import java.util.*;

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        HashMap<Integer, Integer> store = new HashMap<Integer, Integer>();

        for (int i = 0; i < nums.length; i++) {
            store.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int tempTarget = target - nums[i];
            if (store.containsKey(tempTarget)) {
                answer[0] = i;
                answer[1] = store.get(tempTarget);
                if (answer[0] == answer[1])
                    continue;
                return answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;

        int[] result = twoSum(nums, target);
        for (int i : result) {
            System.out.println(i);
        }
    }
}