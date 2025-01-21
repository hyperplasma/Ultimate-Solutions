package PAT_A1001_A_plus_B_Format;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = reader.readLine().split(" ");
        long a = Long.parseLong(strs[0]);
        long b = Long.parseLong(strs[1]);
        long c = a + b;

        if (c == 0) {
            System.out.println(0);
        } else {
            if (c < 0) {
                System.out.print("-");
                c *= -1;
            }

            StringBuilder res = new StringBuilder();
            int i = 1;
            while (c > 0) {
                res.append(c % 10);
                c /= 10;
                if (c > 0 && i % 3 == 0) {
                    res.append(",");
                }
                i++;
            }

            for (i = res.length() - 1; i >= 0; i--) {
                System.out.print(res.charAt(i));
            }
        }
    }
}