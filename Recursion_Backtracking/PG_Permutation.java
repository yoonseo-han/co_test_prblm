import java.util.*;

class Solution {
    public static List<List<Integer>> permute(int[] input) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[input.length];
        backtrack(input, new ArrayList<>(), visited, result);
        return result;
    }

    public static void backtrack(int[] nums, List<Integer> curList, boolean[] visited, List<List<Integer>> result) {
        if (curList.size() == nums.length) {
            result.add(new ArrayList<>(curList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;

            visited[i] = true;
            curList.add(nums[i]);
            backtrack(nums, curList, visited, result);
            curList.remove(curList.size() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        int[] input = { 1, 2, 3 };
        List<List<Integer>> permutation = new ArrayList<>();

        permutation = permute(input);
        for (List<Integer> curList : permutation) {
            System.out.println(curList);
        }
    }
}