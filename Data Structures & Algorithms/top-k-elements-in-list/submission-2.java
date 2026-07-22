class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] result = new int[k];

        for (int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));
        
        for (Integer key:map.keySet()){
            queue.add(key);
            if(queue.size()>k){
                queue.poll();
            }
        }
        int counter=0;
        while (!queue.isEmpty()){
            result[counter++]=queue.poll();
        }
        return result;
    }
}
