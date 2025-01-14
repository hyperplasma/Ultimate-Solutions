package A1151_LCAInABinaryTree;

import java.io.*;
import java.util.*;

/**
 * 测试点3、4非零返回，测试点5随机非零返回
 */
public class Main {
    static final int N = 10010;
    static int n, m;
    static int[] inorder = new int[N];
    static int[] preorder = new int[N];
    static Map<Integer, Integer> pos = new HashMap<>();
    static int[] parent = new int[N];
    static int[] depth = new int[N];
    static int[] nodeValues = new int[N];

    // 根据中序和前序遍历重建二叉树，返回根节点的索引
    static int buildTree(int inL, int inR, int preL, int preR, int d) {
        if (inL > inR) return -1;

        // 前序遍历的第一个节点是根节点
        int rootValue = preorder[preL];
        int rootIndex = pos.get(rootValue);
        int root = rootIndex;

        // 记录节点深度和实际值
        depth[root] = d;
        nodeValues[root] = rootValue;

        // 计算左子树的大小
        int leftSize = rootIndex - inL;

        // 递归构建左右子树
        int leftChild = buildTree(inL, rootIndex - 1, preL + 1, preL + leftSize, d + 1);
        int rightChild = buildTree(rootIndex + 1, inR, preL + leftSize + 1, preR, d + 1);

        // 设置父节点关系
        if (leftChild != -1) parent[leftChild] = root;
        if (rightChild != -1) parent[rightChild] = root;

        return root;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 读取查询数和节点数
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        // 读取中序遍历序列
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            pos.put(inorder[i], i);
        }

        // 读取前序遍历序列
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            preorder[i] = Integer.parseInt(st.nextToken());
        }

        // 构建二叉树
        buildTree(0, n - 1, 0, n - 1, 0);

        // 处理查询
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            // 检查节点是否存在
            if (!pos.containsKey(u) && !pos.containsKey(v)) {
                System.out.printf("ERROR: %d and %d are not found.\n", u, v);
            } else if (!pos.containsKey(u)) {
                System.out.printf("ERROR: %d is not found.\n", u);
            } else if (!pos.containsKey(v)) {
                System.out.printf("ERROR: %d is not found.\n", v);
            } else {
                // 获取节点在树中的位置
                int uPos = pos.get(u);
                int vPos = pos.get(v);
                int u0 = uPos, v0 = vPos;

                // 寻找LCA
                while (uPos != vPos) {
                    if (depth[uPos] > depth[vPos]) {
                        uPos = parent[uPos];
                    } else {
                        vPos = parent[vPos];
                    }
                }

                // 输出结果
                if (uPos != u0 && uPos != v0) {
                    System.out.printf("LCA of %d and %d is %d.\n", u, v, nodeValues[uPos]);
                } else if (uPos == u0) {
                    System.out.printf("%d is an ancestor of %d.\n", u, v);
                } else {
                    System.out.printf("%d is an ancestor of %d.\n", v, u);
                }
            }
        }
    }
}