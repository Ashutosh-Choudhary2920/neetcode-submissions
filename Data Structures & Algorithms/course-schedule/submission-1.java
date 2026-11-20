class Solution {
    public boolean isCyclic(int startNode, int[] vis, int[] pathVis, List<List<Integer>> adj) {
      vis[startNode] = 1;
      pathVis[startNode] = 1; 

      for(int neighbour : adj.get(startNode)) {
        if(vis[neighbour] == 0) {
            if(isCyclic(neighbour, vis, pathVis, adj)) return true;
        } else if(pathVis[neighbour] == 1) return true;
      }

      pathVis[startNode] = 0;
      return false;
    }

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

        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == 0) {
                if (isCyclic(i, vis, pathVis, adj)) return false;
            }
        }

        return true;

    }
}
