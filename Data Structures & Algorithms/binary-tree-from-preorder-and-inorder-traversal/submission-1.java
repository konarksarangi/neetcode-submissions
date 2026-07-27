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
        if (inorder == null || preorder == null || inorder.length != preorder.length) {
            throw new IllegalArgumentException("Invalid input");
        }

        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        int []preIndex = new int[1];

        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        preIndex[0] = 0;

        return buildFromPreOrder(inorder, preorder, 0, inorder.length - 1, preIndex, inorderIndexMap);

    }
    public TreeNode buildFromPreOrder(
            int[] inorder,
            int[] preorder,
            int inorderStart,
            int inorderEnd,
            int[] preIndex,
            Map<Integer, Integer> inorderIndexMap
    ) {
        if(inorderStart>inorderEnd){
            return null;
        }

        int rootValue = preorder[preIndex[0]++];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex= inorderIndexMap.get(rootValue);

        root.left = buildFromPreOrder(inorder, preorder, inorderStart, rootIndex - 1, preIndex, inorderIndexMap);
        root.right = buildFromPreOrder(inorder, preorder, rootIndex+1, inorderEnd, preIndex, inorderIndexMap);

        return root;
    }
}
