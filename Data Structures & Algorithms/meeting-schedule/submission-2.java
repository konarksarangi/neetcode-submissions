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

        intervals.sort((a,b)->Integer.compare(a.start,b.start));
        PriorityQueue<Integer> intervalPriorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        for(Interval interval : intervals){
            if(intervalPriorityQueue.isEmpty() || interval.start >= intervalPriorityQueue.peek() ){
                intervalPriorityQueue.add(interval.end);
            }
        }

        return (intervals.size() == intervalPriorityQueue.size());
        
    }
}
