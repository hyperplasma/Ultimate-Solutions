package A1031_HelloWorldForU;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int n1 = (str.length() + 2) / 3, n2 = str.length() + 2 - 2 * n1;

        int i = 0;
        for (int j = 0; j < n1 - 1; j++) {
            System.out.print(str.charAt(i++));
            for (int k = 0; k < n2 - 2; k++) {
                System.out.print(" ");
            }
            System.out.print(str.charAt(str.length() - i));
            System.out.println();
        }

        for (int k = 0; k < n2; k++) {
            System.out.print(str.charAt(i++));
        }
    }
}
