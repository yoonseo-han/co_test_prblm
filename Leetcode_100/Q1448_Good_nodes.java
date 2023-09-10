package Leetcode_100;

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
    static int count = 0;

    public static void dfs(TreeNode curNode,int val) {
        if (curNode==null) return;
        
        if (curNode.val >= val) count++;

        dfs(curNode.left, Math.max(val, curNode.left.val));
        dfs(curNode.right, Math.max(val, curNode.right.val));
    }

    public static int goodNodes(TreeNode root) {
        //Recursive approach to record max value 

        // test input
        if (root==null) return count;
        // start dfs
        dfs(root, root.val);
        return count;
    }

    public static void main(String strs[]) {
        TreeNode root = new TreeNode();
        root.val = 3;
        root.left = new TreeNode(1);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.print(goodNodes(root));
    }
}