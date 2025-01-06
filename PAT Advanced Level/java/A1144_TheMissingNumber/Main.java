package A1144_TheMissingNumber;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Set<Integer> s = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (x > 0) {
                s.add(x);
            }
        }

        for (int x = 1; ; x++) {
            if (!s.contains(x)) {
                System.out.print(x);
                break;
            }
        }
    }
}
