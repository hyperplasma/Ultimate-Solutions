package A1117_EddingtonNumber;

import java.io.*;
import java.util.Arrays;

/**
 * 测试点3超时
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int n = Integer.parseInt(reader.readLine());
        int[] a = new int[n];

        String[] input = reader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(a);

        for (int i = n; i > 0; i--) {
            if (a[n - i] > i) {
                writer.println(i);
                writer.flush();
                return;
            }
        }

        writer.println(0);
        writer.flush();
        reader.close();
    }
}