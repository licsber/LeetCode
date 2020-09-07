import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

class Solution {
    private static class Counter implements Comparable<Counter> {
        private int num;
        private int time;

        @Override
        public int compareTo(Counter counter) {
            return counter.time - time;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.merge(i, 1, Integer::sum);
        }

        int size = map.size();
        Counter[] counters = new Counter[size];

        int index = 0;
        for (int i : map.keySet()) {
            counters[index] = new Counter();
            counters[index].num = i;
            counters[index++].time = map.get(i);
        }

        Arrays.sort(counters);

        for (int i = 0; i < k; i++) {
            res[i] = counters[i].num;
        }

        return res;
    }
}
