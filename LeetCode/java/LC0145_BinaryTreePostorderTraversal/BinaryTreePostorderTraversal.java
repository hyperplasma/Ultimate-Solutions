package LC0145_BinaryTreePostorderTraversal;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/">Binary Tree Postorder Traversal</a>
 * 栈；树；深度优先搜索；二叉树
 */
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        Solution solution = new Solution();
        List<Integer> list = solution.postorderTraversal(root);
        System.out.println(list);
    }
}

class Solution {
    public void dfs(List<Integer> list, TreeNode root) {
        if (root != null) {
            dfs(list, root.left);
            dfs(list, root.right);
            list.add(root.val);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(list, root);
        return list;
    }
}