class Solution {
    public static int[] initializeArray(int size, int value) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = value;
        }
        return array;
    }

    public int rob(int i, int[] nums, int[] dp) {
        if(i == 0) return nums[i];
        if(i<0) return 0;
        if(dp[i] != -1) return dp[i]; 

        int rob = Integer.MIN_VALUE;
        int notRob = Integer.MIN_VALUE;

        rob = nums[i] + rob(i-2, nums, dp);
        notRob = rob(i-1, nums, dp);

        return dp[i] = Math.max(rob, notRob);
    }

    public int rob(int[] nums) {
        int[] dp = initializeArray(nums.length, -1);
        return rob(nums.length-1, nums, dp);
    }
}
