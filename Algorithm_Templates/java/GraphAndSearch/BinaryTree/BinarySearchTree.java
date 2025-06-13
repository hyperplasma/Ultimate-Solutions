package GraphAndSearch.BinaryTree;

/**
 * 二叉搜索树（BST）
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

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(isValidBST(root1));
        TreeNode root2 = new TreeNode(4, new TreeNode(2, new TreeNode(1), new TreeNode(3)), new TreeNode(5));
        System.out.println(isValidBST(root2));
    }
}
