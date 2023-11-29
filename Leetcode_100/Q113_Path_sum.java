package Leetcode_100;

import java.util.*;

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

class Solution {
    public static List<List<Integer>> tempList = new ArrayList<List<Integer>>();

    public static void pathSumRoute(TreeNode curNode, int targetSum, Stack<Integer> path) {
        path.push(curNode.val);

        if(curNode.left == null && curNode.right == null) {
            if(targetSum == curNode.val) tempList.add(new ArrayList<>(path));
        }
        if(curNode.left != null) pathSumRoute(curNode.left, targetSum - curNode.val, path);
        if(curNode.right != null) pathSumRoute(curNode.right, targetSum - curNode.val, path);

        path.pop();
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if(root==null) return tempList;
        Stack<Integer> path = new Stack<Integer>();
        pathSumRoute(root, targetSum, path);
        return tempList;
    }
    public static void main(String strs[]) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;

        System.out.println(pathSum(root, targetSum));
    }
}