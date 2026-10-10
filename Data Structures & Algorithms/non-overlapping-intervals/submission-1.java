class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int nextAvailableSlot = intervals[0][1];
        int count = 1;

        for(int i=1; i<n; i++) {
            if(intervals[i][0] >= nextAvailableSlot) {
                count++;
                nextAvailableSlot = intervals[i][1];
            }
        }

        return n - count;
    }
}
