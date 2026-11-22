class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length-1, maxWater = 0;

        while(left <= right) {
            int waterTrapped = Math.min(height[left], height[right]) * (right - left);

            maxWater = Math.max(waterTrapped, maxWater);

            if(height[left] < height[right]) left++;
            else right--;
        }

        return maxWater;
    }
}