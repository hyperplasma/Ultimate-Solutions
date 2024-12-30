package LC1367;


class Solution {

    public boolean dfs(ListNode head, TreeNode root) {
        if (head == null) {
            return true;
        }

        if (root == null) {
            return false;
        }

        if (head.val != root.val) {
            return false;
        }
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if (root == null) {
            return false;
        } else {
            return dfs(head, root) || isSubPath(head, root.left) || isSubPath(head, root.right);
        }
    }
}