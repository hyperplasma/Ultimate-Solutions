package GraphAndSearch.BinaryTree;

/**
 * 最近公共祖先（LCA）
 */
public class LowestCommonAncestor {
    /**
     * 递归解法
     */
    public static TreeNode lca(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode l = lca(root.left, p, q);
        TreeNode r = lca(root.right, p, q);
        if (l != null && r != null) {
            return root;
        }
        if (l != null) {
            return l;
        }
        return r;
    }
}
