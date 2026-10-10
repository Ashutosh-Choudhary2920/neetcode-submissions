class Solution {
    public int numDecodings(int index, String s, int[] dp) {
        if(index < 0) {
            return 1;
        }

        if(dp[index] != -1) return dp[index];

        int count = 0; 

        if(s.charAt(index) != '0') {
            count += numDecodings(index-1, s, dp);
        }

        if(index >= 1 && s.charAt(index-1) != '0' && Integer.parseInt(s.substring(index-1, index+1)) <= 26) {
            count += numDecodings(index-2, s, dp);
        }

        return dp[index] = count;
        
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return numDecodings(s.length()-1, s, dp);
    }
}
