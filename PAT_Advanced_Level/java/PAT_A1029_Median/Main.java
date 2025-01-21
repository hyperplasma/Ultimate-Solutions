package PAT_A1029_Median;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // 序列1
        String[] line = reader.readLine().split(" ");
        int N1 = Integer.parseInt(line[0]);
        long[] num1 = new long[N1 + 1];
        for (int i = 0; i < N1; i++)
            num1[i] = Long.parseLong(line[i + 1]);

        // 序列2
        line = reader.readLine().split(" ");
        int N2 = Integer.parseInt(line[0]);
        long[] num2 = new long[N2 + 1];
        for (int i = 0; i < N2; i++)
            num2[i] = Long.parseLong(line[i + 1]);

        // 序列最后一个元素置INF
        num1[N1] = num2[N2] = Long.MAX_VALUE;

        int cnt = 0, i = 0, j = 0;
        while (cnt < (N1 + N2 - 1) / 2) {
            if (num1[i] < num2[j]) {
                i++;
            } else {
                j++;
            }
            cnt++;
        }

        // 输出两个序列当前位置较小的元素
        System.out.println(Math.min(num1[i], num2[j]));
    }
}
