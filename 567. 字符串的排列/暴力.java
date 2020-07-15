import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        int len = s1.length();
        for (int i = 0; i < len; i++) {
            map.merge(s1.charAt(i), 1, Integer::sum);
        }
        len = s2.length();
        int start = 0;
        Map<Character, Integer> tmp = new HashMap<>(map);
        for (int i = 0; i < len; i++) {
            char ch = s2.charAt(i);
            if (!tmp.containsKey(ch)) {
                if (start != 0) {
                    i -= start;
                    tmp = new HashMap<>(map);
                    start = 0;
                }
                continue;
            }
            ++start;
            int count = tmp.get(ch);
            if (count == 1) {
                tmp.remove(ch);
                if (tmp.isEmpty()) {
                    return true;
                }
            } else {
                tmp.put(ch, count - 1);
            }
        }
        return false;
    }
}
