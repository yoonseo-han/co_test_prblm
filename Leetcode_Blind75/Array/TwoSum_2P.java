class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];
        int[][] track = new int[nums.length][2];

        for (int i = 0; i < nums.length; i++) {
            track[i][0] = nums[i];
            track[i][1] = i;
        }

        Arrays.sort(track, (a, b) -> a[0] - b[0]);

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = track[left][0] + track[right][0];
            if (sum == target) {
                answer[0] = track[left][1];
                answer[1] = track[right][1];
                return answer;
            } else if (sum < target)
                left++;
            else
                right--;
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