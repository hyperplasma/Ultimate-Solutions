package PAT_A1146_Topological_Order;

import java.io.*;
import java.util.*;

/**
 * 测试点4超时
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

        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b);
        }

        int Q = Integer.parseInt(br.readLine());

        int[] q = new int[n];
        int[] pos = new int[n + 1];  // 顶点编号从1开始

        boolean isFirst = true;
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                q[j] = Integer.parseInt(st.nextToken());
                pos[q[j]] = j;
            }

            for (int j = 0; j < m; j++) {
                int a = edges[j].a;
                int b = edges[j].b;
                if (pos[a] >= pos[b]) {
                    if (isFirst) {
                        isFirst = false;
                    } else {
                        System.out.print(" ");
                    }
                    System.out.print(i);
                    break;
                }
            }
        }
    }
}
