class Solution {
        public static int[] initializeArray(int size, int value) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = value;
        }
        return array;
    }

    public int minCostClimbingStairs(int i, int[] cost, int[] dp) {
        if(i==0) {
            return cost[i];
        }
        if(dp[i] != -1) return dp[i];
        // int oneStep = minCostClimbingStairs(i-1, cost, dp) + Math.abs(cost[i] - cost[i-1]);
        int oneStep = minCostClimbingStairs(i-1, cost, dp) + cost[i-1];
        int twoSteps = Integer.MAX_VALUE;
        if(i>1) twoSteps = minCostClimbingStairs(i-2, cost, dp) + cost[i-2];
        return dp[i] = Math.min(oneStep, twoSteps);
    }

     public int minCostClimbingStairs(int i, int n, int[] cost, int[] dp) {
        if(i>=n) {
            return 0;
        }
        if(dp[i] != -1) return dp[i];
        int oneStep = minCostClimbingStairs(i+1, n, cost, dp) + cost[i];
        int twoSteps = Integer.MAX_VALUE;
        twoSteps = minCostClimbingStairs(i+2, n, cost, dp) + cost[i];
        return dp[i] = Math.min(oneStep, twoSteps);
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = initializeArray(n+1, -1);
        return Math.min(minCostClimbingStairs(0, n, cost, dp), minCostClimbingStairs(1, n, cost, dp));
    }
}
