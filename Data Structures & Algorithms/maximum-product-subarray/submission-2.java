class Solution {
    public int maxProduct(int[] nums) {
        int currMin = 1, currMax = 1;
        int max = Integer.MIN_VALUE;

        for(int num : nums) {
            int temp = currMax * num;
            currMax = Math.max(Math.max(currMax * num, currMin * num), num);
            currMin = Math.min(Math.min(temp, currMin * num), num);

            max = Math.max(max, currMax);
        }

        return max;
    }
}
