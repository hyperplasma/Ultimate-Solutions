package PAT_A1112_Stucked_Keyboard;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.next();
        sc.close();

        HashSet<Character> set = new HashSet<>();
        boolean[] flag = new boolean[256];
        boolean[] isOut = new boolean[256];
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < s.length(); ++i) {
            int j = i, cnt = 0;
            while (j < s.length() && s.charAt(j) == s.charAt(i)) {
                j++;
                cnt++;
            }

            if (!flag[s.charAt(i)] && cnt % k == 0) {
                set.add(s.charAt(i));
            } else {
                flag[s.charAt(i)] = true;
                set.remove(s.charAt(i));
            }

            i = j - 1;
        }

        for (int i = 0; i < s.length(); ++i) {
            if (!set.contains(s.charAt(i))) {
                res.append(s.charAt(i));
            } else {
                res.append(s.charAt(i));
                if (!isOut[s.charAt(i)]) {
                    isOut[s.charAt(i)] = true;
                    System.out.print(s.charAt(i));
                }

                int j = i + 1, cnt = 0;
                while (j < s.length() && s.charAt(j) == s.charAt(i) && cnt < k) {
                    j++;
                    cnt++;
                }
                i = j - 1;
            }
        }
        System.out.println();
        System.out.println(res);
    }
}