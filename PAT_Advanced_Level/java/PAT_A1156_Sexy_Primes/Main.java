package PAT_A1156_Sexy_Primes;

import java.util.Scanner;

public class Main {
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static int findNextSexyPrime(int n) {
        for (int m = n + 1; ; m++) {
            if (isPrime(m) && (isPrime(m - 6) || isPrime(m + 6))) {
                return m;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (isPrime(n)) {
            if (isPrime(n - 6)) {
                System.out.println("Yes");
                System.out.println(n - 6);
            } else if (isPrime(n + 6)) {
                System.out.println("Yes");
                System.out.println(n + 6);
            } else {
                int nextSexyPrime = findNextSexyPrime(n);
                System.out.println("No");
                System.out.println(nextSexyPrime);
            }
        } else {
            int nextSexyPrime = findNextSexyPrime(n);
            System.out.println("No");
            System.out.println(nextSexyPrime);
        }
    }
}
