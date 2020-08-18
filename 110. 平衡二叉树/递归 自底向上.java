class Solution {
    public boolean isBalanced(TreeNode root) {
        try {
            return height(root) != -1;
        } catch (Exception e) {
            return false;
        }
    }

    // root左右平衡：返回root高度
    // root左右不平衡：返回-1
    private int height(TreeNode root) throws Exception {
        if (root == null) {
            return 0;
        }

        int left = height(root.left);
        int right = height(root.right);
        if (left == -1 || right == -1) {
            throw new Exception();
        } else if (Math.abs(left - right) > 1) {
            throw new Exception();
        } else {
            return Math.max(left, right) + 1;
        }
    }
}
