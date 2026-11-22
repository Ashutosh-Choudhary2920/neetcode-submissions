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

        for(int i = 1; i < intervals.size(); i++) {
            int currentStartTime = intervals.get(i).start;
            int currentEndTime = intervals.get(i).end;

            if(currentStartTime < intervals.get(i-1).end) {
                return false;
            }
        }

        return true;
    }
}
