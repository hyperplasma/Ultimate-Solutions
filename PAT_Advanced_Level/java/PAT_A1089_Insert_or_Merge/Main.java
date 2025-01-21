package PAT_A1089_Insert_or_Merge;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static final int N = 110;
    static int n;
    static int[] a = new int[N];
    static int[] b = new int[N];
    static boolean isInsert = true;

    static boolean check() {
        for (int i = 0; i < n; ++i) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; ++i) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; ++i) {
            b[i] = sc.nextInt();
        }
        sc.close();

        int k = 0;
        while (k < n - 1 && b[k] <= b[k + 1]) {
            k++;
        }

        for (int i = k + 1; i < n; ++i) {
            if (a[i] != b[i]) {
                isInsert = false;
                break;
            }
        }

        if (isInsert) {
            System.out.println("Insertion Sort");

            int[] temp = Arrays.copyOf(b, n);
            Arrays.sort(temp, 0, k + 2);
            for (int i = 0; i < n; ++i) {
                if (i > 0) System.out.print(" ");
                System.out.print(temp[i]);
            }
        } else {
            System.out.println("Merge Sort");

            int k2 = 1;
            while (true) {
                boolean match = check();

                int len = (int) Math.pow(2, k2);
                for (int i = 0; i < n; i += len) {
                    Arrays.sort(a, i, Math.min(n, i + len));
                }

                if (match) break;
                k2++;
            }

            for (int i = 0; i < n; ++i) {
                if (i > 0) System.out.print(" ");
                System.out.print(a[i]);
            }
        }
    }
}