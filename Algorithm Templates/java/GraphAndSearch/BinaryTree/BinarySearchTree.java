package GraphAndSearch.BinaryTree;

/**
 * 平衡二叉树（BST）
 */
public class BinarySearchTree {
    /**
     * 验证BST
     */
    public static boolean isValidBST(TreeNode root) {
        return checkBST(root);
    }

    /**
     * 递归整棵树
     */
    private static boolean checkBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left != null && root.left.val >= root.val) {
            return false;
        }
        if (root.right != null && root.right.val <= root.val) {
            return false;
        }
        return checkBST(root.left) && checkBST(root.right);
    }
}
