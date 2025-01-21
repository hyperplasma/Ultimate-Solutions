package LC2239_FindClosestNumberToZero;

/**
 * <a href="https://leetcode.cn/problems/find-closest-number-to-zero/">Find Closest Number to Zero</a>
 * 数组
 */
public class FindClosestNumberToZero {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findClosestNumber(new int[]{-4, -2, 1, 4, 8}));
    }
}

class Solution {
    public int findClosestNumber(int[] nums) {
        int minAbs = Math.abs(nums[0]);
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int abs = Math.abs(nums[i]);
            if (abs < minAbs) {
                minAbs = abs;
                res = nums[i];
            } else if (abs == minAbs) {
                res = Math.max(res, nums[i]);
            }
        }
        return res;
    }
}