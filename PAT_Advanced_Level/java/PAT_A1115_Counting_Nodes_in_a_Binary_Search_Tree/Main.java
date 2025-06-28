package PAT_A1115_Counting_Nodes_in_a_Binary_Search_Tree;

import java.util.Scanner;

public class Main {
    static TreeNode root;
    static int n1 = 0, n2 = 0, bottom = 0;

    static void insert(int x) {
        TreeNode newNode = new TreeNode(x);
        if (root == null) {
            root = newNode;
            root.depth = 1;
            bottom = 1;
        } else {
            TreeNode current = root;
            TreeNode parent = null;
            while (current != null) {
                parent = current;
                if (x <= current.val) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            newNode.depth = parent.depth + 1;
            bottom = Math.max(bottom, newNode.depth);
            if (x <= parent.val) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }
    }

    static void dfs(TreeNode node) {
        if (node != null) {
            if (node.depth == bottom) {
                n1++;
            } else if (node.depth == bottom - 1) {
                n2++;
            }
            dfs(node.left);
            dfs(node.right);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        root = null;
        n1 = 0;
        n2 = 0;
        bottom = 0;

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            insert(x);
        }

        dfs(root);
        System.out.printf("%d + %d = %d\n", n1, n2, n1 + n2);
        scanner.close();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    int depth;

    TreeNode(int val) {
        this.val = val;
    }
}
