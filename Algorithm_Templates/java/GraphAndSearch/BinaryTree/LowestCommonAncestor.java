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

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3, new TreeNode(5, new TreeNode(6), new TreeNode(2, new TreeNode(7), new TreeNode(4))), new TreeNode(1, new TreeNode(0), new TreeNode(8)));
        System.out.println(lca(root, root.left.left, root.left.right).val);
    }
}
