class Solution {
    public int combinationSum4(int target, int[] nums, int[] dp) {
        if(target == 0) {
            return 1;
        }

        if(dp[target] != -1) return dp[target];
        
        int count = 0;
        for(int num : nums) {
            if(num <= target) {
                count += combinationSum4(target - num, nums, dp);
            }
        }

        return dp[target] = count;
    }

    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        return combinationSum4(target, nums, dp);
    }
}