class Solution {
    public boolean canPartition(int index, int target, int[] nums, Boolean[][] dp) {
        if(target == 0) return true;
        if(index == 0) return nums[index] == target;

        if(dp[index][target] != null) return dp[index][target];

        boolean notTake = canPartition(index - 1, target, nums, dp);

        boolean take = false;
        if(nums[index] <= target) {
            take = canPartition(index - 1, target - nums[index], nums, dp);
        }

        return dp[index][target] = take || notTake;

    }
    public boolean canPartition(int[] nums) {
        int sum = Arrays.stream(nums).sum();
        
        if(sum % 2 == 1) return false;

        int target = sum/2;
        int n = nums.length;

        Boolean[][] dp = new Boolean[n][target + 1];

        return canPartition(n - 1, target, nums, dp);
    }
}
