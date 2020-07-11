import java.util.*;

class Solution {
    private int[] index;
    private int[] count;

    public List<Integer> countSmaller(int[] nums) {
        init(nums);
        List<Integer> res = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            int id = getId(nums[i]);
            res.add(query(id - 1));
            update(id);
        }
        Collections.reverse(res);
        return res;
    }

    private int getId(int x) {
        return Arrays.binarySearch(index, x) + 1;
    }

    private void update(int pos) {
        int res = 0;
        while (pos < count.length) {
            count[pos] += 1;
            pos += lowBit(pos);
        }
    }

    private int query(int pos) {
        int res = 0;
        while (pos > 0) {
            res += count[pos];
            pos -= lowBit(pos);
        }
        return res;
    }

    private void init(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        index = new int[set.size()];
        int i = 0;
        for (int num : set) {
            index[i++] = num;
        }
        Arrays.sort(index);

        count = new int[nums.length];
    }

    private static int lowBit(int x) {
        return x & -x;
    }
}
