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
        int[][] path = new int[row][col];
        Queue<Integer> queue = new LinkedList<>();

        vis[0][0] = true;
        path[0][0] = 1;
        queue.add(0);

        int r, c;
        while (!queue.isEmpty()) {
            int pos = queue.poll();
            r = pos / col;
            c = pos % col;

            for (int[] i : dir) {
                int nr = r + i[0];
                int nc = c + i[1];

                if (inArea(nr, nc, grid) && !vis[nr][nc] && grid[nr][nc] != 1) {
                    path[nr][nc] = path[r][c] + 1;
                    if (nr == row - 1 && nc == col - 1) {
                        return path[nr][nc];
                    }
                    vis[nr][nc] = true;
                    queue.add(nr * col + nc);
                }
            }
        }
        return -1;
    }

    private static boolean inArea(int row, int col, int[][] grid) {
        return row >= 0 && col >= 0 && row < grid.length && col < grid[0].length;
    }
}
