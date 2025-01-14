package GraphAndSearch.BinaryTree;

/**
 * 平衡二叉树（BST）
 */
public class BinarySearchTree {
    /**
     * 验证BST
     */
    public static boolean isValidBST(TreeNode root) {
        // return checkBSTPreorder(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

        return checkBSTInorder(root, new int[]{Integer.MAX_VALUE});
    }

    /**
     * 先序遍历验证BST
     */
    private static boolean checkBSTPreorder(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }
        return root.val > min && root.val < max
                && checkBSTPreorder(root.left, min, root.val)
                && checkBSTPreorder(root.right, root.val, max);
    }

    /**
     * 中序遍历验证BST
     */
    private static boolean checkBSTInorder(TreeNode root, int[] pre) {
        if (root == null) {
            return true;
        }
        if (!checkBSTInorder(root.left, pre)) {
            return false;
        }
        if (root.val <= pre[0]) {
            return false;
        }
        pre[0] = root.val;
        return checkBSTInorder(root.right, pre);
    }
}
