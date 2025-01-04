package A1004_CountingLeaves;

import java.util.*;

public class Main {
    static final int N = 110;

    static int n, m;
    static ArrayList<Integer>[] tr = new ArrayList[N];
    static int[] cnt = new int[N];
    static int level = 0;

    public static void bfs(int u) {
        Queue<Integer> q = new LinkedList<>();
        q.add(u);

        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int t = q.poll();

                if (tr[t].isEmpty()) cnt[level]++;
                else {
                    for (int child : tr[t]) {
                        q.add(child);
                    }
                }
            }
            level++;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();

        for (int i = 0; i < N; ++i) {
            tr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; ++i) {
            int id = scanner.nextInt();
            int k = scanner.nextInt();

            for (int j = 0; j < k; ++j) {
                int child = scanner.nextInt();
                tr[id].add(child);
            }
        }

        bfs(1);
        for (int i = 0; i < level; ++i) {
            if (i > 0) System.out.print(" ");
            System.out.print(cnt[i]);
        }

        scanner.close();
    }
}