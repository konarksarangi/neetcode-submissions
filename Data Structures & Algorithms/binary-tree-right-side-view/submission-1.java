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
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);
        List<Integer> result= new ArrayList<>();
        while (bfsQueue.size()>0){
            int queueLength = bfsQueue.size();
            for (int i=0;i<queueLength;i++){
                TreeNode node = bfsQueue.poll();
                if(i == queueLength-1){
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
