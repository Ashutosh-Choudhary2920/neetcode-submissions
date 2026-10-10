class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    private void bfs(int row, int col, int[][] vis, char[][] grid) {
        Queue<Pair> q = new LinkedList<>();
        vis[row][col] = 1;

        int n = grid.length;
        int m = grid[0].length;

        q.add(new Pair(row, col));

        int[] delRow = {0, -1, 0, 1};
        int[] delCol = {1, 0, -1, 0};

        while(!q.isEmpty()) {
            Pair p = q.poll();
            int r = p.row;
            int c = p.col;

            for(int i=0; i<4; i++) {
                int nr = r + delRow[i];
                int nc = c + delCol[i];

                if(nr >= 0 && nr < n && nc >=0 && nc < m && grid[nr][nc] == '1' && vis[nr][nc] != 1) {
                    vis[nr][nc] = 1;
                    q.add(new Pair(nr, nc));
                }
            }
        }
        
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        
        int count = 0;
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == '1' && vis[i][j] != 1) {
                    bfs(i, j, vis, grid);
                    count++;
                }
            }
        }

        return count;
    }
}
