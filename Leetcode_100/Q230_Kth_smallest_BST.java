package Leetcode_100;

class Solution {
    private static int val = 0;
    private static int count = 0;

    public static void inOrder(TreeNode curNode) {
        if(curNode.left != null) inOrder(curNode.left);
        count--;
        if(count == 0) {
            val = curNode.val;
            return;
        }
        else if(curNode.right != null) inOrder(curNode.right);
    }
    
    public static int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrder(root);

        return val;
    }

    public static void main(String strs[]) {
        int k = 1;
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.left = null;

        System.out.println(kthSmallest(root, k));
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}