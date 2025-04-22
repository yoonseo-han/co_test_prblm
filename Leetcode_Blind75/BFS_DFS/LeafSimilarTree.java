package Leetcode_Blind75.BFS_DFS;

class Solution {
    public void preorder(TreeNode root, List<Integer> curList) {
        if (root == null)
            return;

        if (root.left == null && root.right == null) {
            curList.add(root.val);
        }
        preorder(root.left, curList);
        preorder(root.right, curList);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> firstStore = new ArrayList<>();
        List<Integer> secondStore = new ArrayList<>();

        preorder(root1, firstStore);
        preorder(root2, secondStore);

        return firstStore.equals(secondStore);
    }
}
