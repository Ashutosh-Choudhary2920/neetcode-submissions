class Solution {
    public int numSquares(int index, int target, int[][] dp) {
        if (target == 0) {
            return 0;
        }

        if (index * index > target) {
            return (int) 1e9;
        }

        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        int notTake = numSquares(index + 1, target, dp);
        int take = (int) 1e9;

        if (index * index <= target) {
            take = 1 + numSquares(index, target - index * index, dp);
        }

        return dp[index][target] = Math.min(take, notTake);
    }

    public int numSquares(int n) {
        int[][] dp = new int[n + 1][n + 1];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return numSquares(1, n, dp);
    }
}