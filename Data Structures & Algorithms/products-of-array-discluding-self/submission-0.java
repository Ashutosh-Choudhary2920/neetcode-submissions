class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;

        int[] prefixProduct = new int[n];
        int[] postfixProduct = new int[n];

        int product = 1;

        for(int i=0; i<n; i++) {
            product = nums[i] * product;
            prefixProduct[i] = product;
        }

        product = 1;

        for(int i=n-1; i>=0; i--) {
            product = product * nums[i];
            postfixProduct[i] = product;
        }

        int[] answer = new int[n];

        for(int i=0; i<n; i++) {
            int leftProduct = (i >= 1) ? prefixProduct[i-1] : 1;
            int rightProduct = (i < n-1) ? postfixProduct[i+1] : 1;
            answer[i] = leftProduct * rightProduct;
        }

        return answer;
    }
}