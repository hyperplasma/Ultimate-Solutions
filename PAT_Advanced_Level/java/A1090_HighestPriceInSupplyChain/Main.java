package A1090_HighestPriceInSupplyChain;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int maxDepth = 0;
    static int num = 0;
    static Scanner sc = new Scanner(System.in);
    static int n = sc.nextInt();
    static ArrayList<Integer>[] lists = new ArrayList[n];
    static double p = sc.nextDouble();
    static double r = sc.nextDouble();

    public static void main(String[] args) {
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        int root = 0;
        for (int i = 0; i < n; i++) {
            int h = sc.nextInt();
            if (h != -1) {
                lists[h].add(i);
            } else {
                root = i;
            }
        }
        dfs(root, 0);
        double f = p * Math.pow((100 + r) / 100, maxDepth);
        System.out.print(String.format("%.2f", f) + " " + num);
    }

    public static void dfs(int root, int depth) {
        if (lists[root].isEmpty()) {
            if (depth > maxDepth) {
                maxDepth = depth;
                num = 1;
            } else if (depth == maxDepth) {
                num++;
            }
            return;
        }
        for (Integer w : lists[root]) {
            dfs(w, depth + 1);
        }
    }
}
