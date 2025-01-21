package PAT_A1009_Product_of_Polynomials;

import java.util.Scanner;

public class Main {
    private static final int N = 1010;
    private static double[] a = new double[N];
    private static double[] b = new double[N];
    private static double[] c = new double[N * 2];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        input(a, scanner);
        input(b, scanner);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                c[i + j] += b[i] * a[j];
            }
        }

        int k = 0;
        for (int i = 0; i < N * 2; i++) {
            if (c[i] != 0) k++;
        }

        System.out.print(k);
        for (int i = N * 2 - 1; i >= 0; i--) {
            if (c[i] != 0) {
                System.out.printf(" %d %.1f", i, c[i]);
            }
        }
    }

    private static void input(double[] arr, Scanner scanner) {
        int k = scanner.nextInt();
        while (k-- > 0) {
            int n = scanner.nextInt();
            double v = scanner.nextDouble();
            arr[n] = v;
        }
    }
}