package PAT_A1169_The_Judger;

import java.io.*;
import java.util.*;

/**
 * 测试点5超时
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t1 = Integer.parseInt(st.nextToken());
        int t2 = Integer.parseInt(st.nextToken());
        Set<Integer> set = new HashSet<>();
        set.add(t1);
        set.add(t2);

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] p = new int[n + 1][m + 1];
        boolean[] isOut = new boolean[n + 1];

        for (int i = 1; i <= n; ++i) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; ++j) {
                p[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 1; j <= m; ++j) {
            List<Integer> out = new ArrayList<>();

            for (int i = 1; i <= n; ++i) {
                if (!isOut[i]) {
                    int x = p[i][j];
                    if (check(x, set)) {
                        set.add(x);
                    } else {
                        isOut[i] = true;
                        out.add(i);
                    }
                }
            }

            if (!out.isEmpty()) {
                Collections.sort(out);
                for (int i : out) {
                    System.out.printf("Round #%d: %d is out.\n", j, i);
                }
            }
        }

        List<Integer> win = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            if (!isOut[i]) {
                win.add(i);
            }
        }

        if (win.isEmpty()) {
            System.out.println("No winner.");
        } else {
            Collections.sort(win);
            System.out.print("Winner(s):");
            for (int i : win) {
                System.out.print(" " + i);
            }
            System.out.println();
        }
    }

    private static boolean check(int x, Set<Integer> set) {
        if (set.contains(x)) {
            return false;
        }
        for (int it : set) {
            if (set.contains(x + it)) {
                return true;
            }
        }
        return false;
    }
}
