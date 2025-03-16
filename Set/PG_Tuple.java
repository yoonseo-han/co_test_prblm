import java.util.*;

class Solution {
    public int[] solution(String s) {
        // Remove the outer braces
        String newSubstring = s.substring(1, s.length() - 1);

        // Split into individual sets using "},{" as the delimiter
        String[] groups = newSubstring.split("\\},\\{");

        // Prepare a list to store parsed sets of integers
        List<List<Integer>> store = new ArrayList<>();

        // Parse each group
        for (String group : groups) {
            // Clean up the braces and split into integers
            group = group.replace("{", "").replace("}", "");
            String[] elements = group.split(",");
            List<Integer> tempList = new ArrayList<>();
            for (String element : elements) {
                tempList.add(Integer.parseInt(element));
            }
            store.add(tempList);
        }

        // Sort the lists by their size (ascending) using a lambda expression
        store.sort((list1, list2) -> Integer.compare(list1.size(), list2.size()));

        // Create a set to maintain unique values and construct the result
        Set<Integer> seen = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (List<Integer> curList : store) {
            for (int num : curList) {
                if (!seen.contains(num)) {
                    result.add(num);
                    seen.add(num);
                }
            }
        }

        // Convert the result list to an array
        return result.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String input = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        int[] result = solution.solution(input);
        System.out.println(Arrays.toString(result)); // Expected output: [2, 1, 3, 4]
    }
}