package PAT_A1152_Google_Recruitment;

import java.io.*;
import java.util.*;

public class Main {
    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= n / i; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int len = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();

        for (int i = 0; i <= len - k; i++) {
            String substr = s.substring(i, i + k);
            int num = Integer.parseInt(substr);

            if (isPrime(num)) {
                System.out.println(substr);
                return;
            }
        }

        System.out.println("404");
    }
}