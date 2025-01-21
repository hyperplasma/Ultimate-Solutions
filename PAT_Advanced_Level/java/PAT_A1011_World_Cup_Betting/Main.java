package PAT_A1011_World_Cup_Betting;

import java.util.Scanner;

public class Main {
    private static final String[] words = {"W ", "T ", "L "};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double res = 1.0;

        for (int i = 0; i < 3; i++) {
            double x, max_x = 0;
            int idx = 0;
            for (int j = 0; j < 3; j++) {
                x = scanner.nextDouble();
                if (x > max_x) {
                    max_x = x;
                    idx = j;
                }
            }
            res *= max_x;
            System.out.print(words[idx]);
        }

        System.out.printf("%.2f\n", (res * 0.65 - 1) * 2);
    }
}