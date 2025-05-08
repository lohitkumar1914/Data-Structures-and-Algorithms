class Solution {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        //for 4-directions
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        
        // Traverse first and last row
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 'O' && vis[0][j] == 0) {
                dfs(0, j, board, vis, delRow, delCol);
            }
            if (board[n - 1][j] == 'O' && vis[n - 1][j] == 0) {
                dfs(n - 1, j, board, vis, delRow, delCol);
            }
        }
        
        // Traverse first and last column
        for (int i = 0; i < n; i++) {
            if (board[i][0] == 'O' && vis[i][0] == 0) {
                dfs(i, 0, board, vis, delRow, delCol);
            }
            if (board[i][m - 1] == 'O' && vis[i][m - 1] == 0) {
                dfs(i, m - 1, board, vis, delRow, delCol);
            }
        }
        
        // Flip unvisited 'O' to 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O' && vis[i][j] == 0) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    private void dfs(int row, int col, char[][] board, int[][] vis, int[] delRow, int[] delCol) {
        vis[row][col] = 1;
        int n = board.length;
        int m = board[0].length;
        
        for (int i = 0; i < 4; i++) {
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m
                && board[nrow][ncol] == 'O' && vis[nrow][ncol] == 0) {
                dfs(nrow, ncol, board, vis, delRow, delCol);
            }
        }
    }
}