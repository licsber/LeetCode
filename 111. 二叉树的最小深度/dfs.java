class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if (root.left == null || root.right == null) {
            // 只要有一个为空 那么left和right就有一个是0
            return left + right + 1;
        } else {
            return Math.min(left, right) + 1;
        }
    }
}
