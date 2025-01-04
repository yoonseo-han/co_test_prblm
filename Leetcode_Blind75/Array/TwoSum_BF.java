class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int tempTarget = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == tempTarget) {
                    answer[0] = i;
                    answer[1] = j;
                    return answer;
                }
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