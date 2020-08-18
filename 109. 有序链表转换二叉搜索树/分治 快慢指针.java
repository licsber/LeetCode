class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        return build(head, null);
    }

    private TreeNode build(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }

        ListNode mid = getMid(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = build(left, mid);
        root.right = build(mid.next, right);
        return root;
    }

    private ListNode getMid(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;

        while (fast != right && fast.next != right) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
}
