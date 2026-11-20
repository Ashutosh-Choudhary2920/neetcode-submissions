class Solution {
    private void dfsOfGraph(int startNode, int V, int[] vis, List<List<Integer>> adjList) {
        vis[startNode] = 1;

        for(int neighbour : adjList.get(startNode)) {
            if(vis[neighbour] != 1) {
                dfsOfGraph(neighbour, V, vis, adjList);
            }
        }
    }

    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adjList.add(new ArrayList<>());
        }

        for(int[] pair : edges) {
            int u = pair[0];
            int v = pair[1];

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        int[] vis = new int[n];

        int noOfComponent = 0;

        for(int i=0; i<n; i++) {
            if(vis[i] != 1) {
                // bfsOfGraph(i, V, vis, adjList);
                dfsOfGraph(i, n, vis, adjList);
                noOfComponent++;
            }
        }

        return noOfComponent;


    }
}
