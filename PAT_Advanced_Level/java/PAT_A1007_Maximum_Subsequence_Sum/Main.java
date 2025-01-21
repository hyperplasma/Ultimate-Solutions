package PAT_A1007_Maximum_Subsequence_Sum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int N = 10010;
    private static int[] a = new int[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            a[i] = Integer.parseInt(input[i - 1]);
        }

        int l = 1, r = 1, width = r - l;
        int thisSum = -1, maxSum = -1;

        for (int i = 1, start = 1; i <= n; i++) {
            if (thisSum < 0) {
                thisSum = 0;
                start = i;
            }

            thisSum += a[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
                l = start;
                r = i;
            }
        }

        if (maxSum < 0) {
            System.out.printf("0 %d %d\n", a[1], a[n]);
        } else {
            System.out.printf("%d %d %d\n", maxSum, a[l], a[r]);
        }
    }
}