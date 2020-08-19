class Solution {
    public int countSubstrings(String s) {
        int res = 0;
        char[] chs = s.toCharArray();

        // dp[i][j]: s[i:j]是回文串
        boolean[][] dp = new boolean[chs.length][chs.length];
        for (int i = 0; i < chs.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (i == j) {
                    dp[j][i] = true;
                    ++res;
                } else if (i == j + 1 && chs[i] == chs[j]) {
                    dp[j][i] = true;
                    ++res;
                } else if (dp[j + 1][i - 1] && chs[i] == chs[j]) {
                    dp[j][i] = true;
                    ++res;
                }
            }
        }

        return res;
    }
}
