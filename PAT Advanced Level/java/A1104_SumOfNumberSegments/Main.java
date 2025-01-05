package A1104_SumOfNumberSegments;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 测试点2、3超时
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());

        double res = 0;
        String[] inputs = reader.readLine().split(" ");
        for (int i = 1; i <= n; ++i) {
            double x = Double.parseDouble(inputs[i - 1]);
            res += x * i * (n - i + 1);
        }

        System.out.printf("%.2f", res);
    }
}