class Solution {
    private boolean isPalindrome(int left, int right, String s, Boolean[][] dp) {
        if(left >= right) return true;

        if(dp[left][right] != null) return dp[left][right];

        if(s.charAt(left) != s.charAt(right)) {
            return dp[left][right] = false;
        }

        return dp[left][right] = isPalindrome(left + 1, right - 1, s, dp);
    }

    public String longestPalindrome(String s) {
        int max = -1, n = s.length(), startIndex = 0;

        Boolean[][] dp = new Boolean[n][n];

        for(int left = 0; left < n; left++) {
            for(int right = 0; right < n; right++) {
                int currentLength = right - left + 1;
                if(isPalindrome(left, right, s, dp)) {
                    if(currentLength > max) {
                        max = currentLength;
                        startIndex = left;
                    }
                }
            }
        } 

        System.out.print("Start Index: " + startIndex + ", Length: " + max);

        return s.substring(startIndex, startIndex + max);
    }
}
