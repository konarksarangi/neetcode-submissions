class PrefixTree {
    TrieNode root;
    class TrieNode{
        Map<Character,TrieNode> childrenNode = new HashMap<>();
        boolean endOfTheWord;
    }
    public PrefixTree() {
         root= new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;
        for(char c:word.toCharArray()){
            current.childrenNode.putIfAbsent(c,new TrieNode());
            current=current.childrenNode.get(c);
        }
        current.endOfTheWord=true;
    }

    public boolean search(String word) {
        TrieNode current = root;
        for(char c:word.toCharArray()){
            if(!current.childrenNode.containsKey(c)){
                return false;
            }
            current=current.childrenNode.get(c);
        }
        return current.endOfTheWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for(char c:prefix.toCharArray()){
            if(!current.childrenNode.containsKey(c)){
                return false;
            }
            current=current.childrenNode.get(c);
        }
        return true;
    }
}
