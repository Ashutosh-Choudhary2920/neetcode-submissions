class Solution {
    private boolean isPalindrome(int left, int right, String s, Boolean[][] dp) {
        if(left >= right) {
            return true;
        }

        if(dp[left][right] != null) return dp[left][right];

        if(s.charAt(left) != s.charAt(right)) {
            return dp[left][right] = false;
        }

        return dp[left][right] = isPalindrome(left + 1, right - 1, s, dp);
    }

    public int countSubstrings(String s) {
        int count = 0, n = s.length();
        Boolean[][] dp = new Boolean[n][n];
        System.out.println(dp[0][0]);
        for(int left = 0; left < n; left++) {
            for(int right = left; right < n; right++) {
                if(isPalindrome(left, right, s, dp)) {
                    count++;
                }
            }
        }

        return count;
    }
}
