package A1127_ZigZaggingOnATree;

import java.io.*;
import java.util.*;

public class Main {
    static final int N = 40;

    static int n;
    static Map<Integer, Integer> l = new HashMap<>();
    static Map<Integer, Integer> r = new HashMap<>();
    static int[] in = new int[N];
    static int[] post = new int[N];

    // 根据中序和后序遍历重建二叉树
    static int build(int inL, int inR, int postL, int postR) {
        if (inL > inR) return 0;

        int root = post[postR];
        int k;
        for (k = inL; k <= inR; k++) {
            if (in[k] == root) break;
        }

        if (inL < k) {
            l.put(root, build(inL, k - 1, postL, postL + (k - 1 - inL)));
        }
        if (k < inR) {
            r.put(root, build(k + 1, inR, postL + (k - 1 - inL) + 1, postR - 1));
        }

        return root;
    }

    // 之字形层序遍历
    static void bfs(int u) {
        Stack<Integer> stk = new Stack<>();
        stk.push(u);

        int cnt = 1;
        boolean isFirst = true;
        StringBuilder sb = new StringBuilder();

        while (!stk.isEmpty()) {
            Stack<Integer> newStk = new Stack<>();
            while (!stk.isEmpty()) {
                int t = stk.pop();

                if (isFirst) {
                    isFirst = false;
                } else {
                    sb.append(" ");
                }
                sb.append(t);

                if (cnt % 2 == 1) {
                    // 奇数层，从右到左
                    if (r.containsKey(t)) newStk.push(r.get(t));
                    if (l.containsKey(t)) newStk.push(l.get(t));
                } else {
                    // 偶数层，从左到右
                    if (l.containsKey(t)) newStk.push(l.get(t));
                    if (r.containsKey(t)) newStk.push(r.get(t));
                }
            }

            stk = newStk;
            cnt++;
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 读取节点数
        n = Integer.parseInt(br.readLine());

        // 读取中序遍历序列
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(inputs[i]);
        }

        // 读取后序遍历序列
        inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            post[i] = Integer.parseInt(inputs[i]);
        }

        // 重建二叉树并进行之字形遍历
        int root = build(0, n - 1, 0, n - 1);
        bfs(root);

        br.close();
    }
}