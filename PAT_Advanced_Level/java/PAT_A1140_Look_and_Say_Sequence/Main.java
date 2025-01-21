package PAT_A1140_Look_and_Say_Sequence;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int n = sc.nextInt();

        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int k = 0;
            for (int j = 0; j < a.length(); j++) {
                k++;
                if (j == a.length() - 1 || a.charAt(j) != a.charAt(j + 1)) {
                    sb.append(a.charAt(j)).append(k);
                    k = 0;
                }
            }
            a = sb.toString();
        }

        System.out.println(a);
        sc.close();
    }
}