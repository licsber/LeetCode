import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.merge(i, 1, Integer::sum);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int i : map.keySet()) {
            int count = map.get(i);

            if (pq.size() < k) {
                pq.add(i);
            } else {
                int top = map.get(pq.peek());
                if (top < count) {
                    pq.remove();
                    pq.add(i);
                }
            }
        }

        for (int i = 0; i < k; ++i) {
            res[i] = pq.remove();
        }
        return res;
    }
}
