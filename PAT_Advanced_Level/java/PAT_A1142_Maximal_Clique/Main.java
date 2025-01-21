package PAT_A1142_Maximal_Clique;

import java.io.*;
import java.util.*;

public class Main {
    static final int N = 210;
    static int n, m;
    static boolean[][] g = new boolean[N][N];
    static int[] seq = new int[N];
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        String[] nm = reader.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        for (int i = 0; i < m; i++) {
            String[] edge = reader.readLine().split(" ");
            int a = Integer.parseInt(edge[0]);
            int b = Integer.parseInt(edge[1]);
            g[a][b] = g[b][a] = true;
        }

        int Q = Integer.parseInt(reader.readLine());
        while (Q-- > 0) {
            set.clear();

            String[] query = reader.readLine().split(" ");
            int k = Integer.parseInt(query[0]);
            for (int i = 0; i < k; i++) {
                seq[i] = Integer.parseInt(query[i + 1]);
                set.add(seq[i]);
            }

            int flag = 2;
            for (int i = 0; i < k; i++) {
                for (int j = i; j < k; j++) {
                    if (i != j && !g[seq[i]][seq[j]]) {
                        flag = 0;
                        break;
                    }
                }
                if (flag == 0) break;
            }
            if (flag == 2) {
                for (int v = 1; v <= n; v++) {
                    if (!set.contains(v)) {
                        boolean isAdj = true;
                        for (int i = 0; i < k; i++) {
                            if (!g[v][seq[i]]) {
                                isAdj = false;
                                break;
                            }
                        }
                        if (isAdj) {
                            flag = 1;
                            break;
                        }
                    }
                }
            }
            if (flag == 2) {
                writer.println("Yes");
            } else if (flag == 1) {
                writer.println("Not Maximal");
            } else {
                writer.println("Not a Clique");
            }
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}
