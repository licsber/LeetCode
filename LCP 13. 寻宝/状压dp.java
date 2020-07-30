import java.util.*;

// 不会做
class Solution {
    int[][] dirs = {
            {-1, 0},
            {0, -1},
            {0, 1},
            {1, 0}
    };

    int row;
    int col;

    public int minimalSteps(String[] maze) {
        row = maze.length;
        col = maze[0].length();

        List<int[]> buttons = new ArrayList<>();
        List<int[]> stones = new ArrayList<>();

        int sx = -1, sy = -1, tx = -1, ty = -1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                switch (maze[i].charAt(j)) {
                    case 'M': {
                        buttons.add(new int[]{i, j});
                        break;
                    }
                    case 'O': {
                        stones.add(new int[]{i, j});
                        break;
                    }
                    case 'S': {
                        sx = i;
                        sy = j;
                        break;
                    }
                    case 'T': {
                        tx = i;
                        ty = j;
                        break;
                    }
                }
            }
        }

        int nb = buttons.size();
        int[][] startDist = bfs(sx, sy, maze);

        if (nb == 0) {
            return startDist[tx][ty];
        }

        int[][] dist = new int[nb][nb + 2];
        for (int i = 0; i < nb; i++) {
            Arrays.fill(dist[i], -1);
        }

        int[][][] dd = new int[nb][][];
        for (int i = 0; i < nb; i++) {
            int[][] d = bfs(buttons.get(i)[0], buttons.get(i)[1], maze);
            dd[i] = d;
            dist[i][nb + 1] = d[tx][ty];
        }

        for (int i = 0; i < nb; i++) {
            int tmp = -1;
            for (int[] stone : stones) {
                int midX = stone[0], midY = stone[1];
                if (dd[i][midX][midY] != -1 && startDist[midX][midY] != -1) {
                    if (tmp == -1 || tmp > dd[i][midX][midY] + startDist[midX][midY]) {
                        tmp = dd[i][midX][midY] + startDist[midX][midY];
                    }
                }
            }
            dist[i][nb] = tmp;
            for (int j = i + 1; j < nb; j++) {
                int mn = -1;
                for (int[] stone : stones) {
                    int midX = stone[0], midY = stone[1];
                    if (dd[i][midX][midY] != -1 && dd[j][midX][midY] != -1) {
                        if (mn == -1 || mn > dd[i][midX][midY] + dd[j][midX][midY]) {
                            mn = dd[i][midX][midY] + dd[j][midX][midY];
                        }
                    }
                }
                dist[i][j] = mn;
                dist[j][i] = mn;
            }
        }

        for (int i = 0; i < nb; i++) {
            if (dist[i][nb] == -1 || dist[i][nb + 1] == -1) {
                return -1;
            }
        }

        int[][] dp = new int[1 << nb][nb];
        for (int i = 0; i < 1 << nb; i++) {
            Arrays.fill(dp[i], -1);
        }
        for (int i = 0; i < nb; i++) {
            dp[1 << i][i] = dist[i][nb];
        }

        for (int mask = 1; mask < (1 << nb); mask++) {
            for (int i = 0; i < nb; i++) {
                if ((mask & (1 << i)) != 0) {
                    for (int j = 0; j < nb; j++) {
                        if ((mask & (1 << j)) == 0) {
                            int next = mask | (1 << j);
                            if (dp[next][j] == -1 || dp[next][j] > dp[mask][i] + dist[i][j]) {
                                dp[next][j] = dp[mask][i] + dist[i][j];
                            }
                        }
                    }
                }
            }
        }

        int ret = -1;
        int finalMask = (1 << nb) - 1;
        for (int i = 0; i < nb; i++) {
            if (ret == -1 || ret > dp[finalMask][i] + dist[i][nb + 1]) {
                ret = dp[finalMask][i] + dist[i][nb + 1];
            }
        }

        return ret;
    }

    public int[][] bfs(int x, int y, String[] maze) {
        int[][] ret = new int[row][col];
        for (int i = 0; i < row; i++) {
            Arrays.fill(ret[i], -1);
        }
        ret[x][y] = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int curx = p[0], cury = p[1];
            for (int[] dir : dirs) {
                int nx = curx + dir[0];
                int ny = cury + dir[1];
                if (inBound(nx, ny) && ret[nx][ny] == -1 && maze[nx].charAt(ny) != '#') {
                    ret[nx][ny] = ret[curx][cury] + 1;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        return ret;
    }

    public boolean inBound(int x, int y) {
        return x >= 0 && y >= 0 && x < row && y < col;
    }
}
