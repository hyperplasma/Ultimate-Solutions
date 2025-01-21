package PAT_A1061_Dating;

import java.util.Scanner;

public class Main {
    static String[] day = {"", "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.next();
        String b = scanner.next();
        String c = scanner.next();
        String d = scanner.next();

        int flag = 0;
        for (int i = 0; ; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                if (flag == 0 && 'A' <= a.charAt(i) && a.charAt(i) <= 'G') {
                    System.out.print(day[a.charAt(i) - 'A' + 1]);
                    flag = 1;
                } else if (flag == 1) {
                    if ('0' <= a.charAt(i) && a.charAt(i) <= '9') {
                        System.out.printf(" %02d:", a.charAt(i) - '0');
                        break;
                    } else if ('A' <= a.charAt(i) && a.charAt(i) <= 'N') {
                        System.out.printf(" %02d:", 10 + a.charAt(i) - 'A');
                        break;
                    }
                }
            }
        }

        for (int i = 0; ; i++) {
            if (c.charAt(i) == d.charAt(i) && Character.isLetter(c.charAt(i))) {
                System.out.printf("%02d\n", i);
                break;
            }
        }

        scanner.close();
    }
}