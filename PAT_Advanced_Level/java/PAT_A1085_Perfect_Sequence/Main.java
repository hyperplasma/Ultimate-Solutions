package PAT_A1085_Perfect_Sequence;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 测试点4超时
 */
public class Main {
    static final int N = 100010;
    static int n, p;
    static int[] a = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        p = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; ++i) {
            a[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(a, 0, n);

        int res = 0;
        for (int i = 0, j = 0; i < n; ++i) {    // j: M, i: m
            while ((long) a[j] * p < a[i]) j++;
            res = Math.max(res, i - j + 1);
        }
        System.out.println(res);

        reader.close();
    }
}