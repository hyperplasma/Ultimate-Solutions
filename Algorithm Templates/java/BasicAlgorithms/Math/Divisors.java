package BasicAlgorithms.Math;

import java.util.ArrayList;
import java.util.List;

/**
 * 约数
 */
public class Divisors {
    private static final int MOD = 1000000007;  // 防止结果过大而溢出

    /**
     * 试除法求所有约数
     * <p>
     * 时间复杂度：取决于排序函数，试除的消耗为 O(sqrt(n))
     */
    public static List<Integer> getDivisors(int x) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i <= x / i; i++) {  // 枚举到sqrt(x)
            if (x % i == 0) {   // 若i为x的约数，则x/i也是x的约数
                divisors.add(i);
                if (i != x / i) {    // 不重复存储约数sqrt(x)
                    divisors.add(x / i);
                }
            }
        }
        divisors.sort(null);    // 对约数进行排序
        return divisors;
    }

    /**
     * 求约数个数
     */
    public static long getDivisorsCount(int x) {
        List<int[]> pairs = Primes.divide(x);   // 存储分解所得的质因数及其个数
        long cnt = 1;
        for (int[] pair : pairs) {
            cnt = cnt * (pair[1] + 1) % MOD;
        }
        return cnt;
    }

    /**
     * 求约数之和
     */
    public static long getDivisorsSum(int x) {
        List<int[]> pairs = Primes.divide(x);   // 存储分解所得的质因数及其个数
        long sum = 1;
        for (int[] pair : pairs) {
            int p = pair[0], a = pair[1];   // 约数p与指数a
            long tmp = 1;
            while (a-- > 0) {
                tmp = (tmp * p + 1) % MOD;  // 秦九韶算法
            }
            sum = sum * tmp % MOD;
        }
        return sum;
    }

    /**
     * 欧几里得算法 O(log n)
     */
    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    /**
     * 求最小公倍数
     */
    public static int lcm(int a, int b) {
        return a / gcd(a, b) * b;
    }

    public static void main(String[] args) {
        System.out.println(getDivisors(12));
        System.out.println(getDivisorsCount(12));
        System.out.println(getDivisorsSum(12));
        System.out.println(gcd(12, 18));
        System.out.println(lcm(12, 18));
    }
}
