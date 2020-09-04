class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = 1; i <= len / 2; i++) {
            if (len % i != 0) {
                continue;
            }

            int num = len / i;
            String sub = s.substring(0, i);
            boolean flag = true;
            for (int j = 1; j < num; j++) {
                String now = s.substring(i * j, i * (j + 1));
                if (!sub.equals(now)) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                return true;
            }
        }

        return false;
    }
}
