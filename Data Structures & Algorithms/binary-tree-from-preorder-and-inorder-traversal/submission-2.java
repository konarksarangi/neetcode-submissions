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
        if(preorder==null || inorder==null || preorder.length != inorder.length){
            return null;
        }
        Map<Integer,Integer> bTreeMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            bTreeMap.put(inorder[i],i);
        }
        int[] preorderIndex=new int[1];
        preorderIndex[0]=0;
        return buildTreeRecursive(preorder,inorder,0,inorder.length-1,preorderIndex,bTreeMap);
    }

    private TreeNode buildTreeRecursive(int[] preorder, int[] inorder, int inorderStart, int inorderEnd, int[] preorderIndex, Map<Integer,Integer> bTreeMap){
        if(inorderStart>inorderEnd){
            return null;
        }
        
        int rootValue = preorder[preorderIndex[0]++];
        TreeNode node = new TreeNode(rootValue);

        int rootIndex=bTreeMap.get(rootValue);

        node.left=buildTreeRecursive(preorder,inorder,inorderStart,rootIndex-1,preorderIndex,bTreeMap);
        node.right=buildTreeRecursive(preorder,inorder,rootIndex+1,inorderEnd,preorderIndex,bTreeMap);

        return node;

    }


}
