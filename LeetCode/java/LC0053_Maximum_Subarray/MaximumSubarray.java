package LC0053_Maximum_Subarray;

/**
 * <a href="https://leetcode-cn.com/problems/maximum-subarray/">Maximum Subarray</a>
 * 数组；分治；动态规划
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int thisSum = 0, maxSum = Integer.MIN_VALUE;
        for (int num : nums) {
            thisSum += num;
            maxSum = Math.max(maxSum, thisSum);
            if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }
}
