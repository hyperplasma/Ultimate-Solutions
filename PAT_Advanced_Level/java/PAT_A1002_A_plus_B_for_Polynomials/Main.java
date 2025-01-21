package PAT_A1002_A_plus_B_for_Polynomials;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final int N = 1010;
    private static double[] a = new double[N];
    private static double[] b = new double[N];
    private static List<Pair> c = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        input(scanner, a);
        input(scanner, b);

        for (int i = N - 1; i >= 0; i--) {
            if (a[i] + b[i] != 0) {
                c.add(new Pair(i, a[i] + b[i]));
            }
        }

        System.out.print(c.size());
        for (Pair pair : c) {
            System.out.printf(" %d %.1f", pair.exponent, pair.coefficient);
        }
    }

    private static void input(Scanner scanner, double[] array) {
        int n = scanner.nextInt();
        while (n-- > 0) {
            int exponent = scanner.nextInt();
            double coefficient = scanner.nextDouble();
            array[exponent] = coefficient;
        }
    }

    private static class Pair {
        int exponent;
        double coefficient;

        Pair(int exponent, double coefficient) {
            this.exponent = exponent;
            this.coefficient = coefficient;
        }
    }
}