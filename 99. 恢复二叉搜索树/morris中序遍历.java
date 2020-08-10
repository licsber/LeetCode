import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode pre = null;
        Deque<TreeNode> reverse = new ArrayDeque<>();

        TreeNode now = root;
        TreeNode mr;
        while (now != null) {
            mr = now.left;
            if (mr != null) {
                while (mr.right != null && mr.right != now) {
                    mr = mr.right;
                }
                if (mr.right == null) {
                    mr.right = now;
                    now = now.left;
                    continue;
                } else {
                    mr.right = null;
                }
            }
            if (pre != null && pre.val > now.val) {
                reverse.offer(pre);
                reverse.offer(now);
            }
            pre = now;
            now = now.right;
        }

        TreeNode a = reverse.pollFirst();
        TreeNode b = reverse.pollLast();

        if (a != null && b != null) {
            swap(a, b);
        }
    }

    private void swap(TreeNode a, TreeNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
}
