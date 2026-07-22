class LRUCache {
    private final int capacity;
    private final LinkedHashMap<Integer,Integer> cacheMap;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.cacheMap=new LinkedHashMap<>(capacity,0.75f,true);
    }
    
    public int get(int key) {
        return this.cacheMap.getOrDefault(key,-1);
    }
    
    public void put(int key, int value) {
        if(this.cacheMap.containsKey(key)){
            this.cacheMap.put(key,value);
        }else{
            if(this.cacheMap.size()==this.capacity){
                this.cacheMap.pollFirstEntry();
            }
            this.cacheMap.put(key,value);
        }
    }
}
