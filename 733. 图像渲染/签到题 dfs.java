class Solution {
    private final int[][] dirs = {
            {0, -1},
            {0, 1},
            {1, 0},
            {-1, 0}
    };

    private int color;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image == null || image.length == 0) {
            return image;
        }

        color = image[sr][sc];
        if (color == newColor) {
            return image;
        }

        dfs(image, sr, sc, newColor);
        return image;
    }

    private void dfs(int[][] m, int x, int y, int newColor) {
        m[x][y] = newColor;
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (inArea(m, nx, ny) && m[nx][ny] == color) {
                dfs(m, nx, ny, newColor);
            }
        }
    }

    private boolean inArea(int[][] m, int x, int y) {
        return x >= 0 && y >= 0 && x < m.length && y < m[0].length;
    }
}
