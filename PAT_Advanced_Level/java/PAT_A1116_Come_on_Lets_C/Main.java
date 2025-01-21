package PAT_A1116_Come_on_Lets_C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 测试点1、2超时
 */
public class Main {
    static final int N = 10010;
    static int[] award = new int[N];
    static boolean[] isChecked = new boolean[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine().trim());
        for (int i = 0, cnt = 1; i < n; ++i, ++cnt) {
            int x = Integer.parseInt(reader.readLine().trim());

            if (cnt == 1) {
                award[x] = 3;
            } else if (isPrime(cnt)) {
                award[x] = 2;
            } else {
                award[x] = 1;
            }
        }

        int Q = Integer.parseInt(reader.readLine().trim());
        while (Q-- > 0) {
            int x = Integer.parseInt(reader.readLine().trim());

            System.out.printf("%04d: ", x);
            if (isChecked[x]) {
                System.out.println("Checked");
            } else if (award[x] == 0) {
                System.out.println("Are you kidding?");
            } else {
                if (award[x] == 3) {
                    System.out.println("Mystery Award");
                } else if (award[x] == 2) {
                    System.out.println("Minion");
                } else {
                    System.out.println("Chocolate");
                }
                isChecked[x] = true;
            }
        }
    }

    static boolean isPrime(int n) {
        if (n <= 1) return false;

        for (int i = 2; i <= n / i; ++i) {
            if (n % i == 0) return false;
        }

        return true;
    }
}