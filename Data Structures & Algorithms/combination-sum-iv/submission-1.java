class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        
        dp[0] = 1;

        for(int t = 1; t<=target; t++) {
            int count = 0;
            for(int num : nums) {
                if(num <= t) {
                    count += dp[t - num];
                }
            }

            dp[t] = count;
        }

        return dp[target];
    }
}