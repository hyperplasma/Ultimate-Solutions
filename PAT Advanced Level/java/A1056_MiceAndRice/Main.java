package A1056_MiceAndRice;

import java.io.*;
import java.util.*;

public class Main {
    static final int N = 1010;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());  // 老鼠数量
        int m = Integer.parseInt(st.nextToken());  // 每轮最多参与的老鼠数量
        int[] w = new int[N];       // 每只老鼠的权重
        int[] ans = new int[N];     // 每只老鼠的级别

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> cur = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cur.add(Integer.parseInt(st.nextToken()));
        }

        while (cur.size() > 1) {
            List<Integer> next = new ArrayList<>();
            int remain = (cur.size() + m - 1) / m;  // 每次剩下 "n/m" 只老鼠，需取模

            for (int i = 0; i < cur.size(); ) {
                int j = Math.min(cur.size(), i + m);

                int t = i;
                for (int k = i; k < j; k++) {
                    if (w[cur.get(k)] > w[cur.get(t)]) {
                        t = k;
                    }
                }
                next.add(cur.get(t));
                for (int k = i; k < j; k++) {
                    if (k != t) {
                        ans[cur.get(k)] = remain + 1;
                    }
                }

                i = j;
            }

            cur = next;
        }

        ans[cur.get(0)] = 1;

        System.out.print(ans[0]);
        for (int i = 1; i < n; i++) {
            System.out.print(" " + ans[i]);
        }
        System.out.println();

        br.close();
    }
}
