import java.util.ArrayList;
import java.util.List;

class Solution {
    private List<List<Integer>> lists;
    private int[] colors;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        colors = new int[N];

        lists = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            lists.add(new ArrayList<>());
        }

        for (int[] dislike : dislikes) {
            lists.get(dislike[0] - 1).add(dislike[1] - 1);
            lists.get(dislike[1] - 1).add(dislike[0] - 1);
        }

        for (int i = 0; i < N; i++) {
            if (colors[i] == 0) {
                if (dfs(i, 1)) {
                    return false;
                }
            }
        }
        return true;
    }

    // from是否不能染这个色
    private boolean dfs(int from, int color) {
        colors[from] = color;
        for (int i : lists.get(from)) {
            if (colors[i] == color) {
                return true;
            } else if (colors[i] == 0) {
                if (dfs(i, -color)) {
                    return true;
                }
            }
        }
        return false;
    }
}
