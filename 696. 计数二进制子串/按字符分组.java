class Solution {
    public int countBinarySubstrings(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }

        int ans = 0;
        char pre = s.charAt(0);
        int count = 1;
        int last = 0;
        int len = s.length();
        for (int i = 1; i < len; i++) {
            char ch = s.charAt(i);
            if (pre == ch) {
                ++count;
            } else {
                ans += Math.min(last, count);
                last = count;
                pre = ch;
                count = 1;
            }
        }
        ans += Math.min(last, count);
        return ans;
    }
}
