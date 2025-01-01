package LC1367_LinkedListInBinaryTree;

/**
 * <a href="https://leetcode.cn/problems/linked-list-in-binary-tree/">LinkedList in Binary Tree</a>
 */
public class LinkedListInBinaryTree {
    public static void main(String[] args) {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(8)));
        TreeNode root = new TreeNode(1, new TreeNode(4, new TreeNode(4, new TreeNode(2), new TreeNode(6)), new TreeNode(8)), new TreeNode(1, new TreeNode(1), null));
        Solution solution = new Solution();
        System.out.println(solution.isSubPath(head, root));
    }
}

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