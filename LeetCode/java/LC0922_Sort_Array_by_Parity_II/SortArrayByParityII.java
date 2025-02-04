package LC0922_Sort_Array_by_Parity_II;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/sort-array-by-parity-ii/">Sort Array By Parity II</a>
 * 数组；双指针；排序
 */
public class SortArrayByParityII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.sortArrayByParityII(new int[]{4, 2, 5, 7})));
    }
}

class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        for (int i = 0, j = 1; i < nums.length; i += 2) {
            if (nums[i] % 2 != 0) { // 奇数
                while (nums[j] % 2 != 0) {  // 找到下一个偶数
                    j += 2;
                }
                swap(nums, i, j);
            }
        }
        return nums;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}