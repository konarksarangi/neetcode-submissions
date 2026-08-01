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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return root;
        }

        //Recursive cases
        if(root.val < key){
            root.right = deleteNode(root.right,key);
        }else if(root.val > key){
             root.left = deleteNode(root.left,key);
        }else{

            //If node is found
            // No children
            if(root.left == null && root.right == null){
                return null;
            }

            // One child
            if(root.left == null){
                return root.right;
            }
            if(root.right == null){
                return root.left;
            }

            // Two children
            TreeNode node  = root.right;
            while (node.left!= null){
                node=node.left;
            }
            root.val=node.val;
            root.right = deleteNode(root.right, node.val);
        }
        return root;
   }
}