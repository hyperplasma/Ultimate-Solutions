package PAT_A1084_Broken_Keyboard;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        boolean[] st = new boolean[210];

        b += '#';
        int j = 0;
        for (int i = 0; i < a.length(); i++) {
            char x = Character.toUpperCase(a.charAt(i));
            char y = Character.toUpperCase(b.charAt(j));
            if (x == y) {
                j++;
            } else if (!st[x]) {
                System.out.print(x);
                st[x] = true;
            }
        }

        sc.close();
    }
}