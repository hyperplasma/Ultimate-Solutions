package PAT_B1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    static String next() throws IOException {
        return in.readLine();
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(next());
        int n = Integer.parseInt(st.nextToken());
        while (n-- > 0) {
            st = new StringTokenizer(next());
            String string = st.nextToken();
            boolean flag = true;
            Map<Character, Integer> map = new HashMap<>();

            for (int i = 0; i < string.length(); i++) {
                char c = string.charAt(i);
                if (c != 'P' && c != 'A' && c != 'T') {
                    flag = false;
                }
                map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
                if ((null != map.get('P') && map.get('P') > 1) || (null != map.get('T') && map.get('T') > 1)) {
                    flag = false;
                }
            }
            if (flag) {
                int countP = string.indexOf('P');
                int countA = string.indexOf('A');
                int countT = string.indexOf('T');
                if (countP == -1 || countA == -1 || countT == -1) {
                    flag = false;
                } else {
                    if (map.get('A') == 1) {
                        flag = countP < countA && countA < countT;
                    }
                    if (flag) {
                        int A1 = string.substring(0, countP).length();
                        int A2 = string.substring(countP + 1, countT).length();
                        int A3 = string.substring(countT + 1).length();
                        flag = A1 * A2 == A3;
                    }
                }
            }
            System.out.println(flag ? "YES" : "NO");
        }
    }
}
