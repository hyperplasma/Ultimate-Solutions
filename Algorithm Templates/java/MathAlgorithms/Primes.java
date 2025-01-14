package MathAlgorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * 质数
 */
public class Primes {
    /**
     * 试除法判断质数 O(sqrt(n))
     */
    public static boolean isPrime(int x) {
        if (x < 2) {
            return false;
        }
        for (int i = 2; i <= x / i; i++) {
            if (x % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 试除法分解质因数 O(sqrt(n))
     *
     * @return pairs 存储分解所得的质因数及其个数
     */
    public static List<int[]> divide(int x) {
        List<int[]> pairs = new ArrayList<>();  // 存储质因数及其个数
        for (int i = 2; i <= x / i; i++) {
            while (x % i == 0) {
                int cnt = 0;
                while (x % i == 0) {
                    x /= i;
                    cnt++;
                }
                pairs.add(new int[]{i, cnt});
            }
        }
        if (x > 1) {
            pairs.add(new int[]{x, 1});    // x中只包含1个大于sqrt(x)的质因子
        }
        return pairs;
    }

    /**
     * 埃氏筛法求素数表 O(n log log n)
     *
     * @param n 范围[2, n]
     * @return primes 存储所有素数
     */
    public static List<Integer> sieveOfEratosthenes(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] st = new boolean[n + 1];  // 标记数i是否被筛掉（非素数）
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes.add(i);
                for (int j = i + i; j <= n; j += i) { // 筛去i的倍数，朴素法遍历全部倍数
                    st[j] = true;
                }
            }
        }
        return primes;
    }

    /**
     * 线性筛法求素数表 O(n)
     * <p>
     * 核心思想：每个合数只会被其最小质因子筛掉
     *
     * @param n 范围[2, n]
     * @return primes 存储所有素数
     */
    public static List<Integer> getPrimes(int n) {
        List<Integer> primes = new ArrayList<>();
        boolean[] st = new boolean[n + 1];  // 标记数i是否被筛掉（非素数）
        for (int i = 2; i <= n; i++) {
            if (!st[i]) {
                primes.add(i);
            }
            for (int j = 0; primes.get(j) <= n / i; j++) {
                st[i * primes.get(j)] = true;
                if (i % primes.get(j) == 0) {
                    break;  // i的最小质因子是primes.get(j)，故i * primes.get(j)的最小质因子必为primes.get(j)
                }
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        System.out.println(isPrime(100));

        List<int[]> pairs = divide(100);
        for (int[] pair : pairs) {
            System.out.println(pair[0] + " " + pair[1]);
        }

        List<Integer> primes = getPrimes(100);
        for (int prime : primes) {
            System.out.println(prime);
        }
    }
}
