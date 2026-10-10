class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for(int stone : stones) {
            pq.add(stone);
        }

        while(pq.size() != 0) {
            if(pq.size() == 1) {
                return pq.peek();
            }

            int top = pq.poll();
            int nextTop = pq.poll();
            
            if(top != nextTop) {
                pq.add(top-nextTop);
            }
        }

        return 0;
    }
}