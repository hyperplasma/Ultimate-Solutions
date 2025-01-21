package LC2218_Maximum_Value_of_K_Coins_from_Piles;

import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximum-value-of-k-coins-from-piles/">Maximum Value of K Coins From Piles</a>
 * 数组；动态规划；前缀和
 */
public class MaximumValueOfKCoinsFromPiles {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxValueOfCoins(Arrays.asList(Arrays.asList(1, 100, 3), Arrays.asList(7, 8, 9)), 2));
    }
}

class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[] f = new int[k + 1];
        Arrays.fill(f, -1);
        f[0] = 0;
        for (List<Integer> pile : piles) {
            for (int i = k; i > 0; --i) {
                int value = 0;
                for (int t = 1; t <= pile.size(); ++t) {
                    value += pile.get(t - 1);
                    if (i >= t && f[i - t] != -1) {
                        f[i] = Math.max(f[i], f[i - t] + value);
                    }
                }
            }
        }
        return f[k];
    }
}