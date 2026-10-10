class Solution {
    public boolean canJump(int[] nums) {
        int maxIndexThatCanBeReached = 0;
        int n = nums.length;

        for(int i=0; i<n; i++) {
            if(i > maxIndexThatCanBeReached) {
                return false;
            }

            maxIndexThatCanBeReached = Math.max(maxIndexThatCanBeReached, i + nums[i]);
        }

        return true;
    }
}
