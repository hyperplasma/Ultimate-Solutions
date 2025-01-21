package PAT_A1170_Safari_Park;

import java.io.*;
import java.util.*;

/**
 * 测试点5超时
 */
public class Main {
    static class Edge {
        int a, b;
        Edge(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Edge[] e = new Edge[m];
        for (int i = 0; i < m; ++i) {
            st = new StringTokenizer(br.readLine());
            e[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int Q = Integer.parseInt(br.readLine());
        while (Q-- > 0) {
            Set<Integer> set = new HashSet<>();
            int[] r = new int[n + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= n; ++i) {
                r[i] = Integer.parseInt(st.nextToken());
                set.add(r[i]);
            }

            if (set.size() > k) {
                System.out.println("Error: Too many species.");
            } else if (set.size() < k) {
                System.out.println("Error: Too few species.");
            } else {
                boolean flag = true;
                for (int i = 0; i < m; ++i) {
                    if (r[e[i].a] == r[e[i].b]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }
}