import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static final int[][] dir = {
            {1, 0},
            {1, 1},
            {0, 1},
            {-1, 1},
            {-1, 0},
            {-1, -1},
            {0, -1},
            {1, -1}
    };

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0 || grid[0][0] == 1) {
            return -1;
        }

        int row = grid.length;
        int col = grid[0].length;
        if (row == 1 && col == 1) {
            return 1;
        }

        boolean[][] vis = new boolean[row][col];
        Queue<Integer> queue = new LinkedList<>();

        vis[0][0] = true;
        queue.add(0);

        int r, c;
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                Integer pos = queue.poll();
                assert pos != null;
                r = pos / col;
                c = pos % col;

                if (r == row - 1 && c == col - 1) {
                    return res + 1;
                }

                for (int[] i : dir) {
                    int nr = r + i[0];
                    int nc = c + i[1];

                    if (inArea(nr, nc, grid) && !vis[nr][nc] && grid[nr][nc] != 1) {
                        vis[nr][nc] = true;
                        queue.add(nr * col + nc);
                    }
                }
            }
            ++res;
        }
        return -1;
    }

    private static boolean inArea(int row, int col, int[][] grid) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length;
    }
}
