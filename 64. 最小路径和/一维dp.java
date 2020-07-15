// 类似题目：174.地下城游戏
class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        // 只记录当前行即可
        int[] dp = new int[col];
        System.arraycopy(grid[0], 0, dp, 0, col);
        for (int i = 1; i < col; i++) {
            dp[i] += dp[i - 1];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j == 0) {
                    dp[j] += grid[i][j];
                } else {
                    int min = Math.min(dp[j], dp[j - 1]);
                    dp[j] = min + grid[i][j];
                }
            }
        }
        return dp[col - 1];
    }
}
