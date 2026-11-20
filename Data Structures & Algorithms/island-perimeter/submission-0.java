class Pair {
    int row;
    int col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}

class Solution {
    private int bfs(int row, int col, int[][] grid, int[][] vis, int perimeter) {
        int n = grid.length;
        int m = grid[0].length;

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        Queue<Pair> q = new LinkedList<>();

        q.add(new Pair(row, col));
        vis[row][col] = 1;

        while(!q.isEmpty()) {
            Pair node = q.poll();

            int nodeRow = node.row;
            int nodeCol = node.col;

            for(int i=0; i<4; i++) {
                int neighbourRow = nodeRow + dr[i];
                int neighbourCol = nodeCol + dc[i];

                if(neighbourRow < 0 || neighbourRow >= n) {
                    perimeter++;
                }
                if(neighbourCol < 0 || neighbourCol >= m) {
                    perimeter++;
                }

                if(neighbourRow >=0 && neighbourRow < n &&
                   neighbourCol >=0 && neighbourCol < m) {
                    if(grid[neighbourRow][neighbourCol] == 0) {
                        perimeter++;
                    }

                    if(grid[neighbourRow][neighbourCol] == 1 && vis[neighbourRow][neighbourCol] != 1) {
                        vis[neighbourRow][neighbourCol] = 1;
                        q.add(new Pair(neighbourRow, neighbourCol));
                    }
                }
            }

        }
        
        return perimeter;

    }

    public int islandPerimeter(int[][] grid) {

        int perimeter = 0;

        int n = grid.length;
        int m = grid[0].length;

        int[][] vis = new int[n][m];


        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(grid[i][j] == 1 && vis[i][j] != 1) {
                    perimeter += bfs(i, j, grid, vis, perimeter);
                }
            }
        }

        return perimeter;

    }
}