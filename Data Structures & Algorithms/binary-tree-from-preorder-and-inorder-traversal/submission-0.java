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
        Map<Integer,Integer> inOrderMap = new HashMap<>();

        for (int i=0;i<inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }

        return buildTreeRecursive(preorder,inOrderMap,0,preorder.length-1,0,inorder.length-1);

    }
    public TreeNode buildTreeRecursive(int[] preorder, Map<Integer,Integer> inOrderMap,int preStart,int preEnd,int inStart,int inEnd){
        //Base case
        if((preStart>preEnd) || (inStart>inEnd)){
            return null;
        }

        //Construct the root for current sub tree
        int rootValue = preorder[preStart];
        TreeNode root = new TreeNode(rootValue);

        //Get the index of the root fot current sub tree
        int rootIndex = inOrderMap.get(rootValue);

        
        int leftSubtreeSize = rootIndex-inStart;
        root.left = buildTreeRecursive(preorder,inOrderMap,preStart+1,preStart+leftSubtreeSize,inStart,rootIndex-1);
        root.right = buildTreeRecursive(preorder,inOrderMap,preStart+leftSubtreeSize+1,preEnd,rootIndex+1,inEnd);

        return root;

    }
}
