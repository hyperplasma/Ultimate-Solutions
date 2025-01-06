package A1143_LowestCommonAncestor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 测试点3、4、5超时
 */
public class Main {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
        }
    }

    static Node root;

    // 插入节点到BST
    static Node insert(Node node, int val) {
        if (node == null) {
            return new Node(val);
        }
        if (val < node.val) {
            node.left = insert(node.left, val);
        } else {
            node.right = insert(node.right, val);
        }
        return node;
    }

    // 查找节点是否存在
    static boolean find(Node node, int val) {
        if (node == null) {
            return false;
        }
        if (node.val == val) {
            return true;
        }
        return val < node.val ? find(node.left, val) : find(node.right, val);
    }

    // 查找LCA
    static Node findLCA(Node node, int u, int v) {
        if (node == null) {
            return null;
        }
        if (node.val == u || node.val == v) {
            return node;
        }

        // 如果u和v分别在左右子树，则当前节点就是LCA
        if ((u < node.val && v >= node.val) || (u >= node.val && v < node.val)) {
            return node;
        }

        // 否则在左子树或右子树中查找
        if (u < node.val) {
            return findLCA(node.left, u, v);
        } else {
            return findLCA(node.right, u, v);
        }
    }

    // 判断是否为祖先
    static boolean isAncestor(Node node, int ancestor, int descendant) {
        if (node == null) {
            return false;
        }
        if (node.val == descendant) {
            return true;
        }

        if (descendant < node.val) {
            return node.val == ancestor ? find(node.left, descendant) : isAncestor(node.left, ancestor, descendant);
        } else {
            return node.val == ancestor ? find(node.right, descendant) : isAncestor(node.right, ancestor, descendant);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int M = Integer.parseInt(firstLine[0]);
        int N = Integer.parseInt(firstLine[1]);

        // 读取先序遍历序列并构建BST
        String[] values = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            root = insert(root, Integer.parseInt(values[i]));
        }

        // 处理查询
        while (M-- > 0) {
            String[] query = br.readLine().split(" ");
            int u = Integer.parseInt(query[0]);
            int v = Integer.parseInt(query[1]);

            boolean hasU = find(root, u);
            boolean hasV = find(root, v);

            if (!hasU && !hasV) {
                System.out.printf("ERROR: %d and %d are not found.\n", u, v);
            } else if (!hasU) {
                System.out.printf("ERROR: %d is not found.\n", u);
            } else if (!hasV) {
                System.out.printf("ERROR: %d is not found.\n", v);
            } else {
                Node lca = findLCA(root, u, v);
                if (lca.val == u && isAncestor(root, u, v)) {
                    System.out.printf("%d is an ancestor of %d.\n", u, v);
                } else if (lca.val == v && isAncestor(root, v, u)) {
                    System.out.printf("%d is an ancestor of %d.\n", v, u);
                } else {
                    System.out.printf("LCA of %d and %d is %d.\n", u, v, lca.val);
                }
            }
        }
    }
}