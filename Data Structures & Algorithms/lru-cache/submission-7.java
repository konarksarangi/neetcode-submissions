class LRUCache {
    class Node{
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }

    private final int capacity;
    private final Node head;
    private final Node tail;
    private final Map<Integer,Node> cacheMap;


    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.head= new Node(-1,-1);
        this.tail= new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
        this.cacheMap = new HashMap<>();

    }
    
    public int get(int key) {
        if(!this.cacheMap.containsKey(key)){
            return -1;
        }else{
            Node node = this.cacheMap.get(key);
            remove(node);
            addToHead(node);
            return node.value;
        }
        
    }
    
    public void put(int key, int value) {
        if(this.cacheMap.containsKey(key)){
            Node node = this.cacheMap.get(key);
            node.value = value;
            remove(node);
            addToHead(node);
        }else{
            Node node = new Node(key,value);
            if(this.cacheMap.size() == this.capacity){
                this.cacheMap.remove(this.tail.prev.key);
                remove(this.tail.prev);
            }
            this.cacheMap.put(key,node);
            addToHead(node);
        }
    }

    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void addToHead(Node node){
        node.next=this.head.next;
        node.next.prev = node;
        this.head.next=node;
        node.prev=this.head;
    }
}
