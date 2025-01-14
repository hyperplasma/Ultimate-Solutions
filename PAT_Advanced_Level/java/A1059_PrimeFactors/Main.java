package A1059_PrimeFactors;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        System.out.print(n + "=");
        if (n == 1) {
            System.out.println("1");
        } else {
            boolean isFirst = true;
            for (int i = 2; i <= n / i; i++) {
                if (n % i == 0) {
                    int k = 0;
                    while (n % i == 0) {
                        n /= i;
                        k++;
                    }
                    if (!isFirst) System.out.print("*");
                    else isFirst = false;

                    System.out.print(i);
                    if (k > 1) System.out.print("^" + k);
                }
            }

            if (n > 1) {
                if (!isFirst) System.out.print("*");
                System.out.print(n);
            }
            System.out.println();
        }
    }
}