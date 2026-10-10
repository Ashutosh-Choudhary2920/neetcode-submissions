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
        int n = intervals.size();

        if(n == 0) return 0;

        int[] startTimes = new int[n];
        int[] endTimes = new int[n];

        for(int i=0; i<n; i++) {
            startTimes[i] = intervals.get(i).start;
            endTimes[i] = intervals.get(i).end;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int i = 1, j = 0;
        int count = 1;
        int max = 1;

        while(i < n && j < n) {
            if(startTimes[i] < endTimes[j]) {
                count++;
                i++;
            } else {
                count--;
                j++;
            }

            max = Math.max(count, max);
        }

        return max;
    }
}
