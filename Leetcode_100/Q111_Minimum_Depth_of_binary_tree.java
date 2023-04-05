/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int min = Integer.MAX_VALUE;
    public void dfs(TreeNode curNode, int depth) {
        if(curNode.left == null && curNode.right==null) {
            min = Math.min(min, depth);
            return;
        }
        else {
            if(curNode.left!=null) dfs(curNode.left, depth+1);
            if(curNode.right!=null) dfs(curNode.right, depth+1);
        }
    }

    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        dfs(root, 0);
        return min+1;
    }
}