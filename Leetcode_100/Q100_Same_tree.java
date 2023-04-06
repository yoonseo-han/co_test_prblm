package Leetcode_100;

class Solution {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;

        if(p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        return false;
    }

    public static void main(String strs[]) {
        TreeNode p = new TreeNode(1);
        p.right = new TreeNode(2);
        p.left = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.right = new TreeNode(3);
        q.left = new TreeNode(2);

        System.out.println(isSameTree(p,q));
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