package Leetcode_100;

import java.util.LinkedList;
import java.util.Queue;

// Definition for a binary tree node.

// class TreeNode {
//     int val;
//     TreeNode left;
//     TreeNode right;
//     TreeNode() {}
//     TreeNode(int val) { this.val = val; }
//     TreeNode(int val, TreeNode left, TreeNode right) {
//         this.val = val;
//         this.left = left;
//         this.right = right;
//     }
// }

class Solution {
    static class TreeNode {
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

    public static void BFSPrint(TreeNode root) {
        //Edge cases
        if (root == null) {
            System.out.println("Notihgn");
            return;
        }

        //Temp queue
        Queue<TreeNode> tempQueue = new LinkedList<>();
        tempQueue.add(root);

        while(!tempQueue.isEmpty()) {
            TreeNode curNode = tempQueue.poll();
            System.out.print(curNode.val);
            if(curNode.left!=null) tempQueue.add(curNode.left);
            if(curNode.right!=null) tempQueue.add(curNode.right);
        }
    }


    public static TreeNode invertTree(TreeNode root) {
        //Edge cases
        if (root == null) {
            return null;
        }

        //Define queue and initialize
        Queue<TreeNode> tempQueue = new LinkedList<>();
        tempQueue.add(root);

        //Iterate and change order
        while(!tempQueue.isEmpty()) {
            //Get current node
            TreeNode curNode = tempQueue.poll();

            //Reverse order
            TreeNode left = curNode.left;
            curNode.left = curNode.right;
            curNode.right = left;

            //ADd childs to queue
            if(curNode.left !=null) tempQueue.add(curNode.left);
            if(curNode.right !=null) tempQueue.add(curNode.right);
        }

        return root;
    }

    public static void main(String strs[]) {
        //root = [4,2,7,1,3,6,9]
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        invertTree(root);

        //BFS Print
        BFSPrint(root);
    }
}