package PAT_A1166_Summit;

import java.io.*;
import java.util.*;

public class Main {
    static final int N = 210;

    static int n, m;
    static boolean[][] g = new boolean[N][N];
    static boolean[] tag = new boolean[N];
    static int[] seq = new int[N];
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int head1 = Integer.parseInt(st.nextToken());
            int head2 = Integer.parseInt(st.nextToken());
            g[head1][head2] = g[head2][head1] = true;
            tag[head1] = tag[head2] = true;
        }

        int k = Integer.parseInt(br.readLine());
        for (int areaNum = 1; areaNum <= k; areaNum++) {
            set.clear();

            st = new StringTokenizer(br.readLine());
            int groupSize = Integer.parseInt(st.nextToken());
            for (int i = 0; i < groupSize; i++) {
                seq[i] = Integer.parseInt(st.nextToken());
                set.add(seq[i]);
            }

            boolean isComplete = true;
            for (int i = 0; i < groupSize && isComplete; i++) {
                for (int j = i + 1; j < groupSize; j++) {
                    if (!g[seq[i]][seq[j]]) {
                        isComplete = false;
                        break;
                    }
                }
            }
            if (!isComplete) {
                System.out.printf("Area %d needs help.%n", areaNum);
                continue;
            }

            boolean canAddMore = false;
            for (int i = 1; i <= n && !canAddMore; i++) {
                if (tag[i] && !set.contains(i)) {
                    boolean canAdd = true;
                    for (int j = 0; j < groupSize; j++) {
                        if (!g[i][seq[j]]) {
                            canAdd = false;
                            break;
                        }
                    }
                    if (canAdd) {
                        System.out.printf("Area %d may invite more people, such as %d.%n", areaNum, i);
                        canAddMore = true;
                    }
                }
            }
            if (!canAddMore) {
                System.out.printf("Area %d is OK.%n", areaNum);
            }
        }
    }
}
