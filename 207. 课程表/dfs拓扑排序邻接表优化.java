import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> courses;
    private boolean[] vis;
    private int cur;
    private int[] labels;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        courses = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            courses.add(new ArrayList<>());
        }
        vis = new boolean[numCourses];
        cur = numCourses;
        labels = new int[numCourses];

        for (int[] i : prerequisites) {
            courses.get(i[0]).add(i[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                dfs(i);
            }
        }

        for (int i = 0; i < numCourses; i++) {
            for (int j : courses.get(i)) {
                if (labels[i] > labels[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void dfs(int vertex) {
        vis[vertex] = true;
        for (int i : courses.get(vertex)) {
            if (!vis[i]) {
                dfs(i);
            }
        }
        labels[vertex] = cur--;
    }
}
