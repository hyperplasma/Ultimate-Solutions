package A1138_PostorderTraversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 测试点4、5非零返回（使用Scanner则超时）
 */
public class Main {
    static int n;
    static Map<Integer, Integer> pos = new HashMap<>();
    static int[] pre;
    static int[] in;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());

        pre = new int[n];
        in = new int[n];

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            pre[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            in[i] = Integer.parseInt(st.nextToken());
            pos.put(in[i], i);
        }

        build(0, n - 1, 0, n - 1);
    }

    static void build(int inL, int inR, int preL, int preR) {
        int root = pre[preL];
        int k = pos.get(root);

        if (k > inL) {
            build(inL, k - 1, preL + 1, preL + 1 + (k - 1 - inL));
        }
        if (k < inR) {
            build(k + 1, inR, preL + 1 + k - inL, preR);
        }

        if (!flag) {
            System.out.print(root);
            flag = true;
        }
    }
}