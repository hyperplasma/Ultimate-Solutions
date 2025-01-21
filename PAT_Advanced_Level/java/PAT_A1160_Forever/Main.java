package PAT_A1160_Forever;

import java.io.*;
import java.util.*;

public class Main {
    static class Solution implements Comparable<Solution> {
        int n, A;

        Solution(int n, int A) {
            this.n = n;
            this.A = A;
        }

        @Override
        public int compareTo(Solution other) {
            if (this.n != other.n) {
                return Integer.compare(this.n, other.n);
            }
            return Integer.compare(this.A, other.A);
        }
    }

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int Q = Integer.parseInt(br.readLine());

        for (int caseNum = 1; caseNum <= Q; caseNum++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            List<Solution> results = new ArrayList<>();
            System.out.println("Case " + caseNum);

            int start = (int) Math.pow(10, k - 1);
            boolean found = false;

            for (int A = start + 9; A < start * 10; A += 10) {
                int sumA = digitSum(A);
                if (sumA != m) continue;

                int n = digitSum(A + 1);

                int d = gcd(m, n);
                if (isPrime(d) && d > 2) {
                    results.add(new Solution(n, A));
                    found = true;
                }
            }

            if (!found) {
                System.out.println("No Solution");
            } else {
                Collections.sort(results);
                for (Solution sol : results) {
                    System.out.println(sol.n + " " + sol.A);
                }
            }
        }
    }
}