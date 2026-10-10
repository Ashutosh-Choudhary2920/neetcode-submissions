class Solution {
    private void dfs(int row, int col, char[][] board, int[][] vis) {
        vis[row][col] = 1;
        int n = board.length;
        int m = board[0].length;

        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};

        for(int i=0; i<4; i++) {
            int neighborRow = row + delRow[i];
            int neighborCol = col + delCol[i];

            if(neighborRow >= 0 && neighborRow < n &&
               neighborCol >=0 && neighborCol < m &&
               board[neighborRow][neighborCol] == 'O' &&
               vis[neighborRow][neighborCol] == 0) {
                dfs(neighborRow, neighborCol, board, vis);
               }
        }
    }

    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] vis = new int[n][m];

        for(int i=0; i<n; i++) {
            if(board[i][0] == 'O' && vis[i][0] == 0) {
                dfs(i, 0, board, vis);
            }
            if(board[i][m-1] == 'O' && vis[i][m-1] == 0) {
                dfs(i, m-1, board, vis);
            }
        }

        for(int j=0; j<m; j++) {
            if(board[0][j] == 'O' && vis[0][j] == 0) {
                dfs(0, j, board, vis);
            }
            if(board[n-1][j] == 'O' && vis[n-1][j] == 0) {
                dfs(n-1, j, board, vis);
            }
        } 

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(board[i][j] == 'O' && vis[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
