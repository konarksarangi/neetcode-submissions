class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> kMap = new HashMap<>();
        for(int num:nums){
            kMap.put(num,kMap.getOrDefault(num,0)+1);
        }

        PriorityQueue<Integer> kQueue = new PriorityQueue<>((a,b)->kMap.get(a)-kMap.get(b));

        for(int num:kMap.keySet()){
            kQueue.add(num);
            if(kQueue.size() > k){
                kQueue.poll();
            }
        }

        int[] result = new int[k];
        for(int i=0;i<k;i++){
            result[i] = kQueue.poll();
        }

        return result;

    }
}
