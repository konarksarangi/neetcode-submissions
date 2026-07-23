class LRUCache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    int capacity;
    Map<Integer,Node> cacheMap;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.cacheMap=new HashMap<>();
        this.head= new Node(-1,-1);
        this.tail= new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!cacheMap.containsKey(key)){
            return -1;
        }
        Node node = cacheMap.get(key);
        remove(node);
        addToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            Node node = cacheMap.get(key);
            node.value=value;
            remove(node);
            addToHead(node);
        }else{
            Node node = new Node(key,value);
            if(capacity==cacheMap.size()){
                cacheMap.remove(tail.prev.key);
                remove(tail.prev);
            }
            cacheMap.put(key,node);
            addToHead(node);
        }
        
    }

    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void addToHead(Node node){
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
        node.prev=head;
    }
}
