package LC3065_Minimum_Operations_to_Exceed_Threshold_Value_I;

/**
 * <a href="https://leetcode.cn/problems/minimum-operations-to-exceed-target-with-integer-ops/">Minimum Operations to Exceed Target with Integer Ops</a>
 * 数组
 */
public class MinimumOperationsToExceedThresholdValueI {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[]{1, 2, 3, 4, 5}, 10));
    }
}

class Solution {
    public int minOperations(int[] nums, int k) {
        int cnt = 0;
        for (int num : nums) {
            if (num < k) {
                cnt++;
            }
        }
        return cnt;
    }
}