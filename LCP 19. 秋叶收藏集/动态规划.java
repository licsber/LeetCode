class Solution {
    public int minimumOperations(String leaves) {
        int len = leaves.length();

        int[][] dp = new int[len][3];
        dp[0][0] = isYellow(leaves.charAt(0));
        dp[0][1] = dp[0][2] = dp[1][2] = Integer.MAX_VALUE;

        for (int i = 1; i < len; i++) {
            char ch = leaves.charAt(i);
            dp[i][0] = dp[i - 1][0] + isYellow(ch);
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][1]) + isRed(ch);
            if (i >= 2) {
                dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][2]) + isYellow(ch);
            }
        }
        return dp[len - 1][2];
    }

    private int isYellow(char ch) {
        return ch == 'y' ? 1 : 0;
    }

    private int isRed(char ch) {
        return ch == 'r' ? 1 : 0;
    }
}
