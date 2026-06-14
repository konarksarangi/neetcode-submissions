class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        if(intervals.length ==0 && newInterval.length==0 ){
            return intervals;
        }else if(intervals.length ==0 && newInterval.length >0){
            return new int[][]{newInterval};
        }
        intervals = Arrays.copyOf(intervals,intervals.length+1);
        intervals[intervals.length-1]=newInterval;

        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        LinkedList<int[]> intervalEndList = new LinkedList<>();

        for (int[] interval : intervals){
            if(intervalEndList.isEmpty() || interval[0] > intervalEndList.getLast()[1]){
                intervalEndList.add(interval);
            } else{
                intervalEndList.getLast()[1] = Math.max(interval[1],intervalEndList.getLast()[1]);
            }

        }
        return intervalEndList.toArray(new int[intervalEndList.size()][]);
    
        
    }
}
