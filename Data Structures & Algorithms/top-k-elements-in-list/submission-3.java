class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> numMap = new HashMap<>();

        for(int num:nums){
            numMap.put(num,numMap.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> numQueue = new PriorityQueue<>((a,b)->numMap.get(a)-numMap.get(b));

        for(Integer key:numMap.keySet()){
            numQueue.add(key);
            if(numQueue.size()>k){
                numQueue.poll();
            }
        }

        int[] result = new int[k];
        int count=0;
        while(!numQueue.isEmpty()){
            result[count++]=numQueue.poll();
        }
        return result;
    }
}
