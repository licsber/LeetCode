import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            map.merge(i, 1, Integer::sum);
        }
        int[] res = new int[map.size()];
        int index = 0;
        for (int i : nums2) {
            Integer j = map.get(i);
            if (j != null) {
                res[index++] = i;
                if (j == 1) {
                    map.remove(i);
                } else {
                    map.replace(i, j - 1);
                }
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }
}
