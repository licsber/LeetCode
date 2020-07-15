import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class Solution {
    private int[] counts;

    public int reversePairs(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for (int i : nums) {
            set.add(i);
        }
        int size = set.size();

        Map<Integer, Integer> map = new HashMap<>(size);
        int index = 1;
        for (int i : set) {
            map.put(i, index++);
        }

        counts = new int[size];
        int res = 0;
        for (int i = nums.length - 1; i >= 0; --i) {
            int id = map.get(nums[i]);
            update(id);
            res += query(id - 1);
        }

        return res;
    }

    private void update(int pos) {
        while (pos < counts.length) {
            ++counts[pos];
            pos += lowBit(pos);
        }
    }

    private int query(int pos) {
        int res = 0;
        while (pos > 0) {
            res += counts[pos];
            pos -= lowBit(pos);
        }
        return res;
    }

    private int lowBit(int x) {
        return x & -x;
    }
}
