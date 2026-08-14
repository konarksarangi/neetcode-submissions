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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> result = new ArrayList<>();
        int length=0;

        Queue<TreeNode> lotQueue = new LinkedList<>();
        lotQueue.add(root);

        while (!lotQueue.isEmpty()){
            length=lotQueue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<length;i++){
                TreeNode node = lotQueue.poll();
                temp.add(node.val);
                if(node.left != null){
                    lotQueue.add(node.left);
                }
                if(node.right != null){
                    lotQueue.add(node.right);
                }
            }
            result.add(temp);
        }
        return result;
    }
}
