package Leetcode_100;

import java.util.*;

class Solution {
    static int maxDepth = 0;

    public static void dfs(TreeNode curNode, int isLeft, int curDepth){
        if(curNode == null) return;

        maxDepth = Math.max(maxDepth, curDepth);

        if(isLeft == 1) {
            dfs(curNode.right, 0, curDepth+1); //Goes to right and continue
            dfs(curNode.left,1,1); //Start again from left
        } 
        else {
            dfs(curNode.left, 1, curDepth+1); //Goes to right and continue
            dfs(curNode.right,0,1); //Start again from left
        }
    }

    public static int longestZigZag(TreeNode root) {
        dfs(root, 1, 0);
        dfs(root, 0, 0);

        return maxDepth;
    }
    public static void main(String strs[]) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(1);
        root.right.right.left.right = new TreeNode(1);
        root.right.right.left.right.right = new TreeNode(1);

        System.out.println(longestZigZag(root));
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