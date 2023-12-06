package Leetcode_100;

import java.util.*;

class Solution {
    public static int DFS(TreeNode curNode, int sum) {
        if(curNode == null) return 0;
        if(curNode.left == null && curNode.right == null) return sum*10 + curNode.val;
        return DFS(curNode.left, sum*10 + curNode.val) + DFS(curNode.right, sum*10 + curNode.val);
    }

    public static int sumNumbers(TreeNode root) {
        return DFS(root, 0);
    }
    public static void main(String strs[]) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(1);

        System.out.println(sumNumbers(root));
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