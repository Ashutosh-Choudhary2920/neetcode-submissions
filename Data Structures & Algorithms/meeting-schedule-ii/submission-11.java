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
        
        List<Integer> startList = intervals.stream().map(interval -> interval.start).collect(Collectors.toList());
        List<Integer> endList = intervals.stream().map(interval -> interval.end).collect(Collectors.toList());

        Collections.sort(startList);
        Collections.sort(endList);

        int count = 1, max = 1;
        int i = 1, j = 0;

        while(i < n && j < n) {
            if(startList.get(i) < endList.get(j)) {
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
