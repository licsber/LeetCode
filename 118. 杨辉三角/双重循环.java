import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        if (numRows < 1) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>());
        res.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> last = res.get(i - 1);

            List<Integer> row = new ArrayList<>();
            row.add(1);

            for (int j = 2; j <= i; j++) {
                row.add(last.get(j - 2) + last.get(j - 1));
            }

            row.add(1);
            res.add(row);
        }
        return res;
    }
}
