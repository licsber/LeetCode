import java.util.Arrays;

class Solution {
    public int splitArray(int[] nums, int m) {
        int n = nums.length;
        // dp[i][j] 是 前i个数 分割成j段 的和 的最小值
        int[][] dp = new int[n + 1][m + 1];
        for (int[] i : dp) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }

        // sub[i] 是 前i个数的和 即 下标区间[0, i) 的和
        // sub[b] - sub[a] 是 下标区间[a, b) 的和
        // 即 第a+1个数 到 第b个数 的和
        int[] sub = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sub[i + 1] = sub[i] + nums[i];
        }

        // j = 1 时 唯一可能是 前i个数 被分成了 1段
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            // i >= j 才是有效区间
            // 前 i 个数最多被分为 m 个区间
            // 所以 j 只用遍历到 i 和 m 的最小值
            for (int j = 1; j <= Math.min(i, m); j++) {
                // 假如要把 前i个数 分成 j 段
                // k 作为 前j-1段 和 第j段 的分界点
                // 前k个数 被分成 前j-1段
                // 第j段 至少要有一个元素 k < i
                for (int k = 0; k < i; k++) {
                    // 分割之后 前j-1段 就只有 k 个元素
                    // 需要 (前k个数 分割成 j-1段 的和 的最小值) 与 (第j段 的和) 取最大值
                    // 作为 这j段中 和的最大值
                    // 第j段 的和就是 第k+1个数 到 第i个数 的和
                    int max = Math.max(dp[k][j - 1], sub[i] - sub[k]);
                    dp[i][j] = Math.min(dp[i][j], max);
                }
            }
        }
        return dp[n][m];
    }
}
