class Solution {
    public int characterReplacement(String s, int k) {
        int l = 0, r = 0, n = s.length(), maxFrequency = 0, maxLen = 0;

        int[] hash = new int[26];

        while(r < n) {
            hash[s.charAt(r)-'A']++;
            
            maxFrequency = Math.max(maxFrequency, hash[s.charAt(r)-'A']);

            if((r-l+1)-maxFrequency > k) {
                hash[s.charAt(l)-'A']--;
                l++;
            }

            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }

        return maxLen;
    }
}
