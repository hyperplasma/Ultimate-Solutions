package PAT_A1018_Public_Bike_Management;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static final int N = 510;
    static final int INF = 0x3f3f3f3f;

    static int C, n, S, m;
    static int[] c = new int[N];
    static int[][] g = new int[N][N];
    static int[] dist = new int[N];
    static boolean[] st = new boolean[N];
    static List<Integer> path = new ArrayList<>();
    static List<Integer> ans = new ArrayList<>();
    static int send = INF, bring = INF;

    public static void dijkstra() {
        Arrays.fill(dist, INF);
        dist[S] = 0;

        for (int i = 0; i <= n; i++) {
            int t = -1;
            for (int j = 0; j <= n; j++) {
                if (!st[j] && (t == -1 || dist[j] < dist[t])) {
                    t = j;
                }
            }

            st[t] = true;
            for (int j = 0; j <= n; j++) {
                dist[j] = Math.min(dist[j], dist[t] + g[t][j]);
            }
        }
    }

    public static void dfs(int u, int s, int mins) {
        if (u != 0) {
            s -= (C + 1) / 2 - c[u];
            mins = Math.min(mins, s);
        }

        if (u == S) {
            int sd = Math.abs(Math.min(mins, 0));
            int bg = s + sd;

            if (sd < send) {
                ans = new ArrayList<>(path);
                send = sd;
                bring = bg;
            } else if (sd == send && bg < bring) {
                ans = new ArrayList<>(path);
                bring = bg;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (dist[u] == g[u][i] + dist[i]) {
                path.add(i);
                dfs(i, s, mins);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            c[i] = Integer.parseInt(st.nextToken());
        }

        for (int[] row : g) {
            Arrays.fill(row, INF);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            g[x][y] = g[y][x] = Math.min(g[x][y], z);
        }

        dijkstra();

        path.add(0);
        dfs(0, 0, 0);

        System.out.print(send + " " + 0);
        for (int i = 1; i < ans.size(); i++) {
            System.out.print("->" + ans.get(i));
        }
        System.out.println(" " + bring);
    }
}