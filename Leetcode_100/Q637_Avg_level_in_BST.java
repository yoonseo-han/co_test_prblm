package Leetcode_100;

import java.util.*;

class Solution {
    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        //BFS: Iterate each level and add it to Queue
        q.add(root);

        if(root == null) return result;
        while(!q.isEmpty()) {
            int n = q.size();
            double sum = 0.0;

            for(int i=0; i<n; i++) {
                TreeNode curNode = q.poll();
                sum += curNode.val;

                if(curNode.left != null) q.add(curNode.left);
                if(curNode.right != null) q.add(curNode.right);
            }
            result.add(sum / n);
        }

        return result;
    }
    public static void main(String strs[]) {
        TreeNode root = new TreeNode(3);;
        root.right = new TreeNode(20);
        root.left = new TreeNode(9);
        root.right.right = new TreeNode(7);
        root.right.left = new TreeNode(15);

        System.out.println(averageOfLevels(root));
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