package PAT_A1088_Rational_Arithmetic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 测试点2、3错误
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = reader.readLine().split(" ");
        String[] s2 = s1[0].split("/");
        String[] s3 = s1[1].split("/");
        int a1 = Integer.parseInt(s2[0]);
        int b1 = Integer.parseInt(s2[1]);
        int a2 = Integer.parseInt(s3[0]);
        int b2 = Integer.parseInt(s3[1]);
        int c1 = gcd(a1, b1);
        int c2 = gcd(a2, b2);
        a1 = a1 / c1;
        b1 = b1 / c1;
        a2 = a2 / c2;
        b2 = b2 / c2;

        sum(a1, b1, a2, b2);
        System.out.println();
        difference(a1, b1, a2, b2);
        System.out.println();
        product(a1, b1, a2, b2);
        System.out.println();
        quotient(a1, b1, a2, b2);
    }

    private static void sum(int m1, int n1, int m2, int n2) {
        int mTemp = m1 * n2 + m2 * n1;
        int nTemp = n1 * n2;
        printSingleNum(m1, n1);
        System.out.print(" + ");
        printSecondNumAndResult(m2, n2, mTemp, nTemp);
    }

    private static void difference(int m1, int n1, int m2, int n2) {
        int mTemp = m1 * n2 - m2 * n1;
        int nTemp = n1 * n2;
        printSingleNum(m1, n1);
        System.out.print(" - ");
        printSecondNumAndResult(m2, n2, mTemp, nTemp);
    }

    private static void product(int m1, int n1, int m2, int n2) {
        int mTemp = m1 * m2;
        int nTemp = n1 * n2;
        if (m1 == 0) {
            System.out.print("0 * ");
            printSingleNum(m2, n2);
            System.out.print(" = 0");
        }
        if (m2 == 0) {
            printSingleNum(m1, n1);
            System.out.print(" * 0 = 0");
        } else {
            printSingleNum(m1, n1);
            System.out.print(" * ");
            printSecondNumAndResult(m2, n2, mTemp, nTemp);
        }
    }

    private static void quotient(int m1, int n1, int m2, int n2) {
        if (m2 != 0) {
            int mTemp = m1 * n2;
            int nTemp = m2 * n1;
            if (nTemp < 0) {
                mTemp = -mTemp;
                nTemp = -nTemp;
            }
            printSingleNum(m1, n1);
            System.out.print(" / ");
            printSecondNumAndResult(m2, n2, mTemp, nTemp);
        } else {
            printSingleNum(m1, n1);
            System.out.print(" / 0 = Inf");
        }
    }

    private static void printSingleNum(int m, int n) {
        if (m % n == 0) {
            if (m >= 0) {
                System.out.print(m / n);
            } else {
                System.out.printf("(%d)", m / n);
            }
        } else {
            if (Math.abs(m) > Math.abs(n)) {
                if (m >= 0) {
                    System.out.printf("%d %d/%d", m / n, m - m / n * n, n);
                } else {
                    m = -m;
                    System.out.printf("(-%d %d/%d)", m / n, m - m / n * n, n);
                }
            } else {
                if (m >= 0) {
                    System.out.printf("%d/%d", m - m / n * n, n);
                } else {
                    System.out.printf("(%d/%d)", m - m / n * n, n);
                }
            }
        }
    }

    private static void printSecondNumAndResult(int m, int n, int mtemp, int ntemp) {
        printSingleNum(m, n);
        System.out.print(" = ");
        int cTemp = Math.abs(gcd(mtemp, ntemp));
        printSingleNum(mtemp / cTemp, ntemp / cTemp);
    }

    private static int gcd(int m, int n) {
        return n == 0 ? m : gcd(n, m % n);
    }
}