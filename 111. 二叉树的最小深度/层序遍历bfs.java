import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int minDepth(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) {
            queue.offer(root);
        }

        int height = 0;
        while (!queue.isEmpty()) {
            ++height;
            int size = queue.size();
            while (size-- > 0) {
                TreeNode now = queue.remove();
                if (now.left == null && now.right == null) {
                    return height;
                }
                if (now.left != null) {
                    queue.offer(now.left);
                }
                if (now.right != null) {
                    queue.offer(now.right);
                }
            }
        }

        return height;
    }
}
