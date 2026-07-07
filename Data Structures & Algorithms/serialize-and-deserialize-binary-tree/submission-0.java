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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "N";
        }
        StringBuilder result = new StringBuilder();
        Queue<TreeNode> treeQueue = new LinkedList<>();
        treeQueue.add(root);

        while (!treeQueue.isEmpty()){
            TreeNode node=treeQueue.poll();
            if(node==null){
                result.append("N,");
            }else{
                result.append(node.val).append(",");
                treeQueue.add(node.left);
                treeQueue.add(node.right);
            }
        }
        return result.toString();        
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] split = data.split(",");
        if(split[0]=="N"){
            return null;
        }
        TreeNode root = new TreeNode(Integer.parseInt(split[0]));
        Queue<TreeNode> bstQueue = new LinkedList<>();
        bstQueue.add(root);
        int index=1;

        while (!bstQueue.isEmpty()){
            TreeNode node = bstQueue.poll();
            if(!split[index].equals("N")){
                node.left=new TreeNode(Integer.parseInt(split[index]));
                bstQueue.add(node.left);
            }
            index++;
            if(!split[index].equals("N")){
                node.right=new TreeNode(Integer.parseInt(split[index]));
                bstQueue.add(node.right);
            }
            index++;
        }
        return root;
    }
}
