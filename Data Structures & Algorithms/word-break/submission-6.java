class Solution {
    public boolean wordBreak(int index, String s, List<String> wordDict, Boolean[] dp) {
        if(index == s.length()) {
            return true;
        }

        if(dp[index] != null) return dp[index];

        for(int len = 1; index + len <= s.length(); len++) {
            String word = s.substring(index, index + len);
            if(wordDict.contains(word) && wordBreak(index + len, s, wordDict, dp)) {
                return dp[index] = true;
            }
        }

        return dp[index] = false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] dp = new Boolean[s.length()];
        return wordBreak(0, s, wordDict, dp);
    }
}
