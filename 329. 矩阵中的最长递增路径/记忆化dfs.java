class Solution {
    private final int[][] dirs = {
            {0, -1},
            {0, 1},
            {1, 0},
            {-1, 0}
    };

    private int[][] mem;

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int row = matrix.length;
        int col = matrix[0].length;
        mem = new int[row][col];

        int ans = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }

        return ans;
    }

    private int dfs(int[][] m, int x, int y) {
        if (mem[x][y] != 0) {
            return mem[x][y];
        }

        int ans = 1;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (inArea(m, nx, ny) && m[nx][ny] > m[x][y]) {
                ans = Math.max(ans, dfs(m, nx, ny) + 1);
            }
        }

        return mem[x][y] = ans;
    }

    private boolean inArea(int[][] m, int x, int y) {
        return x >= 0 && y >= 0 && x < m.length && y < m[0].length;
    }
}
