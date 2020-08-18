class Solution {
    private ListNode now;

    public TreeNode sortedListToBST(ListNode head) {
        now = head;
        return build(0, len(head) - 1);
    }

    private TreeNode build(int left, int right) {
        if (left > right) {
            return null;
        }

        int mid = left + (right - left + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = build(left, mid - 1);

        root.val = now.val;
        now = now.next;

        root.right = build(mid + 1, right);

        return root;
    }

    private int len(ListNode head) {
        int res = 0;
        ListNode tmp = head;
        while (tmp != null) {
            ++res;
            tmp = tmp.next;
        }
        return res;
    }
}
