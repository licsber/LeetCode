import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        // 到达底部每个点的最小路径和
        int[] dp = new int[len + 1];

        for (int i = len - 1; i >= 0; --i) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
}
