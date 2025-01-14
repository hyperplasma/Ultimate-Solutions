package A1082_ReadNumberInChinese;

import java.io.*;
import java.util.*;

public class Main {
    static String[] num1 = {
            "ling", "yi", "er", "san", "si",
            "wu", "liu", "qi", "ba", "jiu",
    };
    static String[] num2 = {"", "Shi", "Bai", "Qian"};
    static String[] num3 = {"", "Wan", "Yi"};

    static boolean checkLing(String s) {
        return s.endsWith("ling ");
    }

    static String convert(int n) {
        List<Integer> nums = new ArrayList<>();
        while (n > 0) {
            nums.add(n % 10);
            n /= 10;
        }

        StringBuilder res = new StringBuilder();
        for (int i = nums.size() - 1; i >= 0; --i) {
            int t = nums.get(i);
            if (t != 0) res.append(num1[t]).append(" ");
            else if (!checkLing(res.toString())) res.append("ling ");
            if (t != 0 && i > 0) res.append(num2[i]).append(" ");
        }

        while (checkLing(res.toString())) res = new StringBuilder(res.substring(0, res.length() - 5));
        return res.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println("ling");
        } else {
            if (n < 0) {
                System.out.print("Fu ");
                n = -n;
            }

            List<Integer> nums = new ArrayList<>();
            while (n > 0) {
                nums.add(n % 10000);
                n /= 10000;
            }

            StringBuilder res = new StringBuilder();
            for (int i = nums.size() - 1; i >= 0; --i) {
                int t = nums.get(i);
                if (res.length() > 0 && t < 1000 &&
                        !(res.length() >= 5 && res.substring(res.length() - 5).equals("ling ")))
                    res.append("ling ");
                if (t != 0) res.append(convert(t));
                if (t != 0 && i > 0) res.append(num3[i]).append(" ");
            }

            while (checkLing(res.toString())) res = new StringBuilder(res.substring(0, res.length() - 5));
            if (res.length() > 0) res.setLength(res.length() - 1);
            System.out.println(res);
        }

        br.close();
    }
}