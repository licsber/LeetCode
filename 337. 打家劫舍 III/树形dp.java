class Solution {
    public int rob(TreeNode root) {
        int[] ans = dfs(root);
        return Math.max(ans[0], ans[1]);
    }

    // 数组0为选择这个节点 1为不选择这个节点的结果
    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        // 后序遍历 只有左右都被遍历完才能确定当前值
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);

        // 选这个节点的话 需要加上不选左右子树的结果
        int sel = node.val + l[1] + r[1];
        // 不选这个节点 需要加上左右子树的最大值
        int not = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{sel, not};
    }
}
