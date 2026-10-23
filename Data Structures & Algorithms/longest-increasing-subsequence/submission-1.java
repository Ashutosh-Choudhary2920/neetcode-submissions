class Solution {
    private int lower_bound(List<Integer> arr, int target) {
        int low = 0, high = arr.size()-1, ans = 0;

        while(low <= high) {
            int mid = low + (high-low)/2;

            if(arr.get(mid) >= target) {
                ans = mid;
                high = mid - 1;
            } else low = mid + 1;
        }

        return ans;
    }

    public int lengthOfLIS(int[] nums)  {
        List<Integer> subsequence = new ArrayList<>();
        subsequence.add(nums[0]);

        for(int i=1; i<nums.length; i++) {
            if(nums[i] > subsequence.get(subsequence.size()-1)) {
                subsequence.add(nums[i]);
            } else {
                int pos = lower_bound(subsequence, nums[i]);
                // if(pos == -1) pos++;
                subsequence.set(pos, nums[i]);
            }
        }

        return subsequence.size();
    }
}


