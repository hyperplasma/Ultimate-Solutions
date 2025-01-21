package PAT_A1107_Social_Clusters;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int N = 1010;
    static int[] p = new int[N];
    static int[] cnt = new int[N];
    static List<Integer>[] hobby = new ArrayList[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i < N; i++) {
            hobby[i] = new ArrayList<>();
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), ": ");
            int k = Integer.parseInt(tokenizer.nextToken());
            while (k-- > 0) {
                int h = Integer.parseInt(tokenizer.nextToken());
                hobby[h].add(i);
            }
        }

        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < hobby[i].size(); j++) {
                int a = hobby[i].get(0);
                int b = hobby[i].get(j);
                p[find(a)] = find(b);
            }
        }

        for (int i = 1; i <= n; i++) {
            cnt[find(i)]++;
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (cnt[i] > 0) {
                result.add(cnt[i]);
            }
        }

        result.sort(Collections.reverseOrder());

        System.out.println(result.size());
        for (int i = 0; i < result.size(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(result.get(i));
        }
        System.out.println();
    }

    static int find(int x) {
        if (p[x] != x) {
            p[x] = find(p[x]);
        }
        return p[x];
    }
}
