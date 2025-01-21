package LC2270_NumberOfWaysToSplitArray;

/**
 * <a href="https://leetcode.cn/problems/number-of-ways-to-split-array/">Number of Ways to Split Array</a>
 * 数组；前缀和
 */
public class NumberOfWaysToSplitArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.waysToSplitArray(new int[]{10, 4, -8, 7}));
        System.out.println(solution.waysToSplitArray(new int[]{2, 3, 1, 0}));
    }
}

class Solution {
    public int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long leftSum = 0, rightSum = 0;
        for (int num : nums) {
            rightSum += num;
        }

        int res = 0;
        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            if (leftSum >= rightSum) {
                res++;
            }
        }
        return res;
    }
}