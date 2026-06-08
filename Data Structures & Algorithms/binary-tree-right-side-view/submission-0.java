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
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Queue <TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        while (bfsQueue.size()!=0){
            int length = bfsQueue.size();
            for (int i=0;i<length;i++){
                TreeNode node = bfsQueue.poll();
                if(i==length-1){
                    result.add(node.val);
                }
                if(node.left != null){
                    bfsQueue.add(node.left);
                }
                if(node.right != null){
                    bfsQueue.add(node.right);
                }
            }
        }
        return result;
    }
}
