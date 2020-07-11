import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0, now = 0;
        Set<Character> set = new HashSet<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            while (set.contains(ch)) {
                set.remove(s.charAt(now++));
            }
            res = Math.max(res, i - now + 1);
            set.add(ch);
        }
        return res;
    }
}
