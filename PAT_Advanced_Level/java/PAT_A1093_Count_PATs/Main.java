package PAT_A1093_Count_PATs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        br.close();

        long num = input.length();
        long cntT = 0, cntP = 0, ans = 0;

        for (int i = 0; i < num; i++) {
            if (input.charAt(i) == 'T') {
                cntT++;
            }
        }

        for (int j = 0; j < num; j++) {
            char ch = input.charAt(j);
            if (ch == 'A') {
                ans = (ans + cntP * cntT) % MOD;
            } else if (ch == 'P') {
                cntP++;
            } else if (ch == 'T') {
                cntT--;
            }
        }

        System.out.println(ans);
    }
}