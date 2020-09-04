import java.util.LinkedList;
import java.util.List;

class Solution {
    private List<String> res;
    private final LinkedList<TreeNode> tmp = new LinkedList<>();

    private void dfs(TreeNode root) {
        if (root != null) {
            tmp.add(root);
            if (root.left == null && root.right == null) {
                mark();
            }
            dfs(root.left);
            dfs(root.right);
            tmp.removeLast();
        }
    }

    private void mark() {
        StringBuilder builder = new StringBuilder();
        builder.append(tmp.get(0).val);

        int size = tmp.size();
        for (int i = 1; i < size; i++) {
            TreeNode node = tmp.get(i);
            builder.append("->").append(node.val);
        }

        res.add(builder.toString());
    }

    public List<String> binaryTreePaths(TreeNode root) {
        res = new LinkedList<>();
        dfs(root);
        return res;
    }
}
