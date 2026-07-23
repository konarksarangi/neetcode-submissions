class LRUCache {
    private final int capacity;
    private final LinkedHashMap<Integer,Integer> cacheMap;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.cacheMap = new LinkedHashMap<>(capacity,0.75f,true);
    }
    
    public int get(int key) {
        return cacheMap.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        if(cacheMap.containsKey(key)){
            cacheMap.put(key,value);
        }else{
            if(cacheMap.size() == capacity){
                cacheMap.pollFirstEntry();
            }
            cacheMap.put(key,value);
        }
    }
}
