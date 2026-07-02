/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        Map<Node,Node> clonedGraph = new HashMap<>();

        return recursiveGraph(node,clonedGraph);
        
    }

    private Node recursiveGraph(Node node, Map<Node,Node> clonedGraph) {

        if(clonedGraph.containsKey(node)){
            return clonedGraph.get(node);
        }

        Node newNode = new Node(node.val);

        clonedGraph.put(node,newNode);

        for(Node neighborNode: node.neighbors){
            newNode.neighbors.add(recursiveGraph(neighborNode, clonedGraph));
        }
        return newNode;
    }
}