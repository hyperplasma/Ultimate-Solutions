package A1024_PalindromicNumber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    // 检查是否为回文数
    public static boolean isPalindromic(List<Integer> num) {
        for (int i = 0, j = num.size() - 1; i < j; i++, j--) {
            if (!num.get(i).equals(num.get(j))) {
                return false;
            }
        }
        return true;
    }

    // 大数加法
    public static List<Integer> add(List<Integer> a, List<Integer> b) {
        List<Integer> c = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < a.size() || i < b.size() || t > 0; i++) {
            int s = t;
            if (i < a.size()) s += a.get(i);
            if (i < b.size()) s += b.get(i);
            c.add(s % 10);
            t = s / 10;
        }
        return c;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String n = input[0];
        int k = Integer.parseInt(input[1]);

        List<Integer> a = new ArrayList<>();
        for (int i = n.length() - 1; i >= 0; i--) {
            a.add(n.charAt(i) - '0');
        }

        int cnt = 0;
        if (!isPalindromic(a)) {
            while (cnt < k) {
                List<Integer> b = new ArrayList<>(a);
                Collections.reverse(b);
                a = add(a, b);
                cnt++;
                if (isPalindromic(a)) break;
            }
        }

        for (int i = a.size() - 1; i >= 0; i--) {
            System.out.print(a.get(i));
        }

        System.out.println();
        System.out.println(cnt);
    }
}