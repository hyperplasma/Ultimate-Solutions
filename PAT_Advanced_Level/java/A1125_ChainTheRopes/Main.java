package A1125_ChainTheRopes;

import java.io.*;
import java.util.Arrays;

public class Main {
    static final int N = 10010;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 读取数组长度
        int n = Integer.parseInt(br.readLine());

        // 读取并解析数组
        int[] seq = new int[N];
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(inputs[i]);
        }

        // 排序
        Arrays.sort(seq, 0, n);

        // 计算结果
        double sum = seq[0];
        for (int i = 1; i < n; i++) {
            sum = (sum + seq[i]) / 2;
        }

        // 输出结果
        System.out.println((int) Math.floor(sum));

        br.close();
    }
}
