package A1006_SignInAndSignOut;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.nextLine(); // 读取换行符

        String open_id = "";
        String open_time = "";
        String close_id = "";
        String close_time = "";

        for (int i = 0; i < m; i++) {
            String id = scanner.next();
            String in_time = scanner.next();
            String out_time = scanner.next();

            if (i == 0 || in_time.compareTo(open_time) < 0) { // 更新开门的人
                open_id = id;
                open_time = in_time;
            }

            if (i == 0 || out_time.compareTo(close_time) > 0) { // 更新锁门的人
                close_id = id;
                close_time = out_time;
            }
        }

        System.out.println(open_id + " " + close_id);
    }
}