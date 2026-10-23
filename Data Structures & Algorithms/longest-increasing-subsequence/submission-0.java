class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> lis = new ArrayList<>();

        lis.add(nums[0]);

        for(int i=1; i<nums.length; i++) {
            if(nums[i] > lis.get(lis.size() - 1)) {
                lis.add(nums[i]);
            } else {
                int index = Collections.binarySearch(lis, nums[i]);
                if(index < 0) index = -index - 1;

                lis.set(index, nums[i]);
            }
        }

        return lis.size();
    }
}
