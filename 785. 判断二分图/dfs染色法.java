class Solution {
    private int[] colors;

    public boolean isBipartite(int[][] graph) {
        colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (colors[i] == 0) {
                if (!dfs(graph, i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    // 深搜这个无向图 将可达的所有节点染上与之相反的颜色
    // 返回from结点是否可以涂这个颜色
    private boolean dfs(int[][] graph, int from, int color) {
        colors[from] = color;
        for (int i = 0; i < graph[from].length; i++) {
            int to = graph[from][i];
            if (colors[to] == color) {
                return false;
            } else if (colors[to] == 0) {
                if (!dfs(graph, to, -color)) {
                    return false;
                }
            }
        }
        return true;
    }
}
