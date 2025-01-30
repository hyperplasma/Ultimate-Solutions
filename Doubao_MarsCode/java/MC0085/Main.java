package MC0085;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 85. 数列差异的最小化
 * <p>
 * 运行超时
 */
public class Main {
    public static int solution(int n, int m, int k, List<Integer> a, List<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);

        int minDiff = Integer.MAX_VALUE;
        int i = 0, j = 0;
        while (i < n && j < m) {
            int diff = Math.abs((a.get(i) - b.get(j)) * (a.get(i) - b.get(j)) - k * k);
            minDiff = Math.min(minDiff, diff);
            if (a.get(i) < b.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        // You can add more test cases here
        // case 1
        List<Integer> a1 = Arrays.asList(5, 3, 4, 1, 2);
        List<Integer> b1 = Arrays.asList(0, 6, 7, 9, 8);
        System.out.println(solution(5, 5, 1, a1, b1) == 0);

        // case 2
        List<Integer> a2 = Arrays.asList(5, 3, 4, 1, 2);
        List<Integer> b2 = Arrays.asList(0, 6, 7, 9, 8);
        System.out.println(solution(5, 5, 0, a2, b2) == 1);

        // case 3
        List<Integer> a3 = Arrays.asList(5, 3, 4, 1, 2);
        List<Integer> b3 = Arrays.asList(0, 6, 7, 9, 8, 11);
        System.out.println(solution(5, 6, 3, a3, b3) == 0);
    }
}