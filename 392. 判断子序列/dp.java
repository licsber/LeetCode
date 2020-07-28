class Solution {
    // s是子串 t是目标串
    public boolean isSubsequence(String s, String t) {
        int sl = s.length(), tl = t.length();

        int[][] dp = new int[tl + 1][26];
        for (int i = 0; i < 26; i++) {
            dp[tl][i] = tl;
        }

        for (int i = tl - 1; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                if (t.charAt(i) == j + 'a')
                    dp[i][j] = i;
                else
                    dp[i][j] = dp[i + 1][j];
            }
        }

        int index = 0;
        for (int i = 0; i < sl; i++) {
            if (dp[index][s.charAt(i) - 'a'] == tl) {
                return false;
            }
            index = dp[index][s.charAt(i) - 'a'] + 1;
        }
        return true;
    }
}
