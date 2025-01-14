package A1081_RationalSum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] fractions = br.readLine().split(" ");
        long numerator = 0, denominator = 1;

        for (String fraction : fractions) {
            String[] parts = fraction.split("/");
            long a = Long.parseLong(parts[0]);
            long b = Long.parseLong(parts[1]);

            long lcm = (denominator * b) / gcd(denominator, b);
            numerator = numerator * (lcm / denominator) + a * (lcm / b);
            denominator = lcm;

            long commonDivisor = gcd(Math.abs(numerator), denominator);
            numerator /= commonDivisor;
            denominator /= commonDivisor;
        }

        if (numerator == 0) {
            System.out.println("0");
        } else if (denominator == 1) {
            System.out.println(numerator);
        } else {
            long integerPart = numerator / denominator;
            numerator %= denominator;
            if (integerPart != 0) {
                System.out.print(integerPart + " ");
            }
            System.out.println(numerator + "/" + denominator);
        }

        br.close();
    }
}