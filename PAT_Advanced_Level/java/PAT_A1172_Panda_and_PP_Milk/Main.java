package PAT_A1172_Panda_and_PP_Milk;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int n = Integer.parseInt(line.trim());

        int[] w = new int[n];
        int[] m1 = new int[n];
        int[] m2 = new int[n];
        long sum;

        line = reader.readLine();
        String[] tokens = line.split(" ");
        for (int i = 0; i < n; ++i) {
            w[i] = Integer.parseInt(tokens[i]);
        }

        for (int i = 1; i < n; ++i) {
            if (w[i] > w[i - 1]) {
                m1[i] = m1[i - 1] + 1;
            } else if (w[i] == w[i - 1]) {
                m1[i] = m1[i - 1];
            } else {
                m1[i] = 0;
            }
        }

        for (int i = n - 2; i >= 0; --i) {
            if (w[i] > w[i + 1]) {
                m2[i] = m2[i + 1] + 1;
            } else if (w[i] == w[i + 1]) {
                m2[i] = m2[i + 1];
            } else {
                m2[i] = 0;
            }
        }

        sum = 200L * n;
        for (int i = 0; i < n; ++i) {
            sum += 100L * Math.max(m1[i], m2[i]);
        }

        System.out.println(sum);
    }
}
