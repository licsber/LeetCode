import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> tmp = new ArrayList<>();
            while (size-- > 0) {
                TreeNode now = queue.remove();
                tmp.add(now.val);
                if (now.left != null) {
                    queue.add(now.left);
                }
                if (now.right != null) {
                    queue.add(now.right);
                }
            }
            res.add(0, tmp);
        }

        return res;
    }
}
