class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return maxDepth(root, 1);
    }

    private int maxDepth(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }

        int left = maxDepth(node.left, depth + 1);
        int right = maxDepth(node.right, depth + 1);

        return Math.max(left, right);
    }
}
