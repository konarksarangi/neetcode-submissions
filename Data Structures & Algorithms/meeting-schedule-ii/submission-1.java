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

        intervals.sort((a,b)->a.start-b.start);
        PriorityQueue<Integer> meetingQueue = new PriorityQueue<>();

        for(Interval interval:intervals){
            if(!meetingQueue.isEmpty() && interval.start >= meetingQueue.peek()){
                meetingQueue.poll();
            }
            meetingQueue.add(interval.end);
        }
        return meetingQueue.size();
    }
}
