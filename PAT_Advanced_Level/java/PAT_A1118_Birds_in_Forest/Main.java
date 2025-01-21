package PAT_A1118_Birds_in_Forest;

import java.io.*;
import java.util.*;

/**
 * 测试点3、4超时
 */
public class Main {
    static final int N = 10010;
    static int[] p = new int[N];
    static int[] birds = new int[N];
    static Set<Integer> st = new HashSet<>();

    static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }

    static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) {
            if (pa > pb) {
                int temp = pa;
                pa = pb;
                pb = temp;
            }
            p[pb] = pa;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        for (int i = 1; i < N; ++i) {
            p[i] = i;
        }

        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; ++i) {
            String[] parts = reader.readLine().split(" ");
            int k = Integer.parseInt(parts[0]);
            for (int j = 0; j < k; ++j) {
                birds[j] = Integer.parseInt(parts[j + 1]);
                st.add(birds[j]);
            }

            for (int j = 0; j < k - 1; ++j) {
                union(birds[j], birds[j + 1]);
            }
        }

        int cnt = 0;
        for (int i : st) {
            if (find(i) == i) {
                cnt++;
            }
        }
        writer.printf("%d %d\n", cnt, st.size());

        int Q = Integer.parseInt(reader.readLine());
        for (int i = 0; i < Q; ++i) {
            String[] query = reader.readLine().split(" ");
            int a = Integer.parseInt(query[0]);
            int b = Integer.parseInt(query[1]);
            if (find(a) == find(b)) {
                writer.println("Yes");
            } else {
                writer.println("No");
            }
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}