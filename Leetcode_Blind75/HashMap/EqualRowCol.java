import java.util.*;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<List<Integer>, Integer> tempStore = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<Integer> tempRow = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                tempRow.add(grid[i][j]);
            }
            tempStore.put(tempRow, tempStore.getOrDefault(tempRow, 0) + 1);
        }

        int count = 0;
        for (int j = 0; j < n; j++) {
            List<Integer> tempRow = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                tempRow.add(grid[i][j]);
            }
            count += tempStore.getOrDefault(tempRow, 0);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] grid = { { 3, 1, 2, 2 }, { 1, 4, 4, 5 }, { 2, 4, 2, 2 }, { 2, 4, 2, 2 } };
        System.out.println(equalPairs(grid));
    }
}