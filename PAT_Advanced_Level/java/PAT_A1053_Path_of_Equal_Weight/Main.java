package PAT_A1053_Path_of_Equal_Weight;

import java.util.*;

public class Main {
    static final int N = 110;
    static int n, m, S;
    static boolean[][] g = new boolean[N][N];
    static int[] w = new int[N];
    static List<List<Integer>> ans = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        m = scanner.nextInt();
        S = scanner.nextInt();

        for (int i = 0; i < n; ++i) {
            w[i] = scanner.nextInt();
        }

        for (int i = 0; i < m; ++i) {
            int id = scanner.nextInt();
            int k = scanner.nextInt();

            for (int j = 0; j < k; ++j) {
                int son = scanner.nextInt();
                g[id][son] = true;
            }
        }

        List<Integer> path = new ArrayList<>();
        path.add(w[0]);
        dfs(0, w[0], path);

        ans.sort((a, b) -> {
            for (int i = 0; i < Math.min(a.size(), b.size()); ++i) {
                if (!a.get(i).equals(b.get(i))) {
                    return b.get(i) - a.get(i);
                }
            }
            return b.size() - a.size();
        });

        for (List<Integer> p : ans) {
            for (int i = 0; i < p.size(); ++i) {
                if (i > 0) System.out.print(" ");
                System.out.print(p.get(i));
            }
            System.out.println();
        }

        scanner.close();
    }

    static void dfs(int u, int s, List<Integer> path) {
        boolean isLeaf = true;
        for (int i = 0; i < n; ++i) {
            if (g[u][i]) {
                isLeaf = false;
                break;
            }
        }

        if (isLeaf) {
            if (s == S) ans.add(new ArrayList<>(path));
        } else {
            for (int i = 0; i < n; ++i) {
                if (g[u][i]) {
                    path.add(w[i]);
                    dfs(i, s + w[i], path);
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}