package A1092_ToBuyOrNotToBuy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        scanner.close();

        Map<Character, Integer> mp = new HashMap<>();

        for (char c : a.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) + 1);
        }

        for (char c : b.toCharArray()) {
            mp.put(c, mp.getOrDefault(c, 0) - 1);
        }

        int n1 = 0, n2 = 0;
        for (Map.Entry<Character, Integer> entry : mp.entrySet()) {
            int count = entry.getValue();
            if (count > 0) {
                n1 += count;
            } else if (count < 0) {
                n2 -= count;
            }
        }

        if (n2 > 0) {
            System.out.println("No " + n2);
        } else {
            System.out.println("Yes " + n1);
        }
    }
}