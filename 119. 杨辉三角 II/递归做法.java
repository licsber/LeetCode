import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int[][] mem = new int[64][64];

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            res.add(getNum(rowIndex, i));
        }
        return res;
    }

    private int getNum(int row, int col) {
        if (mem[row][col] != 0) {
            return mem[row][col];
        }
        if (col == 0 || col == row) {
            return 1;
        }
        int res = getNum(row - 1, col - 1)
                + getNum(row - 1, col);
        mem[row][col] = res;
        return res;
    }
}
