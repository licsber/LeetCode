class Solution {
    private int[][] courses;
    private boolean[] vis;
    private int cur;
    private int[] labels;

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        courses = new int[numCourses][numCourses];
        vis = new boolean[numCourses];
        cur = numCourses;
        labels = new int[numCourses];

        for (int[] i : prerequisites) {
            courses[i[0]][i[1]] = 1;
        }

        for (int i = 0; i < courses.length; i++) {
            if (!vis[i]) {
                dfs(i);
            }
        }

        for (int i = 0; i < courses.length; i++) {
            for (int j = 0; j < courses[i].length; j++) {
                if (courses[i][j] == 1 && labels[i] > labels[j]) {
                    return false;
                }
            }
        }
        return true;
    }

    private void dfs(int vertex) {
        vis[vertex] = true;
        for (int i = 0; i < courses[vertex].length; i++) {
            if (courses[vertex][i] == 1 && !vis[i]) {
                dfs(i);
            }
        }
        labels[vertex] = cur--;
    }
}
