package A1069_TheBlackHoleOfNumbers;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        do {
            num = blackHole(num);
        } while (num != 6174 && num != 0);
    }

    private static int blackHole(int n) {
        String s = Integer.toString(n);
        char[] c = s.toCharArray();
        Arrays.sort(c);
        int[] num = new int[4];
        for (int i = 0; i < c.length; i++) {
            num[3 - i] = c[c.length - i - 1] - '0';
        }

        int small = num[0] * 1000 + num[1] * 100 + num[2] * 10 + num[3];
        int big = num[3] * 1000 + num[2] * 100 + num[1] * 10 + num[0];
        int delta = big - small;
        if (big == delta) {
            System.out.printf("%04d - %04d = %04d", big, small, delta);
        } else {
            System.out.printf("%04d - %04d = %04d", big, small, delta);
        }
        if (delta != 6174 && delta != 0) {
            System.out.println();
        }
        return delta;
    }
}
