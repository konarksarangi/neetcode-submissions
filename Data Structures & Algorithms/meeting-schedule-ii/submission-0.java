/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if(intervals == null || intervals.isEmpty()){
            return 0;
        }

        intervals.sort((a,b)->Integer.compare(a.start,b.start));

        PriorityQueue<Integer> meetingHeap = new PriorityQueue<>();

        for(Interval interval : intervals){
            if(!meetingHeap.isEmpty() && meetingHeap.peek() <=interval.start){
                meetingHeap.poll();
            }

            meetingHeap.add(interval.end);
        }
        return meetingHeap.size();
    }
}
