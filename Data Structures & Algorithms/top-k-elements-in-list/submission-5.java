class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        Map<Integer,Integer> topKMap = new HashMap<>();
        int[] result = new int[k];

        for(int num:nums){
            topKMap.put(num,topKMap.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> topkQueue = new PriorityQueue<>((a,b)->topKMap.get(a)-topKMap.get(b));

        for(int num:topKMap.keySet()){
            topkQueue.add(num);
            if(topkQueue.size() > k){
                topkQueue.poll();
            }
        }
        for(int i=0;i<k;i++){
            result[i]=topkQueue.poll();
        }

        return result;
    }
}

