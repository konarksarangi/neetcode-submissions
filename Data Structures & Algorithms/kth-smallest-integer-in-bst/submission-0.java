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
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> result = new ArrayList<>();
        InOrderTraversal(root,result);
        return result.get(k-1);
    }

    public void InOrderTraversal(TreeNode node,List<Integer> result){
        if(node != null){
            InOrderTraversal(node.left,result);
            result.add(node.val);
            InOrderTraversal(node.right,result);
        }
    }
    
}
