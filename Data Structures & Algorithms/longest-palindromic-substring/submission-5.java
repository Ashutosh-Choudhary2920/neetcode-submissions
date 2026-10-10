class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int max = -1, startIndex = 0;
        for(int i = n-1; i >= 0; i--) {
            for(int j = i; j < n; j++) {
                int len = j - i + 1;
                if(s.charAt(i) == s.charAt(j) && ((j-i+1) <= 3 || dp[i+1][j-1])) {
                    if(len > max) {
                        max = len;
                        startIndex = i;
                    }
                    dp[i][j] = true;
                }
            }
        }

        return s.substring(startIndex, startIndex + max);
    }
}
