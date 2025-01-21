package PAT_A1155_Heap_Paths;

import java.io.*;
import java.util.*;

public class Main {
    static int[] tree;
    static int n;
    static List<Integer> path = new ArrayList<>();
    static boolean isGreater = false;
    static boolean isLess = false;

    static void dfs(int u) {
        path.add(tree[u]);

        if (2 * u > n) {
            for (int i = 0; i < path.size(); i++) {
                if (i > 0) System.out.print(" ");
                System.out.print(path.get(i));
            }
            System.out.println();
        }

        if (2 * u + 1 <= n) {
            if (tree[2 * u + 1] < tree[u]) {
                isGreater = true;
            } else {
                isLess = true;
            }
            dfs(2 * u + 1);
        }

        if (2 * u <= n) {
            if (tree[2 * u] < tree[u]) {
                isGreater = true;
            } else {
                isLess = true;
            }
            dfs(2 * u);
        }

        path.remove(path.size() - 1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        tree = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
        }

        dfs(1);

        if (isGreater && !isLess) {
            System.out.println("Max Heap");
        } else if (!isGreater && isLess) {
            System.out.println("Min Heap");
        } else {
            System.out.println("Not Heap");
        }
    }
}