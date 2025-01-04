package A1065_APlusBAndC64bit;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 1; i <= t; i++) {
            BigInteger a = sc.nextBigInteger();
            BigInteger b = sc.nextBigInteger();
            BigInteger c = sc.nextBigInteger();
            if (a.add(b).compareTo(c) > 0) {
                System.out.println("Case #" + i + ": true");
            } else {
                System.out.println("Case #" + i + ": false");
            }
        }
    }
}
