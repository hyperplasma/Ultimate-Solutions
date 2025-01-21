package LC3402_Minimum_Operations_to_Make_Columns_Strictly_Increasing;

/**
 * <a href="https://leetcode.cn/problems/minimum-operations-to-make-columns-strictly-increasing/">Minimum Operations to Make Columns Strictly Increasing</a>
 */
public class MinimumOperationsToMakeColumnsStrictlyIncreasing {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumOperations(new int[][]{{1, 2}, {3, 4}}));
    }
}

class Solution {
    public int minimumOperations(int[][] grid) {
        int counter = 0;
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 1; j < grid.length; j++) {
                int delta = grid[j][i] - grid[j - 1][i];
                if (delta <= 0) {
                    grid[j][i] += -delta + 1;
                    counter += -delta + 1;
                }
            }
        }
        return counter;
    }
}