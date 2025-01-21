package PAT_A1035_Password;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Account {
        String id;
        String password;

        Account(String id, String password) {
            this.id = id;
            this.password = password;
        }
    }

    public static boolean modify(StringBuilder pswd) {
        boolean modified = false;
        for (int i = 0; i < pswd.length(); ++i) {
            char ch = pswd.charAt(i);
            if (ch == '1') {
                pswd.setCharAt(i, '@');
                modified = true;
            } else if (ch == '0') {
                pswd.setCharAt(i, '%');
                modified = true;
            } else if (ch == 'l') {
                pswd.setCharAt(i, 'L');
                modified = true;
            } else if (ch == 'O') {
                pswd.setCharAt(i, 'o');
                modified = true;
            }
        }
        return modified;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine(); // consume the newline character

        List<Account> accounts = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            String id = scanner.next();
            StringBuilder password = new StringBuilder(scanner.next());
            if (modify(password)) {
                accounts.add(new Account(id, password.toString()));
            }
        }
        scanner.close();

        if (accounts.isEmpty()) {
            if (n == 1) {
                System.out.println("There is 1 account and no account is modified");
            } else {
                System.out.printf("There are %d accounts and no account is modified\n", n);
            }
        } else {
            System.out.println(accounts.size());
            for (Account account : accounts) {
                System.out.println(account.id + " " + account.password);
            }
        }
    }
}
