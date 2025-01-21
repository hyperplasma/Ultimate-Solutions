package LC3066_Minimum_Operations_to_Exceed_Threshold_Value_II;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/minimum-operations-to-exceed-threshold-ii/">Minimum Operations To Exceed Threshold II</a>
 * 数组；模拟；堆（优先队列）
 */
public class MinimumOperationsToExceedThresholdValueII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[]{2, 11, 10, 1, 3}, 10));
        System.out.println(solution.minOperations(new int[]{1, 1, 2, 4, 9}, 20));
    }
}

class Solution {
    public int minOperations(int[] nums, int k) {
        Queue<Long> queue = new PriorityQueue<>();
        for (long num : nums) {
            queue.add(num);
        }

        int cnt = 0;
        while (queue.size() > 1 && queue.peek() < k) {
            long min1 = queue.remove();
            long min2 = queue.remove();
            queue.add(min1 * 2 + min2);
            cnt++;
        }
        return cnt;
    }
}