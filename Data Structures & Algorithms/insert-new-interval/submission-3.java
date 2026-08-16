class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if(intervals.length ==0 && newInterval.length ==0){
            return intervals;
        }

        intervals = Arrays.copyOf(intervals,intervals.length+1);
        intervals[intervals.length-1] = newInterval;

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        LinkedList<int[]> intervalLinkedList = new LinkedList<>();

        for(int[] interval:intervals){
            if(intervalLinkedList.isEmpty() || interval[0]>intervalLinkedList.getLast()[1]){
                intervalLinkedList.add(interval);
            }else{
                intervalLinkedList.getLast()[1] = Math.max(interval[1],intervalLinkedList.getLast()[1]);
            }
        }

        return intervalLinkedList.toArray(new int[intervalLinkedList.size()][]);

    }
}
