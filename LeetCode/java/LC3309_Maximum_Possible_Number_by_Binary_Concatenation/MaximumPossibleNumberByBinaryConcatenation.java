package LC3309_Maximum_Possible_Number_by_Binary_Concatenation;

import java.util.Arrays;

/**
 * <a href="https://leetcode.com/problems/maximum-possible-number-by-binary-concatenation/">Maximum Possible Number By Binary Concatenation</a>
 * 位运算；数组；枚举
 */
public class MaximumPossibleNumberByBinaryConcatenation {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxGoodNumber(new int[]{1, 2, 3, 4, 5, 6}));
    }
}

class Solution {
    /**
     * 非最优
     */
    public int maxGoodNumber(int[] nums) {
        String[] binary = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            binary[i] = Integer.toBinaryString(nums[i]);
        }

        Arrays.sort(binary, (a, b) -> (b + a).compareTo(a + b));    // 按字典序降序排序

        StringBuilder sb = new StringBuilder();
        for (String s : binary) {
            sb.append(s);
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}