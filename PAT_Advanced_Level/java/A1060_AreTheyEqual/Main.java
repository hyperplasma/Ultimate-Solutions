package A1060_AreTheyEqual;

import java.util.Scanner;

/**
 * 测试点6错误，原因不明
 */
public class Main {
    static int n;

    public static void convert(StringBuilder s) {
        int k = 0;
        while (k < s.length() && s.charAt(k) != '.') {
            k++;
        }

        // If '.' is not found, append it at the end
        if (k == s.length()) {
            s.append('.');
        } else {
            // Remove the dot from its current position
            s.deleteCharAt(k);
        }

        // Remove leading zeros
        while (s.length() > 0 && s.charAt(0) == '0') {
            s.deleteCharAt(0);
            k--;
        }

        // Pad with zeros to match length n
        while (s.length() < n) {
            s.append('0');
        }

        // Trim to length n
        s.setLength(n);

        // Check if the number is zero after conversion
        double num = Double.parseDouble(s.toString());
        if (num == 0) {
            k = 0;
        }

        // Format the result string
        s.insert(0, "0.");
        s.append("*10^" + k);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        String a = scanner.next();
        String b = scanner.next();

        StringBuilder sa = new StringBuilder(a);
        StringBuilder sb = new StringBuilder(b);

        convert(sa);
        convert(sb);

        if (sa.toString().equals(sb.toString())) {
            System.out.println("YES " + sa.toString());
        } else {
            System.out.println("NO " + sa.toString() + " " + sb.toString());
        }

        scanner.close();
    }
}
