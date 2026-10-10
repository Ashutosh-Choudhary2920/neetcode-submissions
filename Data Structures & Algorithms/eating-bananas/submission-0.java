class Solution {
    private boolean isPossible(int[] piles, int h, int rate) {
        int totalHours = 0; 
        for(int i=0; i<piles.length; i++) {
            totalHours += Math.ceil((double)piles[i]/rate);
        }

        return totalHours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Arrays.stream(piles).max().getAsInt();

        while(low <= high) {
            int mid = (low + high)/2;
            if(isPossible(piles, h, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
