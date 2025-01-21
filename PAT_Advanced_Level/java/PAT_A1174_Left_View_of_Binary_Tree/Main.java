package PAT_A1174_Left_View_of_Binary_Tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static final int N = 10010;
    static int[] l = new int[N], r = new int[N], w = new int[N];
    static Map<Integer, Integer> pos = new HashMap<>();
    static int[] in = new int[N], pre = new int[N];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine().trim());

        String[] inputs = reader.readLine().split(" ");
        for (int i = 1; i <= n; ++i) {
            in[i] = Integer.parseInt(inputs[i - 1]);
            w[i] = in[i];
            pos.put(w[i], i);
        }

        inputs = reader.readLine().split(" ");
        for (int i = 1; i <= n; ++i) {
            pre[i] = pos.get(Integer.parseInt(inputs[i - 1]));
            in[i] = pos.get(in[i]);
        }

        int root = build(1, n, 1, n);
        bfs(root);
    }

    static int build(int inL, int inR, int preL, int preR) {
        int root = pre[preL];

        int k;
        for (k = inL; k <= inR; ++k) {
            if (in[k] == root) {
                break;
            }
        }

        if (inL < k) {
            l[root] = build(inL, k - 1, preL + 1, preL + 1 + (k - 1 - inL));
        }
        if (k < inR) {
            r[root] = build(k + 1, inR, preL + 1 + (k - 1 - inL) + 1, preR);
        }

        return root;
    }

    static void bfs(int u) {
        Queue<Integer> q = new LinkedList<>();
        q.add(u);
        List<Integer> v = new ArrayList<>();

        while (!q.isEmpty()) {
            int size = q.size();
            v.add(q.peek());
            while (size-- > 0) {
                int t = q.poll();
                if (l[t] != 0) {
                    q.add(l[t]);
                }
                if (r[t] != 0) {
                    q.add(r[t]);
                }
            }
        }

        for (int i = 0; i < v.size(); ++i) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(w[v.get(i)]);
        }
        System.out.println();
    }
}