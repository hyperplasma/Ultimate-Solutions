package PAT_A1023_Have_Fun_with_Numbers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        List<Integer> a = new ArrayList<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            a.add(s.charAt(i) - '0');
        }

        List<Integer> b = new ArrayList<>();
        int t = 0;
        for (Integer integer : a) {
            int sum = integer + integer + t;
            b.add(sum % 10);
            t = sum / 10;
        }
        if (t != 0) {
            b.add(t);
        }

        List<Integer> c = new ArrayList<>(b);
        Collections.sort(a);
        Collections.sort(c);
        if (a.equals(c)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        for (int i = b.size() - 1; i >= 0; i--) {
            System.out.print(b.get(i));
        }
    }
}