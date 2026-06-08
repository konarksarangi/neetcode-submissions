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

        if (root == null){
                return new ArrayList<>();
            }
            List<List<Integer>> result = new ArrayList<>();
            Queue <TreeNode> leveOrderQueue = new LinkedList<>();
            leveOrderQueue.add(root);

            while (leveOrderQueue.size() > 0) {
                int queueSize = leveOrderQueue.size();
                List<Integer> temp = new ArrayList<>();
                for (int i = 0; i < queueSize; i++){
                    TreeNode node = leveOrderQueue.poll();
                    temp.add(node.val);
                    if (node.left != null) {
                        leveOrderQueue.add(node.left);
                    }
                    if (node.right != null) {
                        leveOrderQueue.add(node.right);
                    }
                }
                result.add(temp);

            }

            return result;
        
    }
}
