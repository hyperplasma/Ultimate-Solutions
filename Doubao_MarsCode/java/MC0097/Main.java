package MC0097;

import java.util.Arrays;

/**
 * 97. 最大乘积区间问题
 */
public class Main {
    public static int[] solution(int n, int[] arr) {
        double maxProd = 0;
        int start = -1, end = -1;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                continue;
            }

            double prod = 1.0;
            for (int j = i; j < n; j++) {
                if (arr[j] == 0) {
                    break;
                }

                prod *= arr[j];
                if (prod > maxProd) {
                    maxProd = prod;
                    start = i;
                    end = j;
                } else if (prod == maxProd) {
                    if (i < start || (i == start && j < end)) {
                        start = i;
                        end = j;
                    }
                }
            }
        }

        if (start == -1 || end == -1) {
            return new int[]{-1, -1};
        }
        return new int[]{start + 1, end + 1};
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(Arrays.equals(solution(5, new int[]{1, 2, 4, 0, 8}), new int[]{1, 3}));
        System.out.println(Arrays.equals(solution(7, new int[]{1, 2, 4, 8, 0, 256, 0}), new int[]{6, 6}));
    }
}
