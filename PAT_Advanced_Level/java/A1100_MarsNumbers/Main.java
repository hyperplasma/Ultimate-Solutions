package A1100_MarsNumbers;

import java.util.*;

public class Main {
    static String[] low = {
        "tret", "jan", "feb", "mar", "apr", "may",
        "jun", "jly", "aug", "sep", "oct", "nov", "dec"
    };
    static String[] high = {
        "", "tam", "hel", "maa", "huh", "tou", "kes",
        "hei", "elo", "syy", "lok", "mer", "jou"
    };

    static Map<String, Integer> map = new HashMap<>();
    static int n;
    static String s;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();  // consume the newline character

        for (int i = 0; i < 13; i++) {
            map.put(low[i], i);
            map.put(high[i], 13 * i);
        }

        for (int i = 0; i < n; i++) {
            s = sc.nextLine();
            if (Character.isDigit(s.charAt(0))) {
                int digit = Integer.parseInt(s);
                int n1 = digit / 13, n2 = digit % 13;
                if (n1 > 0) {
                    System.out.print(high[n1]);
                    if (n2 > 0) System.out.print(" " + low[n2]);
                } else {
                    System.out.print(low[n2]);
                }
                System.out.println();
            } else {
                String[] parts = s.split(" ");
                if (parts.length == 1) {
                    System.out.println(map.get(parts[0]));
                } else {
                    System.out.println(map.get(parts[0]) + map.get(parts[1]));
                }
            }
        }
        sc.close();
    }
}