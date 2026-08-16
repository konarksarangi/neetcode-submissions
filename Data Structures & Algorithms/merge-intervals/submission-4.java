class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length ==0){
            return intervals;
        }

        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        LinkedList<int[]> mergeLinkedList = new LinkedList<>();

        for(int[] interval:intervals){
            if(mergeLinkedList.isEmpty() || interval[0]>mergeLinkedList.getLast()[1]){
                mergeLinkedList.add(interval);
            }else{
                mergeLinkedList.getLast()[1] = Math.max(interval[1],mergeLinkedList.getLast()[1]);
            }
        }
        return mergeLinkedList.toArray(new int[mergeLinkedList.size()][]);
    }
}
