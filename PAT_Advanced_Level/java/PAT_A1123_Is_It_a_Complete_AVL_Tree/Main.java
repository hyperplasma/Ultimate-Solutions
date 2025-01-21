package PAT_A1123_Is_It_a_Complete_AVL_Tree;

import java.io.*;
import java.util.*;

public class Main {
    static final int N = 30;

    static int n;
    static int[] l = new int[N];    // 左子节点
    static int[] r = new int[N];    // 右子节点
    static int[] v = new int[N];    // 节点值
    static int[] h = new int[N];    // 高度
    static int idx;                 // 节点索引
    static int[] level = new int[N];
    static int[] pos = new int[N];  // 节点位置
    static boolean flag = true;

    // 更新节点高度
    static void update(int u) {
        h[u] = Math.max(h[l[u]], h[r[u]]) + 1;
    }

    // 计算平衡因子
    static int BF(int u) {
        return h[l[u]] - h[r[u]];
    }

    // 左旋操作
    static void L(IntWrapper u) {
        int p = r[u.value];
        r[u.value] = l[p];
        l[p] = u.value;
        update(u.value);
        update(p);
        u.value = p;
    }

    // 右旋操作
    static void R(IntWrapper u) {
        int p = l[u.value];
        l[u.value] = r[p];
        r[p] = u.value;
        update(u.value);
        update(p);
        u.value = p;
    }

    // 插入节点
    static void insert(IntWrapper u, int w) {
        if (u.value == 0) {
            u.value = ++idx;
            v[u.value] = w;
        } else if (w < v[u.value]) {
            IntWrapper lu = new IntWrapper(l[u.value]);
            insert(lu, w);
            l[u.value] = lu.value;

            if (BF(u.value) == 2) {
                if (BF(l[u.value]) == 1) {
                    R(u);
                } else {
                    IntWrapper lu2 = new IntWrapper(l[u.value]);
                    L(lu2);
                    l[u.value] = lu2.value;
                    R(u);
                }
            }
        } else {
            IntWrapper ru = new IntWrapper(r[u.value]);
            insert(ru, w);
            r[u.value] = ru.value;

            if (BF(u.value) == -2) {
                if (BF(r[u.value]) == -1) {
                    L(u);
                } else {
                    IntWrapper ru2 = new IntWrapper(r[u.value]);
                    R(ru2);
                    r[u.value] = ru2.value;
                    L(u);
                }
            }
        }

        update(u.value);
    }

    // BFS遍历
    static void bfs(int u) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(u);
        pos[u] = 1;
        boolean isFirst = true;
        StringBuilder sb = new StringBuilder();

        while (!q.isEmpty()) {
            int t = q.poll();

            if (isFirst) {
                isFirst = false;
            } else {
                sb.append(" ");
            }
            sb.append(v[t]);

            if (pos[t] > n) flag = false;

            if (l[t] != 0) {
                q.offer(l[t]);
                pos[l[t]] = 2 * pos[t];
            }
            if (r[t] != 0) {
                q.offer(r[t]);
                pos[r[t]] = 2 * pos[t] + 1;
            }
        }

        System.out.println(sb);
    }

    // 包装类用于模拟C++的引用传递
    static class IntWrapper {
        int value;

        IntWrapper(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        IntWrapper root = new IntWrapper(0);
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            insert(root, Integer.parseInt(inputs[i]));
        }

        bfs(root.value);
        System.out.println(flag ? "YES" : "NO");

        br.close();
    }
}