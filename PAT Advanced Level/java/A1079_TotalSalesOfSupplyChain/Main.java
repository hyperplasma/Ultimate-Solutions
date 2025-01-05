package A1079_TotalSalesOfSupplyChain;

import java.io.*;
import java.util.*;

public class Main {
    static final int N = 100010;
    static int n;
    static double P, r;
    static List<Integer>[] tr = new List[N];  // root = 0
    static int[] retail = new int[N];
    static double[] price = new double[N];

    static void dfs(int u, double p) {
        if (retail[u] > 0) {
            price[u] = p * retail[u];
            return;
        }

        for (int v : tr[u]) {
            dfs(v, p * (1 + r));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        P = Double.parseDouble(parts[1]);
        r = Double.parseDouble(parts[2]) / 100.0;  // Convert percentage to decimal

        for (int i = 0; i < N; i++) {
            tr[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; ++i) {
            parts = br.readLine().split(" ");
            int k = Integer.parseInt(parts[0]);
            if (k == 0) {
                retail[i] = Integer.parseInt(parts[1]);
            } else {
                for (int j = 1; j <= k; ++j) {
                    int son = Integer.parseInt(parts[j]);
                    tr[i].add(son);
                }
            }
        }

        dfs(0, P);

        double totalSales = 0;
        for (int i = 0; i < n; ++i) {
            if (retail[i] > 0) {
                totalSales += price[i];
            }
        }
        System.out.printf("%.1f\n", totalSales);

        br.close();
    }
}