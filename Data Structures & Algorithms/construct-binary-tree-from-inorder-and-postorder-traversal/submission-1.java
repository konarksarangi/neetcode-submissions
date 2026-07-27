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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length){
            return null;
        }

        Map<Integer,Integer> inorderMap = new HashMap<>();
        int []postIndex = new int[1];

        for (int i=0;i<inorder.length;i++){
            inorderMap.put(inorder[i],i);
        }
        postIndex[0] = postorder.length - 1;

        return buildTreeRecursive(inorder,postorder,0,inorder.length-1,postIndex,inorderMap);
        
    }

    public TreeNode buildTreeRecursive(int[] inorder, int[] postorder, int inorderStart, int inorderEnd, int[] postIndex, Map<Integer,Integer> inorderMap){
        if (inorderStart > inorderEnd) {
            return null;
        }

        int rootValue = postorder[postIndex[0]--];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inorderMap.get(rootValue);

        root.right = buildTreeRecursive(inorder, postorder, rootIndex + 1, inorderEnd,postIndex,inorderMap);
        root.left = buildTreeRecursive(inorder, postorder, inorderStart, rootIndex - 1,postIndex,inorderMap);

        return root;

    }

}