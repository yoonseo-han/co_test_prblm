package Leetcode_100;

import java.util.*;

class Solution {
    public static List<List<Integer>> levelOrderBottom(TreeNode root) {
        //Reverse level order traversal
        List<List<Integer>> result = new ArrayList<>();

        Stack<List<Integer>> tempResult = new Stack<>();
        Queue<TreeNode> tempStore = new LinkedList<>();

        tempStore.add(root);
        while(!tempStore.isEmpty()) {
            int levelSize = tempStore.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0; i<levelSize; i++) {
                //Add the nodes in reverse order
                TreeNode curNode = tempStore.poll();
                level.add(curNode.val);
                if(curNode.left!=null) tempStore.add(curNode.left);
                if(curNode.right!=null) tempStore.add(curNode.right);
            }
            tempResult.add(level);
        }

        //Reverse the order of sub lists
        while(!tempResult.isEmpty()) {
            result.add(tempResult.pop());
        }

        return result;
    }
    public static void main(String strs[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(levelOrderBottom(root));
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