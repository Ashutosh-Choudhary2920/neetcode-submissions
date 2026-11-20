class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < prerequisites.length; i++) {
            int u = prerequisites[i][0];
            int v = prerequisites[i][1];

            adj.get(v).add(u);
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

        List<Integer> topo = new ArrayList<>();

        while(!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for(int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if(indegree[neighbour] == 0) {
                    q.add(neighbour);
                }
            }
        }

        if(topo.size() != numCourses) return new int[0];

        int[] order = new int[numCourses];

        for(int i = 0; i < numCourses; i++) {
            order[i] = topo.get(i);
        }

        return order;

    }
}
