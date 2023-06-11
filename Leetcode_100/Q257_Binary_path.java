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
import java.util.*;

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if(root!= null) recursiveBT(root, "", answer);
        return answer;
    }

    public void recursiveBT(TreeNode root, String curPath, List<String> answer) {
        if(root.left == null && root.right == null) answer.add(curPath + root.val);
        if(root.left != null) recursiveBT(root.left, curPath + root.val + "->", answer);
        if(root.right != null) recursiveBT(root.right, curPath + root.val + "->", answer);
    }
}