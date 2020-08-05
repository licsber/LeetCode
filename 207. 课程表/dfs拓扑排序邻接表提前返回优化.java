import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> courses;
    private int[] vis;
    private boolean res = true;
    private static final int UNVISITED = 0;
    private static final int VISITING = 1;
    private static final int VISITED = 2;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        courses = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }
        vis = new int[numCourses];

        for (int[] i : prerequisites) {
            courses.get(i[0]).add(i[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (vis[i] == UNVISITED) {
                dfs(i);
            }
        }

        return res;
    }

    private void dfs(int vertex) {
        vis[vertex] = VISITING;
        for (int i : courses.get(vertex)) {
            if (vis[i] == UNVISITED) {
                dfs(i);
                if (!res) {
                    return;
                }
            } else if (vis[i] == VISITING) {
                res = false;
            }
        }
        vis[vertex] = VISITED;
    }
}
