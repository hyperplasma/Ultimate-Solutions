package A1063_SetSimilarity;

import java.io.*;
import java.util.*;

/**
 * 测试点3、4超时
 */
public class Main {
    static final int N = 60;
    static Set<Integer>[] sets = new Set[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= n; ++i) {
            sets[i] = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            while (m-- > 0) {
                int x = Integer.parseInt(st.nextToken());
                sets[i].add(x);
            }
        }

        st = new StringTokenizer(br.readLine());
        int Q = Integer.parseInt(st.nextToken());
        while (Q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int cnt = 0;
            Set<Integer> stB = sets[b];
            Set<Integer> unionSet = new HashSet<>(sets[a]);
            unionSet.addAll(stB);

            for (int x : sets[a]) {
                if (stB.contains(x)) cnt++;
            }

            System.out.printf("%.1f%%\n", cnt * 100.0 / unionSet.size());
        }

        br.close();
    }
}