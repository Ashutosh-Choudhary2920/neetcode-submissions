class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intervalList = new ArrayList<>();
        int i=0, n = intervals.length;

        while(i < n && intervals[i][1] < newInterval[0]) {
            intervalList.add(intervals[i]);
            i++;
        }

        while(i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        intervalList.add(newInterval);

        while(i < n) {
            intervalList.add(intervals[i]);
            i++;
        }

        return intervalList.toArray(new int[intervalList.size()][]);
        
    }
}
