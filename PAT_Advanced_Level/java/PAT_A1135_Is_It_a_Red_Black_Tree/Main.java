package PAT_A1135_Is_It_a_Red_Black_Tree;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static int blackNum = -1;

    static class TreeNode {
        int color;  // 0红，1黑
        int key;
        TreeNode lChild;
        TreeNode rChild;

        public TreeNode(int color, int key) {
            this.color = color;
            this.key = key;
            this.lChild = null;
            this.rChild = null;
        }
    }

    static TreeNode insert(TreeNode root, int color, int key) {
        if (root == null) {
            root = new TreeNode(color, key);
        } else if (key < root.key) {
            root.lChild = insert(root.lChild, color, key);
        } else if (key > root.key) {
            root.rChild = insert(root.rChild, color, key);
        }
        return root;
    }

    static boolean dfs(TreeNode root, int num) {
        boolean flag = true;
        if (root == null) {
            if (blackNum == -1) {
                blackNum = num;
            } else if (blackNum != num) {
                flag = false;
            }
        } else {
            if (root.color == 1) {
                num++;
            }
            if (!dfs(root.lChild, num)) {
                flag = false;
            }
            if (!dfs(root.rChild, num)) {
                flag = false;
            }
        }
        return flag;
    }

    static boolean bfs(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        boolean flag = true;
        if (root.color == 0) {
            flag = false;
        } else {
            list.add(root);
            while (!list.isEmpty()) {
                TreeNode n = list.remove();
                if (n.color == 0) {
                    if ((n.lChild != null && n.lChild.color == 0) || (n.rChild != null && n.rChild.color == 0)) {
                        flag = false;
                        break;
                    }
                }
                blackNum = -1;
                if (!dfs(n, 0)) {
                    flag = false;
                    break;
                }
                if (n.lChild != null) {
                    list.add(n.lChild);
                }
                if (n.rChild != null) {
                    list.add(n.rChild);
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        TreeNode root;
        for (int i = 0; i < k; i++) {
            int num = sc.nextInt();
            root = null;
            for (int j = 0; j < num; j++) {
                int temp = sc.nextInt();
                if (temp < 0) {
                    root = insert(root, 0, Math.abs(temp));
                } else {
                    root = insert(root, 1, Math.abs(temp));
                }
            }
            if (bfs(root)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

        sc.close();
    }
}

