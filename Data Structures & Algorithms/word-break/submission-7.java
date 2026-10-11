class Solution {
    public boolean wordBreak(int index, int lastIndex, String s, List<String> wordDict,Boolean[][] dp) {
        if(index == 0) {
            if(wordDict.contains(s.substring(index, lastIndex))){
                return true;
            }
            return false;
        }

        if(dp[index][lastIndex] != null) return dp[index][lastIndex];

        String currentWord = s.substring(index, lastIndex);

        if(wordDict.contains(currentWord)) {
            return dp[index][lastIndex] = wordBreak(index-1, index, s, wordDict, dp) || wordBreak(index-1, lastIndex, s, wordDict, dp);
        } 

        return dp[index][lastIndex] = wordBreak(index-1, lastIndex, s, wordDict, dp);
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();

        Boolean[][] dp = new Boolean[n][n+1];
        return wordBreak(n-1, n, s, wordDict, dp);
    }
}