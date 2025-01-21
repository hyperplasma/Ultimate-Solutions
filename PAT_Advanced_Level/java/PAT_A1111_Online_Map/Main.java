package PAT_A1111_Online_Map;

import java.io.*;
import java.util.*;

public class Main {
    static final int N = 510;
    static int n, m, S, T;
    static List<int[]>[] g1 = new ArrayList[N], g2 = new ArrayList[N];
    static int[] dist1 = new int[N], dist2 = new int[N], pre = new int[N];
    static boolean[] st = new boolean[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < N; i++) {
            g1[i] = new ArrayList<>();
            g2[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int flag = Integer.parseInt(tokenizer.nextToken());
            int temp1 = Integer.parseInt(tokenizer.nextToken());
            int temp2 = Integer.parseInt(tokenizer.nextToken());

            g1[a].add(new int[]{b, temp1});
            g2[a].add(new int[]{b, temp2});
            if (flag == 0) {
                g1[b].add(new int[]{a, temp1});
                g2[b].add(new int[]{a, temp2});
            }
        }

        tokenizer = new StringTokenizer(reader.readLine());
        S = Integer.parseInt(tokenizer.nextToken());
        T = Integer.parseInt(tokenizer.nextToken());

        String[] A = dijkstra(g1, g2, 0);
        String[] B = dijkstra(g2, g1, 1);

        if (!A[1].equals(B[1])) {
            System.out.println("Distance = " + A[0] + ": " + A[1]);
            System.out.println("Time = " + B[0] + ": " + B[1]);
        } else {
            System.out.println("Distance = " + A[0] + "; Time = " + B[0] + ": " + A[1]);
        }
    }

    static String[] dijkstra(List<int[]>[] g1, List<int[]>[] g2, int flag) {
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);
        Arrays.fill(st, false);
        dist1[S] = dist2[S] = 0;

        for (int i = 0; i < n; i++) {
            int t = -1;
            for (int j = 0; j < n; j++) {
                if (!st[j] && (t == -1 || dist1[j] < dist1[t])) {
                    t = j;
                }
            }

            st[t] = true;

            List<int[]> d1 = g1[t];
            List<int[]> d2 = g2[t];
            for (int k = 0; k < d1.size(); k++) {
                int j = d1.get(k)[0];
                int w = (flag == 0) ? d2.get(k)[1] : 1;
                if (dist1[j] > dist1[t] + d1.get(k)[1]) {
                    dist1[j] = dist1[t] + d1.get(k)[1];
                    dist2[j] = dist2[t] + w;
                    pre[j] = t;
                } else if (dist1[j] == dist1[t] + d1.get(k)[1]) {
                    if (dist2[j] > dist2[t] + w) {
                        dist2[j] = dist2[t] + w;
                        pre[j] = t;
                    }
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        for (int i = T; i != S; i = pre[i]) {
            path.add(i);
        }

        StringBuilder res = new StringBuilder();
        res.append(S);
        for (int i = path.size() - 1; i >= 0; i--) {
            res.append(" -> ").append(path.get(i));
        }

        return new String[]{String.valueOf(dist1[T]), res.toString()};
    }
}