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
    public boolean canAttendMeetings(List<Interval> intervals) {

        intervals.sort((a,b)->(a.start-b.start));
        PriorityQueue<Integer> intervalQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(Interval interval:intervals){
            if(intervalQueue.isEmpty() || interval.start>=intervalQueue.peek()){
                intervalQueue.add(interval.end);
            }

        }
        return intervalQueue.size() == intervals.size();

    }
}
