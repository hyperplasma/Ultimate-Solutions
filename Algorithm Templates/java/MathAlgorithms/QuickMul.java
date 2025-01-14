package MathAlgorithms;

/**
 * 快速幂 O(log n)
 */
public class QuickMul {
    /**
     * x^n
     */
    public static double quickMul(double x, long n) {
        double res = 1.0;
        while (n > 0) {
            if (n % 2 == 1) {
                res *= x;
            }
            x *= x;
            n /= 2;
        }
        return res;
    }

    /**
     * 取余 x^n % mod
     */
    public static double quickMulMod(double x, long n, long mod) {
        double res = 1.0;
        while (n > 0) {
            if (n % 2 == 1) {
                res = res * x % mod;
            }
            x = x * x % mod;
            n /= 2;
        }
        return res;
    }

    /**
     * 递归表示
     */
    public static double quickMulRecursion(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMulRecursion(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;
    }

    public static void main(String[] args) {
        System.out.println(quickMul(2, 10));
        System.out.println(quickMulMod(2, 10, 1000000007));
        System.out.println(quickMulRecursion(2, 10));
    }
}
