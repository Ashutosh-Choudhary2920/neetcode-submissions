class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;

        ans.add(intervals[0]);

        for(int i=1; i<n; i++) {
            if(intervals[i][0] <= ans.get(ans.size()-1)[1]) {
                ans.get(ans.size()-1)[1] = Math.max(ans.get(ans.size()-1)[1], intervals[i][1]);
            } else {
                ans.add(intervals[i]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
