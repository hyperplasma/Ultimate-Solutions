package A1103_IntegerFactorization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static final int N = 30;
    static int n, k, p;
    static int[] v = new int[N];
    static List<Integer> path = new ArrayList<>();
    static List<Integer> res = new ArrayList<>();
    static int maxSum = -1;

    static void dfs(int i, int n, int cnt, int sum) {
        if (n == 0 && cnt == k) {
            if (sum > maxSum) {
                maxSum = sum;
                res = new ArrayList<>(path);
            }
            return;
        }

        for (; i > 0; i--) {
            if (n - v[i] >= 0 && cnt + 1 <= k) {
                path.set(cnt, i);
                dfs(i, n - v[i], cnt + 1, sum + i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);
        p = Integer.parseInt(input[2]);

        int i = 0;
        while (Math.pow(++i, p) <= n) {
            v[i] = (int) Math.pow(i, p);
        }
        i--;

        path = new ArrayList<>(k);
        for (int j = 0; j < k; j++) {
            path.add(0);
        }

        dfs(i, n, 0, 0);

        if (maxSum == -1) {
            System.out.println("Impossible");
        } else {
            System.out.print(n + " =");
            for (int j = 0; j < res.size(); j++) {
                if (j > 0) System.out.print(" +");
                System.out.print(" " + res.get(j) + "^" + p);
            }
            System.out.println();
        }
    }
}
