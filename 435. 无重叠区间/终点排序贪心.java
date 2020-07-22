import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[1]));
        int prev = 0;
        int res = 0;
        for (int i = 1; i < intervals.length; i++) {
            // 从上一个的终点向下划线 被划到的全取消
            if (intervals[prev][1] > intervals[i][0]) {
                ++res;
            } else {
                prev = i;
            }
        }
        return res;
    }
}
