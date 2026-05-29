class LRUCache {
    private final int capacity;
    private final LinkedHashMap<Integer,Integer> storageMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.storageMap = new LinkedHashMap<>(capacity,0.75f,true);
    }
    
    public int get(int key) {
        return  this.storageMap.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        if (storageMap.get(key)!= null && storageMap.get(key) != -1) {
            this.storageMap.put(key, value);
        }else{
            if (this.storageMap.size() == this.capacity) {
                this.storageMap.pollFirstEntry();
            }
            this.storageMap.put(key, value);
        }
    }
}
