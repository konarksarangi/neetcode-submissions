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
        if(root == null){
            return 0;
        }
        List<Integer> result = new ArrayList<>();
        inOrderTraversal(root,result);
        return result.get(k-1);

    }
    public void inOrderTraversal(TreeNode node,List<Integer> result){
        if(node != null){
            inOrderTraversal(node.left,result);
            result.add(node.val);
            inOrderTraversal(node.right,result);
        }
    }

   
}
