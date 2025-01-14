package A1132_CutInteger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        while (n-- > 0) {
            String s = br.readLine();

            long z = Long.parseLong(s);
            int len = s.length() / 2;
            long a = Long.parseLong(s.substring(0, len));
            long b = Long.parseLong(s.substring(len));

            if (a * b != 0 && z % (a * b) == 0) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

        br.close();
    }
}