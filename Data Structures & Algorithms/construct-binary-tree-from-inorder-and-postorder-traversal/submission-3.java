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

        Map<Integer,Integer> inOrderMap = new HashMap<>();
        int[] postOrderIndex = new int[1];
        postOrderIndex[0]=postorder.length-1;
        for (int i=0;i<inorder.length;i++){
            inOrderMap.put(inorder[i],i);
        }
        return buildRecursive(inOrderMap,inorder,0,inorder.length-1,postOrderIndex,postorder);

    }
    private TreeNode buildRecursive(Map<Integer,Integer> inOrderMap,int[] inorder,int inOrderStart, int inOrderEnd, int[] postOrderIndex, int[] postorder){
        if(inOrderStart > inOrderEnd){
            return null;
        }
        
        int rootValue= postorder[postOrderIndex[0]--];
        TreeNode node = new TreeNode(rootValue);

        int rootIndex = inOrderMap.get(rootValue);
         node.right = buildRecursive(inOrderMap,inorder,rootIndex+1,inOrderEnd,postOrderIndex,postorder);
       node.left = buildRecursive(inOrderMap,inorder,inOrderStart,rootIndex-1,postOrderIndex,postorder);

        return node;


    }

}