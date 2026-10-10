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
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        for(int i=1; i<intervals.size(); i++) {
            int currentMeetingStartTime = intervals.get(i).start;
            int previousMeetingEndTime = intervals.get(i-1).end;

            if(currentMeetingStartTime < previousMeetingEndTime){
                return false;
            }
        }

        return true;
    }
}
