class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] frequency = new int[26];

        for(char ch : tasks) {
            frequency[ch - 'A']++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for(int f : frequency) {
            if(f != 0) {
                pq.add(f);
            }
        }

        Queue<int[]> q = new LinkedList<>();

        int time = 0;

        while(!q.isEmpty() || !pq.isEmpty()) {
            time++;

            if(!q.isEmpty() && q.peek()[1] == time) {
                pq.add(q.poll()[0]);
            }

            if(!pq.isEmpty()) {
                int count = pq.poll();

                count--;

                if(count > 0) {
                    q.add(new int[]{count, time + n + 1});
                }
            }
        }

        return time;
    }
}