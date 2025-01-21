package PAT_A1134_Vertex_Cover;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * 测试点2、3超时
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
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            edges[i] = new Edge(a, b);
        }

        int Q = Integer.parseInt(reader.readLine());
        while (Q-- > 0) {
            HashSet<Integer> vertices = new HashSet<>();

            st = new StringTokenizer(reader.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int i = 0; i < num; i++) {
                vertices.add(Integer.parseInt(st.nextToken()));
            }

            boolean success = true;
            for (int i = 0; i < m; i++) {
                if (!vertices.contains(edges[i].a) && !vertices.contains(edges[i].b)) {
                    success = false;
                    break;
                }
            }
            System.out.println(success ? "Yes" : "No");
        }
    }
}