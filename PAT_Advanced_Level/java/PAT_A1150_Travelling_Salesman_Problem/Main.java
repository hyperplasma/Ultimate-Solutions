package PAT_A1150_Travelling_Salesman_Problem;

import java.io.*;
import java.util.*;

/**
 * 测试点3超时
 */
public class Main {
    static final int N = 210, INF = 0x3f3f3f3f;
    static int n, m;
    static int[][] g = new int[N][N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        String[] nm = reader.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        for (int i = 1; i <= n; i++) {
            Arrays.fill(g[i], INF);
        }

        for (int i = 0; i < m; i++) {
            String[] edge = reader.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            int w = Integer.parseInt(edge[2]);
            g[a][b] = g[b][a] = w;
        }

        int Q = Integer.parseInt(reader.readLine());

        int min = INF, minNum = 0;
        for (int num = 1; num <= Q; num++) {
            List<Integer> v = new ArrayList<>();
            Set<Integer> st = new HashSet<>();

            String[] path = reader.readLine().split(" ");
            int k = Integer.parseInt(path[0]);
            for (int i = 1; i <= k; i++) {
                int x = Integer.parseInt(path[i]);
                v.add(x);
                st.add(x);
            }

            int dist = 0;
            for (int i = 0; i < v.size() - 1; i++) {
                if (g[v.get(i)][v.get(i + 1)] == INF) {
                    dist = -1;
                    break;
                }
                dist += g[v.get(i)][v.get(i + 1)];
            }

            int flag = 2;
            if (st.size() < n || !v.get(0).equals(v.get(v.size() - 1)) || dist == -1)
                flag = 0;
            else if (v.size() != n + 1)
                flag = 1;

            if (flag != 0) {
                if (dist < min) {
                    min = dist;
                    minNum = num;
                }
            }

            writer.printf("Path %d: ", num);
            if (dist == -1) writer.print("NA ");
            else writer.print(dist + " ");

            if (flag == 2) writer.println("(TS simple cycle)");
            else if (flag == 1) writer.println("(TS cycle)");
            else writer.println("(Not a TS cycle)");
        }

        writer.printf("Shortest Dist(%d) = %d\n", minNum, min);
        writer.flush();
        writer.close();
        reader.close();
    }
}
