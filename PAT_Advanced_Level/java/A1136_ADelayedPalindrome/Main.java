package A1136_ADelayedPalindrome;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();

        if (isPalindromic(s1)) {
            System.out.println(s1 + " is a palindromic number.");
        } else {
            int cnt = 0;
            boolean flag = false;
            while (cnt < 10) {
                String s2 = new StringBuilder(s1).reverse().toString();

                BigInteger a = new BigInteger(s1);
                BigInteger b = new BigInteger(s2);
                BigInteger c = a.add(b);

                String s3 = c.toString();

                System.out.println(s1 + " + " + s2 + " = " + s3);
                if (isPalindromic(s3)) {
                    System.out.println(s3 + " is a palindromic number.");
                    flag = true;
                    break;
                }
                cnt++;
                s1 = s3;
            }

            if (!flag) {
                System.out.println("Not found in 10 iterations.");
            }
        }
        sc.close();
    }

    static boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}