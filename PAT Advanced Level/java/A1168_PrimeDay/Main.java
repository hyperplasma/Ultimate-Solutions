package A1168_PrimeDay;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean allPrime = true;

    static boolean isPrime(String numStr) {
        if (numStr.isEmpty()) {
            return false;
        }

        int num = Integer.parseInt(numStr);
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= num / i; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String numStr = br.readLine();

        while (!numStr.isEmpty()) {
            System.out.print(numStr);

            if (isPrime(numStr)) {
                System.out.println(" Yes");
            } else {
                System.out.println(" No");
                allPrime = false;
            }

            numStr = numStr.substring(1);
        }

        if (allPrime) {
            System.out.println("All Prime!");
        }
    }
}
