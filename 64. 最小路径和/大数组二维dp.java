import java.util.Arrays;

class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid[0].length == 0) {
            return -1;
        }

        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[m], Integer.MAX_VALUE);
        for (int i = 0; i < m - 1; i++) {
            dp[i][n] = Integer.MAX_VALUE;
        }

        for (int i = m - 1; i >= 0; --i) {
            for (int j = n - 1; j >= 0; --j) {
                int min = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = grid[i][j] + min;
            }
        }

        return dp[0][0];
    }
}
