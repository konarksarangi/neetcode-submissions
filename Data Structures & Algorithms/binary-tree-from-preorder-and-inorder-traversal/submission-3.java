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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> inorderMap = new HashMap<>();
        int[] preorderIndex = new int[1];
        preorderIndex[0]=0;

        for(int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }

        return buildTreeRecursive(preorder,inorder,preorderIndex,inorderMap,0,inorder.length-1);
    }

    private TreeNode buildTreeRecursive(int[] preorder, int[] inorder, int[] preorderIndex, Map<Integer,Integer> inorderMap, int inorderStart, int inorderEnd){
        if(inorderStart>inorderEnd){
            return null;
        }

        int rootValue=preorder[preorderIndex[0]++];
        TreeNode node = new TreeNode(rootValue);

        int rootIndex=inorderMap.get(rootValue);

        node.left=buildTreeRecursive(preorder,inorder,preorderIndex,inorderMap,inorderStart,rootIndex-1);
        node.right=buildTreeRecursive(preorder,inorder,preorderIndex,inorderMap,rootIndex+1,inorderEnd);

        return node;

    }
}
