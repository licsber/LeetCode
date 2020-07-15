class Solution {
    private final long[] count = new long[100050];
    private final long mod = (long) 1e9 + 7;

    public int numSub(String s) {
        int res = 0;
        int count = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if (ch == '1') {
                ++count;
            } else {
                res += cal(count);
                res %= mod;
                count = 0;
            }
        }
        res += cal(count);
        res %= mod;
        return res;
    }

    private long cal(int num) {
        if (count[num] != 0) {
            return count[num];
        }
        long res = (num * (num + 1L)) / 2;
        return count[num] = res % mod;
    }
}
