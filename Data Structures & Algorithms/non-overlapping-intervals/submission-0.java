class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int next = intervals[0][1];
        int count = 1;

        for(int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if(start >= next) {
                next = end;
                count++;
            }
        }

        return intervals.length - count;
    }
}
