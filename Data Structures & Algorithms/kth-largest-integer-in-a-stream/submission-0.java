class KthLargest {

    PriorityQueue<Integer> pq;
    int k;

    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        this.k = k;

        for(int i=0; i<nums.length; i++) {
            if(pq.size() < k) {
                pq.add(nums[i]);
            } else if(pq.peek() < nums[i]) {
                pq.poll();
                pq.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        if(pq.size() < k) {
            pq.add(val);
            return pq.peek();
        }

        if(pq.peek() < val) {
            pq.poll();
            pq.add(val);
        }

        return pq.peek();
    }
}