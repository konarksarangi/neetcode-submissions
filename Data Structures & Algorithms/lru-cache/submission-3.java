class LRUCache {

    private static class Node{
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value){
            this.key=key;
            this.value=value;
        }
    }
    private final int capacity;
    private final Map<Integer,Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.map = new HashMap<>();
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        if(!this.map.containsKey(key)){
            return -1;
        }
        Node node = this.map.get(key);
        remove(node);
        insertAtHead(node);
        return node.value;        
    }
    
    public void put(int key, int value) {
        if(this.map.containsKey(key)){
            Node node = this.map.get(key);
            node.value=value;
            remove(node);
            insertAtHead(node);
        }else{
            if(this.map.size()==capacity){
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node newNode = new Node(key,value);
            map.put(key,newNode);
            insertAtHead(newNode);
        }
    }

    public void remove(Node node){
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }

    public void insertAtHead(Node node){
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
        node.prev=head;
    }

}
