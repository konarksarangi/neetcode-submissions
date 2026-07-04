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
        Queue<TreeNode> bfsQueue = new LinkedList<>();
        bfsQueue.add(root);

        while (bfsQueue.size() >0){
            int length = bfsQueue.size();
            List<Integer> innerList = new ArrayList<>();

            for (int i=0;i<length;i++){
                TreeNode node = bfsQueue.poll();
                innerList.add(node.val);
                if(node.left != null){
                    bfsQueue.add(node.left);
                }
                if(node.right != null){
                    bfsQueue.add(node.right);
                }
            }
            result.add(innerList);
        }
        return result;
    }
}
