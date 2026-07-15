class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        int[] result = new int[k];
        //Map contains count for each number
        for (int num:nums){
            count.put(num,count.getOrDefault(num,0)+1);
        }

        Queue<Integer> countQueue = new PriorityQueue<>((a,b)->count.get(a)-count.get(b));

        for (int num:count.keySet()){
            countQueue.add(num);
            if(countQueue.size()>k){
                countQueue.poll();
            }
        }
        int counter=0;
        while (!countQueue.isEmpty()){
            result[counter++]=countQueue.poll();
        }

        return result;
    }
}
