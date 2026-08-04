class WordDictionary {
    Node root;
    class Node{
        Map<Character,Node> children = new HashMap<>();
        boolean endOftheWord;
    }

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node current = root;
        for(char c:word.toCharArray()){
            current.children.putIfAbsent(c,new Node());
            current=current.children.get(c);
        }
        current.endOftheWord=true;
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }

    private boolean dfs(String word, int start, Node root){
        Node current = root;
        for(int i=start;i<word.length();i++){
            char c = word.charAt(i);
            if(c == '.'){
                for(Node child:current.children.values()){
                    if(child != null && dfs(word,i+1,child)){
                        return true;
                    }
                }
                return false;
            }else{
                if(!current.children.containsKey(c)){
                    return false;
                }
                current=current.children.get(c);
            }
        }
        return current.endOftheWord;
    }
}
