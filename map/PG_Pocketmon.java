//https://school.programmers.co.kr/learn/courses/30/lessons/1845
import java.util.*;

class Solution {
    public static int solution(int[] nums) {
        int answer = 0;
        Set <Integer> storeSet = new HashSet<>();

        for(int i = 0; i<nums.length; i++) {
            storeSet.add(nums[i]);
        }

        if(storeSet.size() >= (nums.length / 2)) {
            answer = nums.length/2;
        }
        else {
            answer = storeSet.size();
        }

        return answer;
    }
    public static void main(String strs[]) {
        int [] nums = {3,3,3,2,2,4};
        System.out.println(solution(nums));
    }
}