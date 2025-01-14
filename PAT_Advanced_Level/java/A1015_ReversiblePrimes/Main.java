package A1015_ReversiblePrimes;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            int n = scanner.nextInt();
            if (n < 0) break;
            int m = scanner.nextInt();

            if (!isPrime(n)) {
                System.out.println("No");
            } else {
                String str = Integer.toString(n, m); // 10 -> r
                int value = translate(str, m);
                if (isPrime(value)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No");
                }
            }
        }
    }

    public static int translate(String n, int r) {
        int sum = 0;
        for (int i = n.length() - 1; i >= 0; i--) {
            sum = sum * r + (n.charAt(i) - '0');
        }
        return sum;
    }

    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= number / i; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}
