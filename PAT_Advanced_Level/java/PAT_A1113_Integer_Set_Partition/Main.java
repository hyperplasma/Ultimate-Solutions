package PAT_A1113_Integer_Set_Partition;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 测试点2、3超时
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long[] a = new long[n];

        String[] inputs = reader.readLine().split(" ");
        for (int i = 0; i < n; ++i) {
            a[i] = Long.parseLong(inputs[i]);
        }
        reader.close();

        Arrays.sort(a);

        int i, n1 = 0, n2 = 0;
        long sum1 = 0, sum2 = 0;
        for (i = 0; i < n / 2; ++i) {
            sum1 += a[i];
            n1++;
        }
        for (; i < n; ++i) {
            sum2 += a[i];
            n2++;
        }

        System.out.println(Math.abs(n1 - n2) + " " + Math.abs(sum1 - sum2));
    }
}
