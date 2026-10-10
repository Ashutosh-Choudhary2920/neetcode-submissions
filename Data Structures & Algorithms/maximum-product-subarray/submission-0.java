class Solution {
    public int maxProduct(int[] nums) {
        int prefixProduct = 1, suffixProduct = 1;
        int maxProduct = Integer.MIN_VALUE;

        int n = nums.length;

        for(int i = 0; i < n; i++) {
            if(prefixProduct == 0) prefixProduct = 1;
            if(suffixProduct == 0) suffixProduct = 1;
            
            prefixProduct *= nums[i];
            suffixProduct *= nums[n - i - 1];

            maxProduct = Math.max(maxProduct, Math.max(prefixProduct, suffixProduct));
        }

        return maxProduct;
    }
}
