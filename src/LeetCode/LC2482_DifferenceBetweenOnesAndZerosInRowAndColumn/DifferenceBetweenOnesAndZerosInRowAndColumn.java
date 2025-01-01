package LeetCode.LC2482_DifferenceBetweenOnesAndZerosInRowAndColumn;

/**
 * <a href="https://leetcode.cn/problems/difference-between-ones-and-zeros-in-row-and-column/">Difference Between Ones and Zeros in Row and Column</a>
 */
public class DifferenceBetweenOnesAndZerosInRowAndColumn {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{0,1},{1,0}};
        int[][] result = solution.onesMinusZeros(grid);
        for (int[] ints : result) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
        }
    }
}

class Solution {
    /**
     * 预处理模拟
     */
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rows = new int[m]; // 记录每一行1和0数目的差值
        int[] cols = new int[n]; // 记录每一列1和0数目的差值

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    rows[i]++;
                    cols[j]++;
                } else {
                    rows[i]--;
                    cols[j]--;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = rows[i] + cols[j];
            }
        }

        return grid;
    }
}