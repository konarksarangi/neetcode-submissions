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
    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{root.val};
        dfs(root,result);
        return result[0];
    }
    public int dfs(TreeNode node,int[] result){
        if(node == null){
            return 0;
        }
        int leftMax=Math.max(dfs(node.left,result),0);
        int rightMax=Math.max(dfs(node.right,result),0);

        result[0] = Math.max(result[0],node.val+leftMax+rightMax);

        return node.val+Math.max(leftMax,rightMax);
    }
    
}
