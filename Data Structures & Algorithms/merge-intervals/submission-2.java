class Solution {
        public int[][] merge(int[][] intervals) {
        if (intervals.length <1){
            return intervals;
        }
//intervals=[[0,2],[1,4],[3,5]]
        LinkedList<int[]> finalList  = new LinkedList<>();
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        for (int[] interval : intervals){
            if (finalList.isEmpty() || interval[0] > finalList.getLast()[1]){
                finalList.add(interval);
            }
            else{
                finalList.getLast()[1]=Math.max(finalList.getLast()[1],interval[1]);
            }
    
        }
        return finalList.toArray(new int[finalList.size()][]);
        
    }
}
