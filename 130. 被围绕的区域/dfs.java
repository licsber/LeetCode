import java.util.Arrays;

class Solution {
    private final int[][] dirs = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    private char[][] copy;

    public void solve(char[][] board) {
        if (board == null || board.length == 0 || board[0].length == 0) {
            return;
        }

        int m = board.length;
        int n = board[0].length;

        copy = new char[m][n];
        for (int i = 0; i < m; i++) {
            System.arraycopy(board[i], 0, copy[i], 0, n);
        }

        for (char[] i : board) {
            Arrays.fill(i, 'X');
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0 || i == m - 1 || j == n - 1) {
                    if (copy[i][j] == 'O') {
                        dfs(i, j, board);
                    }
                }
            }
        }
    }

    private void dfs(int x, int y, char[][] board) {
        board[x][y] = 'O';
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (inArea(nx, ny) && copy[nx][ny] == 'O' && board[nx][ny] != 'O') {
                dfs(nx, ny, board);
            }
        }
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && y >= 0 && x < copy.length && y < copy[0].length;
    }
}
