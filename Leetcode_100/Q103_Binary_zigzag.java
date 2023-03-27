package Leetcode_100;

import java.util.*;

class Solution {
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer = new ArrayList<>();
        TreeNode tempNode = root;

        //Base case 
        if(tempNode == null) return answer;

        Stack<TreeNode> temp1 = new Stack<>();
        Stack<TreeNode> temp2 = new Stack<>();

        temp1.add(root);

        while(!temp1.isEmpty() || !temp2.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            while(!temp1.isEmpty()) {
                tempNode = temp1.pop();
                tempList.add(tempNode.val);

                if(tempNode.left != null) temp2.add(tempNode.left);
                if(tempNode.right != null) temp2.add(tempNode.right);
            }

            if(!tempList.isEmpty()) answer.add(tempList);

            tempList = new ArrayList<>();

            while(!temp2.isEmpty()) {
                tempNode = temp2.pop();
                tempList.add(tempNode.val);

                if(tempNode.right != null) temp1.add(tempNode.right);
                if(tempNode.left != null) temp1.add(tempNode.left);
            }

            if(!tempList.isEmpty()) answer.add(tempList);
        }

        return answer;
    }
    public static void main(String strs[]) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = zigzagLevelOrder(root);
        for(List<Integer> iter : result) System.out.println(iter);
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