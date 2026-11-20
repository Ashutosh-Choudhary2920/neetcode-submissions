class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(u).add(v);
        }

        int[] indegree = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            for(int neighbour : adj.get(i)) {
                indegree[neighbour]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(indegree[i] == 0) {
                q.add(i);
            }
        }

        int count = 0;

        while(!q.isEmpty()) {
            int node = q.poll();
            count++;

            for(int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        return count == numCourses;
    }
}
