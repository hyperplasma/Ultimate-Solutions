package A1078_Hashing;

import java.io.*;

public class Main {
    static final int MAX_SIZE = 100010;
    static int[] hash = new int[MAX_SIZE];
    static int[] pos = new int[MAX_SIZE];

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= n / i; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    static int getNextPrime(int n) {
        while (!isPrime(n)) {
            n++;
        }
        return n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        int mSize = Integer.parseInt(parts[0]);
        int n = Integer.parseInt(parts[1]);

        mSize = getNextPrime(mSize);

        String[] numbers = br.readLine().split(" ");
        for (int i = 0; i < n; ++i) {
            int x = Integer.parseInt(numbers[i]);

            int t = x % mSize;
            int step = 0;
            boolean success = false;
            while (step <= mSize) {
                int ad = (t + step * step) % mSize;
                if (hash[ad] == 0) {
                    hash[ad] = x;
                    pos[i] = ad;
                    success = true;
                    break;
                }
                step++;
            }

            if (!success) pos[i] = -1;
        }

        for (int i = 0; i < n; ++i) {
            if (i > 0) {
                System.out.print(" ");
            }
            if (pos[i] == -1) {
                System.out.print("-");
            } else {
                System.out.print(pos[i]);
            }
        }

        br.close();
    }
}
