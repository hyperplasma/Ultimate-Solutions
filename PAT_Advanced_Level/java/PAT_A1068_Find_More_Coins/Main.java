package PAT_A1068_Find_More_Coins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    static final int MAXN = 10010, MAXV = 110;

    static int[] dp = new int[MAXV];
    static Integer[] coins = new Integer[MAXN];
    static boolean[][] selected = new boolean[MAXN][MAXV];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        int n = Integer.parseInt(line[0]), m = Integer.parseInt(line[1]);
        line = reader.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            coins[i] = Integer.valueOf(line[i - 1]);
        }

        Arrays.sort(coins, 1, n + 1, Collections.reverseOrder());
        for (int i = 1; i <= n; i++) {
            for (int v = m; v >= coins[i]; v--) {
                if (dp[v] <= dp[v - coins[i]] + coins[i]) {
                    dp[v] = dp[v - coins[i]] + coins[i];
                    selected[i][v] = true;
                } else {
                    selected[i][v] = false;
                }
            }
        }

        if (dp[m] != m) {
            System.out.println("No Solution");
        } else {
            int k = n, v = m;
            while (k >= 0) {
                if (selected[k][v]) {
                    System.out.print(coins[k]);
                    v -= coins[k];
                    if (v != 0) {
                        System.out.print(" ");
                    }
                }
                k--;
            }
        }
    }
}
