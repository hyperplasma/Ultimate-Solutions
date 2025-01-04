package A1010_Radix;

import java.util.Scanner;

public class Main {
    private static final long INF = (long) 1e18;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n1 = scanner.next();
        String n2 = scanner.next();
        int tag = scanner.nextInt();
        int radix = scanner.nextInt();

        if (tag == 2) {
            String temp = n1;
            n1 = n2;
            n2 = temp;
        }

        long target = calc(n1, radix);

        long l = 0, r = Math.max(target, 36L);
        for (char c : n2.toCharArray()) {
            l = Math.max(l, get(c) + 1);
        }

        while (l < r) {
            long mid = (l + r) >> 1;
            if (calc(n2, mid) >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        if (calc(n2, r) != target) {
            System.out.println("Impossible");
        } else {
            System.out.println(r);
        }
    }

    private static long get(char c) {
        if (c <= '9') {
            return c - '0';
        }
        return c - 'a' + 10;
    }

    private static long calc(String n, long r) {
        long res = 0;
        for (char c : n.toCharArray()) {
            if ((double) res * r + get(c) > 1e16) {
                return INF;
            }
            res = res * r + get(c);
        }
        return res;
    }
}