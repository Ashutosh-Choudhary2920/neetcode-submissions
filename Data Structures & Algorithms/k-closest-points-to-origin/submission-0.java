class Solution {
    private int getEuclideanDistanceSquare(int[] points) {
        int x = points[0];
        int y = points[1];

        int distanceSquare = x*x + y*y;

        return distanceSquare;
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> getEuclideanDistanceSquare(b) - getEuclideanDistanceSquare(a));

        for(int[] point : points) {
            if(pq.size() < k) {
                pq.add(point);
            } else if(getEuclideanDistanceSquare(point) < getEuclideanDistanceSquare(pq.peek())) {
                pq.poll();
                pq.add(point);
            }
        }

        int[][] ans = new int[k][2];

        for(int i=0; i<k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
        
    }
}