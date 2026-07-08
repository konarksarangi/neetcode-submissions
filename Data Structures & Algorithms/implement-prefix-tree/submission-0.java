class PrefixTree {
    TrieNode root;

    public PrefixTree() {
         root=new TrieNode();
    }

    public void insert(String word) {
        TrieNode current=root;
        for (char c:word.toCharArray()){
            current.trieNodeChildrenMap.putIfAbsent(c,new TrieNode());
            current=current.trieNodeChildrenMap.get(c);
        }
        current.endOfTheWord=true;
    }

    public boolean search(String word) {
       TrieNode current=root;
        for (char c:word.toCharArray()){
            if(!current.trieNodeChildrenMap.containsKey(c)){
                return false;
            }
            current=current.trieNodeChildrenMap.get(c);
        }
        return current.endOfTheWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current=root;
        for (char c:prefix.toCharArray()){
            if(!current.trieNodeChildrenMap.containsKey(c)){
                return false;
            }
            current=current.trieNodeChildrenMap.get(c);
        }
        return true;

    }
}

class TrieNode{
    Map<Character,TrieNode> trieNodeChildrenMap = new HashMap<>();
    boolean endOfTheWord;
}
