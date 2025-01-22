package LC1561_Maximum_Number_of_Coins_You_Can_Get;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-coins-you-can-get/">Maximum Number of Coins You Can Get</a>
 * 贪心；数组；数学；博弈；排序
 */
public class MaximumNumberOfCoinsYouCanGet {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxCoins(new int[]{2, 4, 1, 2, 7, 8}));
    }
}

class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int sum = 0;
        for (int i = piles.length / 3; i < piles.length; i += 2) {
            sum += piles[i];
        }
        return sum;
    }
}