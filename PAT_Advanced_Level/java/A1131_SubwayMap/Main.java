package A1131_SubwayMap;

import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, weight, line;

        Edge(int to, int weight, int line) {
            this.to = to;
            this.weight = weight;
            this.line = line;
        }
    }

    static int N = 10010;
    static int[] h = new int[N];
    static List<Edge>[] adj = new ArrayList[N];
    static int[] dist = new int[N];
    static int[] cnt = new int[N];
    static int[] pre = new int[N];
    static String[] info = new String[N];
    static boolean[] st = new boolean[N];

    static String getNumber(int x) {
        return String.format("%04d", x);
    }

    static void add(int a, int b, int c, int id) {
        adj[a].add(new Edge(b, c, id));
    }

    static void dijkstra(int start, int end) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(cnt, Integer.MAX_VALUE);
        Arrays.fill(st, false);

        PriorityQueue<Pair> heap = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        heap.offer(new Pair(0, start));
        dist[start] = cnt[start] = 0;

        while (!heap.isEmpty()) {
            Pair t = heap.poll();
            int ver = t.vertex;
            if (ver == end) break;
            if (st[ver]) continue;
            st[ver] = true;

            for (Edge edge : adj[ver]) {
                int j = edge.to;
                if (dist[j] > dist[ver] + edge.weight) {
                    dist[j] = dist[ver] + edge.weight;
                    cnt[j] = cnt[ver] + 1;
                    pre[j] = ver;
                    info[j] = "Take Line#" + edge.line + " from " + getNumber(ver) + " to " + getNumber(j) + ".";
                    heap.offer(new Pair(dist[j], j));
                } else if (dist[j] == dist[ver] + edge.weight) {
                    if (cnt[j] > cnt[ver] + 1) {
                        cnt[j] = cnt[ver] + 1;
                        pre[j] = ver;
                        info[j] = "Take Line#" + edge.line + " from " + getNumber(ver) + " to " + getNumber(j) + ".";
                    }
                }
            }
        }

        System.out.println(dist[end]);
        List<String> path = new ArrayList<>();
        for (int i = end; i != start; i = pre[i])
            path.add(info[i]);

        for (int i = path.size() - 1; i >= 0; i--)
            System.out.println(path.get(i));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            adj[i] = new ArrayList<>();
            h[i] = -1;
        }

        for (int i = 1; i <= n; i++) {
            String[] parts = br.readLine().split(" ");
            int m = Integer.parseInt(parts[0]);
            int[] stops = new int[m];
            for (int j = 0; j < m; j++) {
                stops[j] = Integer.parseInt(parts[j + 1]);
            }

            for (int j = 0; j < m; j++) {
                for (int k = 0; k < j; k++) {
                    int len = stops[0] != stops[m - 1] ? j - k : Math.min(j - k, m - 1 - j + k);
                    add(stops[j], stops[k], len, i);
                    add(stops[k], stops[j], len, i);
                }
            }
        }

        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            String[] parts = br.readLine().split(" ");
            int start = Integer.parseInt(parts[0]);
            int end = Integer.parseInt(parts[1]);
            dijkstra(start, end);
        }
    }

    static class Pair {
        int weight, vertex;

        Pair(int weight, int vertex) {
            this.weight = weight;
            this.vertex = vertex;
        }
    }
}