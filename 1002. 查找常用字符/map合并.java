import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {
    private HashMap<Character, Integer> merge(HashMap<Character, Integer> a,
                                              HashMap<Character, Integer> b) {
        HashMap<Character, Integer> res = new HashMap<>();
        for (char ch : a.keySet()) {
            if (b.containsKey(ch)) {
                res.put(ch, Math.min(a.get(ch), b.get(ch)));
            }
        }
        return res;
    }

    public List<String> commonChars(String[] A) {
        List<String> res = new LinkedList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int len = A[0].length();
        for (int i = 0; i < len; i++) {
            map.merge(A[0].charAt(i), 1, Integer::sum);
        }
        for (int i = 1; i < A.length; i++) {
            HashMap<Character, Integer> tmp = new HashMap<>();
            len = A[i].length();
            for (int j = 0; j < len; j++) {
                tmp.merge(A[i].charAt(j), 1, Integer::sum);
            }
            map = merge(map, tmp);
        }
        for (char ch : map.keySet()) {
            int num = map.get(ch);
            for (int i = 0; i < num; i++) {
                res.add(String.valueOf(ch));
            }
        }
        return res;
    }
}
