package LeetCode.LC1128_NumberOfEquivalentDominoPairs;

/**
 * <a href="https://leetcode.cn/problems/number-of-equivalent-domino-pairs/">Number of Equivalent Domino Pairs</a>
 */
public class NumberOfEquivalentDominoPairs {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] dominoes = {{1, 2}, {2, 1}, {3, 4}, {5, 6}};
        System.out.println(solution.numEquivDominoPairs(dominoes));
    }
}

class Solution {
    /**
     * 二元组表示（使用1个两位的正整数）
     */
    public int numEquivDominoPairs(int[][] dominoes) {
        int[] count = new int[100];
        int res = 0;
        for (int[] domino : dominoes) {
            int val = domino[0] < domino[1] ? domino[1] * 10 + domino[0] : domino[0] * 10 + domino[1];
            res += count[val];
            count[val]++;
        }
        return res;
    }
}