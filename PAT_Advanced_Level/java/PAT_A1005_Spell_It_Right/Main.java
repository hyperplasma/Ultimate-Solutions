package PAT_A1005_Spell_It_Right;

import java.util.Scanner;

public class Main {
    private static final String[] words = {
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine",
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.next();
        int sum = 0;

        for (int i = 0; i < n.length(); i++) {
            sum += n.charAt(i) - '0';
        }

        String s = Integer.toString(sum);
        for (int i = 0; i < s.length(); i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(words[s.charAt(i) - '0']);
        }
    }
}