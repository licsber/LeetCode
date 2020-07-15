import java.util.Arrays;

// 类似题目：64.最小路径和
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;

        // 到达(i, j)格需要的最小生命值
        int[][] dp = new int[row + 1][col + 1];
        for (int[] i : dp) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        // 终点的下、右到达的最小生命值为1
        dp[row][col - 1] = dp[row - 1][col] = 1;

        // 反向dp 从出口到入口
        for (int i = row - 1; i >= 0; --i) {
            for (int j = col - 1; j >= 0; --j) {
                // 只允许往下、右
                int min = Math.min(dp[i][j + 1], dp[i + 1][j]);
                // 保证存活（至少剩下1生命值）
                dp[i][j] = Math.max(min - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }
}
