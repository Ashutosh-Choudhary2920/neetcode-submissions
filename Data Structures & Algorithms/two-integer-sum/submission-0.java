class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            if(map.containsKey(target - nums[i])) {
                int[] ans = new int[2];
                ans[0] = i;
                ans[1] = map.get(target - nums[i]);

                Arrays.sort(ans);

                return ans;
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
