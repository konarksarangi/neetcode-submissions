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
    public int diameterOfBinaryTree(TreeNode root) {
         int [] maxHeight = new int[1];
         dfs (root,maxHeight);
         return maxHeight[0];
        
    }
    private int dfs(TreeNode root, int [] maxHeight){
        if (root == null){
            return 0;
        }
        int leftHeight = dfs(root.left,maxHeight);
        int rightHeight = dfs(root.right,maxHeight);
        maxHeight[0] = Math.max(maxHeight[0],leftHeight+rightHeight);
        return 1+Math.max(leftHeight,rightHeight);
    }
}
