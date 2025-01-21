package LC3192_Minimum_Operations_to_Make_Binary_Array_Elements_Equal_to_One_II;

/**
 * <a href="https://leetcode.com/problems/minimum-operations-to-make-binary-array-elements-equal-ii/">Minimum Operations To Make Binary Array Elements Equal II</a>
 * 贪心；数组；动态规划
 */
public class MinimumOperationsToMakeBinaryArrayElementsEqualToOneII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minOperations(new int[]{1, 1, 0, 1}));
    }
}

class Solution {
    /**
     * 仅受自身及左侧数翻转影响；翻转偶数次数字不变
     */
    public int minOperations(int[] nums) {
        int counter = 0;
        for (int num : nums) {
            if ((num == 0 && counter % 2 == 0) || (num == 1 && counter % 2 != 0)) {
                counter++;
            }
        }
        return counter;
    }
}