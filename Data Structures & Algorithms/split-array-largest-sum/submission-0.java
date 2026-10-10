class Solution {
    private boolean isPossible(int[] nums, int k , int partition) {
        int partitions = 1, partitionSum = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] + partitionSum <= partition) {
                partitionSum += nums[i];
            } else {
                partitions++;
                partitionSum = nums[i];
            }
        }

        return partitions <= k; 
    }
    public int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();
        
        while(low <= high) {
            int mid = (low + high)/2;

            if(isPossible(nums, k, mid)) high = mid - 1;
            else low = mid + 1;
        }

        return low;


    }
}