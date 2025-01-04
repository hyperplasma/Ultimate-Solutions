package A1008_Elevator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int res = 0, cur = 0;
        while (n-- > 0) {
            int x = scanner.nextInt();
            if (cur - x < 0) {
                res += (x - cur) * 6 + 5;
            } else {
                res += (cur - x) * 4 + 5;
            }
            cur = x;
        }

        System.out.println(res);
    }
}
