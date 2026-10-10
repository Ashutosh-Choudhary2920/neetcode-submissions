class Solution {
    public int coinChange(int index, int[] coins, int amount, int[][] dp) {
        if(index == 0) {
            if(amount % coins[index] == 0) {
                return amount / coins[index];
            }

            return (int)(1e9);
        }

        if(dp[index][amount] != -1) return dp[index][amount]; 

        int take = (int)(1e9);
        if(amount >= coins[index]) {
            take = 1 + coinChange(index, coins, amount - coins[index], dp);
        }

        int notTake = coinChange(index - 1, coins, amount, dp);

        return dp[index][amount] = Math.min(take, notTake);
    }

    public int coinChange(int[] coins, int amount) {
        int n = coins.length;

        int[][] dp = new int[n][amount + 1];
        for(int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }

        int totalCoins = coinChange(n-1, coins, amount, dp);

        return totalCoins >= (int)(1e9) ? -1 : totalCoins;
    }
}
