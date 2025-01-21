package PAT_A1163_Dijkstra_Sequence;

import java.io.*;
import java.util.*;

public class Main {
    static final int N = 1010;
    static final int INF = 0x3f3f3f3f;

    static int n, m;
    static int[][] g = new int[N][N];
    static int[] seq = new int[N];
    static int[] dist = new int[N];
    static boolean[] visited = new boolean[N];

    static boolean checkDijkstra() {
        Arrays.fill(dist, INF);
        Arrays.fill(visited, false);
        dist[seq[0]] = 0;

        for (int i = 0; i < n; i++) {
            int current = seq[i];

            for (int j = 1; j <= n; j++) {
                if (!visited[j] && dist[j] < dist[current]) {
                    return false;
                }
            }

            visited[current] = true;

            for (int j = 1; j <= n; j++) {
                if (g[current][j] != INF) {
                    dist[j] = Math.min(dist[j], dist[current] + g[current][j]);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            Arrays.fill(g[i], INF);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            g[a][b] = g[b][a] = Math.min(g[a][b], w);
        }

        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                seq[i] = Integer.parseInt(st.nextToken());
            }

            System.out.println(checkDijkstra() ? "Yes" : "No");
        }
    }
}