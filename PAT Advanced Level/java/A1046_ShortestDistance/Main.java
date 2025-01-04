package A1046_ShortestDistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 测试点2超时
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] first = reader.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int[] dist = new int[n + 1];
        int[] sum = new int[n + 1];
        int circle = 0;

        for (int i = 1; i <= n; i++) {
            dist[i] = Integer.parseInt(first[i]);
            sum[i] = sum[i - 1] + dist[i];
            circle += dist[i];
        }

        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < m; i++) {
            String[] line = reader.readLine().split(" ");
            int start = Integer.parseInt(line[0]);
            int end = Integer.parseInt(line[1]);
            int low = Math.min(start, end);
            int high = Math.max(start, end);

            int delta = sum[high - 1] - sum[low - 1];
            System.out.println(Math.min(delta, circle - (delta)));
        }
    }
}
