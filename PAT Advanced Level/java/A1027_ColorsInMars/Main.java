package A1027_ColorsInMars;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = scanner.nextInt();
        }

        System.out.print('#');
        for (int i = 0; i < 3; i++) {
            System.out.print(get(a[i] / 13));
            System.out.print(get(a[i] % 13));
        }
    }

    private static char get(int x) {
        if (x <= 9) return (char) ('0' + x);
        return (char) ('A' + x - 10);
    }
}