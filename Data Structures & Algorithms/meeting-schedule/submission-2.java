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
        if(intervals.size() == 0) return true;
        Collections.sort(intervals, (a, b) -> a.end - b.end);

        int nextAvailableSlot = intervals.get(0).end;
        int count = 1;

        for(int i=1; i<intervals.size(); i++) {
            int meetingStartTime = intervals.get(i).start;
            int meetingEndTime = intervals.get(i).end;

            if(meetingStartTime >= nextAvailableSlot) {
                nextAvailableSlot = meetingEndTime;
                count++;
            }
        }

        return count == intervals.size();
    }
}
