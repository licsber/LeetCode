import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        int[][] res = new int[intervals.length][2];
        int now = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            if (left > end) {
                res[now][0] = start;
                res[now][1] = end;
                start = left;
                ++now;
            }
            start = Math.min(start, left);
            end = Math.max(end, right);
        }
        res[now][0] = start;
        res[now][1] = end;

        return Arrays.copyOf(res, now + 1);
    }
}
