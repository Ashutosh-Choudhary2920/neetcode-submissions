class Solution {
    private boolean isPossible(int[] weights, int days, int maxWeight) {
        int elapsedDays = 1, weightAlreadyTaken = 0;

        for(int i = 0; i < weights.length; i++) {
            if(weights[i] + weightAlreadyTaken <= maxWeight) {
                weightAlreadyTaken += weights[i];
            } else {
                elapsedDays++;
                weightAlreadyTaken = weights[i];
            }
        }

        return elapsedDays <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();

        while(low <= high) {
            int mid = (low + high)/2;
            if(isPossible(weights, days, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}