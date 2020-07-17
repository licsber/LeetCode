import java.util.BitSet;

class Solution {
    public int[][] merge(int[][] intervals) {
        BitSet bitSet = new BitSet();

        int max = 0;
        for (int[] interval : intervals) {
            // 不乘2 解决不了[0, 0]这样的点
            int left = interval[0] * 2;
            int right = interval[1] * 2 + 1;
            bitSet.set(left, right, true);
            max = Math.max(right, max);
        }

        int index = 0, count = 0;
        while (index < max) {
            int start = bitSet.nextSetBit(index);
            int end = bitSet.nextClearBit(start);

            int[] item = {start / 2, (end - 1) / 2};
            intervals[count++] = item;

            index = end;
        }
        int[][] ret = new int[count][2];
        System.arraycopy(intervals, 0, ret, 0, count);

        return ret;
    }
}
