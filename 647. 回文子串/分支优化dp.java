class Solution {
    public int countSubstrings(String s) {
        if (s == null) {
            return 0;
        }

        char[] chs = s.toCharArray();

        // dp[i][j]: s[i:j]是回文串
        int res = chs.length;
        boolean[][] dp = new boolean[chs.length][chs.length];
        for (int i = 0; i < dp.length; i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < chs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (chs[i] == chs[j] && (i == j + 1 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    ++res;
                }
            }
        }

        return res;
    }
}
