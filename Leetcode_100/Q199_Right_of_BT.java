package Leetcode_100;

import java.util.*;

class Solution {
    public static void rightView(TreeNode curNode, List<Integer> res, int curDepth) {
        if(curNode == null) return;

        if(curDepth == res.size()) res.add(curNode.val);

        //Start iteration from right side
        rightView(curNode.right, res, curDepth+1);
        rightView(curNode.left, res, curDepth+1);
    }

    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> tempStore = new ArrayList<>();

        rightView(root, tempStore, 0);

        return tempStore;
    }
    public static void main(String strs[]) {
        TreeNode root = new TreeNode();
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.left.right = new TreeNode(5);

        List<Integer> res = rightSideView(root);
        System.out.print(res);
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