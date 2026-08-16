class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length==0){
            return 0;
        }

        //[[1,100],[11,22],[1,11],[2,12]] -> [[1,11],[2,12],[11,22],[1,100]]
        Arrays.sort(intervals,(a, b)->
                Integer.compare(a[1],b[1]));
        LinkedList<int[]> intervalLinkedList = new LinkedList<>();
        int discardCounter=0;
        for(int[] interval:intervals){
            if(intervalLinkedList.isEmpty() || interval[0]>=intervalLinkedList.getLast()[1]){
                intervalLinkedList.add(interval);
            }else{
               discardCounter++;
            }
        }
        return discardCounter;
    }
}
