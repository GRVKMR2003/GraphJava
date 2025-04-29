class Solution {
    public int numEnclaves(int[][] board) {
        int n = board.length;
        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            if (board[i][0] == 1) dfs(board, i, 0);
            if (board[i][m - 1] == 1) dfs(board, i, m - 1);
        }
        for (int j = 0; j < m; j++) {
            if (board[0][j] == 1) dfs(board, 0, j);
            if (board[n - 1][j] == 1) dfs(board, n - 1, j);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 1) count++;
            }
        }

        return count;
    }

    public void dfs(int[][] board, int r, int c) {
        int n = board.length;
        int m = board[0].length;

        if (r < 0 || c < 0 || r >= n || c >= m || board[r][c] != 1) return;

        board[r][c] = 0;  

        int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        for (int[] d : dir) {
            dfs(board, r + d[0], c + d[1]);
        }
    }
}
