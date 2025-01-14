package GraphAndSearch.BinaryTree;

import java.util.HashMap;
import java.util.Map;

/**
 * 构建二叉树
 */
public class BuildTree {
    private static Map<Integer, Integer> in2Idx;     // 中序数组的值 -> 索引

    /**
     * 根据前序和中序序列建立二叉树
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        in2Idx = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            in2Idx.put(inorder[i], i);
        }
        return dfs(preorder, inorder, 0, 0, inorder.length - 1);
    }

    /**
     * DFS递归建树
     */
    private static TreeNode dfs(int[] preorder, int[] inorder, int preIdx, int inStart, int inEnd) {
        if (inStart > inEnd || preIdx > preorder.length - 1) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preIdx]);
        int inIdx = in2Idx.get(preorder[preIdx]);
        root.left = dfs(preorder, inorder, preIdx + 1, inStart, inIdx - 1);
        root.right = dfs(preorder, inorder, preIdx + inIdx - inStart + 1, inIdx + 1, inEnd);
        return root;
    }
}
