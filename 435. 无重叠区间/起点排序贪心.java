import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int prev = 0;
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[prev][1] > intervals[i][0]) {
                // 有重叠 判断是包含还是超过
                if (intervals[prev][1] > intervals[i][1]) {
                    // 包含 保留小的
                    prev = i;
                }
                // 包含 删掉大的
                // 超过 贪心地删掉远处的
                ++res;
            } else {
                // 不重叠 直接跳过
                prev = i;
            }
        }
        return res;
    }
}
