package Leetcode_100;

class Solution {

    //Helper function to find height
    public static int height(TreeNode curNode) {
        if(curNode == null) return -1;

        int maxLeft = height(curNode.left);
        int maxRight = height(curNode.right);

        return Math.max(maxLeft, maxRight)+1;
    }

    public static int diameterOfBinaryTree(TreeNode root) {
        // Longest path: 3 cases associated with it -> Compare all 3 cases and return the max for each step
        // Max diameter lies entirely in left or right tree only (2 cases)
        // Max diameter lies passes through the root node
        if(root == null) return 0;

        int lhs=diameterOfBinaryTree(root.left);
        int rhs=diameterOfBinaryTree(root.right);
        
        return Math.max(height(root.left)+height(root.right)+2, Math.max(lhs, rhs));
    }

    public static void main(String strs[]) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root));
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