package LC2944_Minimum_Number_of_Coins_for_Fruits;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-coins-for-fruits/">Minimum Number of Coins for Fruits</a>
 * 队列；数组；动态规划；单调队列；堆（优先队列）
 */
public class MinimumNumberOfCoinsForFruits {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumCoins(new int[]{26, 18, 6, 12, 49, 7, 45, 45}));
    }
}

class Solution {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offerFirst(new int[]{n, 0});
        for (int i = n - 1; i >= 0; i--) {
            while (queue.peekLast()[0] >= 2 * i + 3) {
                queue.pollLast();
            }
            int cur = queue.peekLast()[1] + prices[i];
            while (queue.peekFirst()[1] >= cur) {
                queue.pollFirst();
            }
            queue.offerFirst(new int[]{i, cur});
        }
        return queue.peekFirst()[1];
    }
}