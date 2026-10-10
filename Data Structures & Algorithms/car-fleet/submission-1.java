class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
       int n = position.length;
       double[][] carPositionAndTime = new double[n][2];

       for(int i=0; i<n; i++) {
        carPositionAndTime[i][0] = position[i];
        carPositionAndTime[i][1] = (double)(target-position[i])/speed[i];
       }

       Arrays.sort(carPositionAndTime, (a, b) -> Double.compare(b[0], a[0]));

        int fleet = 0;
        double prevTime = 0;
       for(int i=0; i<n; i++) {
        double currTime = carPositionAndTime[i][1];
        if(currTime > prevTime) {
            fleet++;
            prevTime = currTime;
        }
       }

       return fleet;
    }

}
