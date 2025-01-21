package PAT_A1124_Raffle_for_Weibo_Followers;

import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 0x3f3f3f3f;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");

        int n = Integer.parseInt(line[0]);  // 总人数
        int k = Integer.parseInt(line[1]);  // 等待
        int S = Integer.parseInt(line[2]);  // Start

        Set<String> set = new HashSet<>();
        boolean flag = false;
        int cnt = INF;

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();

            if (i == S) {
                System.out.println(s);
                flag = true;
                set.add(s);
                cnt = 0;
                continue;
            }

            if (!set.contains(s)) {
                cnt++;
            }
            if (cnt == k) {
                System.out.println(s);
                set.add(s);
                cnt = 0;
            }
        }

        if (!flag) {
            System.out.println("Keep going...");
        }

        br.close();
    }
}