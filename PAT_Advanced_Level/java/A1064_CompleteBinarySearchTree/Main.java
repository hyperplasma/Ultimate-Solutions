package A1064_CompleteBinarySearchTree;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int N = 1010;
    static int n;
    static int[] tr = new int[N];
    static int[] in = new int[N];
    static int num = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        for (int i = 0; i < n; i++) {
            in[i] = scanner.nextInt();
        }

        Arrays.sort(in, 0, n);
        dfs(1);

        for (int i = 1; i <= n; i++) {
            if (i > 1) {
                System.out.print(" ");
            }
            System.out.print(tr[i]);
        }
        System.out.println();

        scanner.close();
    }

    private static void dfs(int u) {
        if (u <= n) {
            dfs(2 * u);
            tr[u] = in[num++];
            dfs(2 * u + 1);
        }
    }
}