package A1094_TheLargestGeneration;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static final int N = 110;
    static int n, m;
    static List<Integer>[] tr = new ArrayList[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());

        for (int i = 1; i <= n; i++) {
            tr[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int id = Integer.parseInt(tokenizer.nextToken());
            int k = Integer.parseInt(tokenizer.nextToken());

            for (int j = 0; j < k; j++) {
                int son = Integer.parseInt(tokenizer.nextToken());
                tr[id].add(son);
            }
        }

        bfs(1);
    }

    private static void bfs(int u) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(u);

        int maxSize = 0, cnt = 0, maxCnt = 0;
        while (!queue.isEmpty()) {
            cnt++;
            int size = queue.size();
            if (size > maxSize) {
                maxSize = size;
                maxCnt = cnt;
            }

            for (int i = 0; i < size; i++) {
                int t = queue.poll();
                for (int v : tr[t]) {
                    queue.offer(v);
                }
            }
        }

        System.out.printf("%d %d\n", maxSize, maxCnt);
    }
}