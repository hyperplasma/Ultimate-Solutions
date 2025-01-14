package A1077_Kuchiguse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int N = 110;

    private static int n;
    private static String[] s = new String[N];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());

        for (int i = 0; i < n; ++i) {
            s[i] = reader.readLine();
        }

        for (int k = s[0].length(); k > 0; --k) { // k: 后缀的长度
            boolean success = true;
            String suffix = s[0].substring(s[0].length() - k);
            for (int i = 1; i < n; ++i) {
                if (s[i].length() < k || !s[i].substring(s[i].length() - k).equals(suffix)) {
                    success = false;
                    break;
                }
            }

            if (success) {
                System.out.println(suffix);
                return;
            }
        }

        System.out.println("nai");
    }
}
