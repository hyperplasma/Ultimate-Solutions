package PAT_A1154_Vertex_Coloring;

import java.io.*;
import java.util.*;

/**
 * 测试点2随机超时
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

        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            int[] colors = new int[n];
            Set<Integer> uniqueColors = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                colors[i] = Integer.parseInt(st.nextToken());
                uniqueColors.add(colors[i]);
            }

            boolean isValid = true;
            for (Edge edge : edges) {
                if (colors[edge.a] == colors[edge.b]) {
                    isValid = false;
                    break;
                }
            }
            if (!isValid) {
                System.out.println("No");
            } else {
                System.out.println(uniqueColors.size() + "-coloring");
            }
        }
    }
}