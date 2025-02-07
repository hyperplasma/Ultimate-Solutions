package LC0059_Spiral_Matrix_II;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/spiral-matrix-ii/">Spiral Matrix II</a>
 * 数组；矩阵；模拟
 */
public class SpiralMatrixII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.generateMatrix(3)));
        System.out.println(Arrays.deepToString(solution.generateMatrix(1)));
    }
}

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int cur = 1;

        int i = 0, j = 0;
        while (cur <= n * n) {
            while (j < n && res[i][j] == 0) {
                res[i][j++] = cur++;
            }
            j--;
            i++;
            while (i < n && res[i][j] == 0) {
                res[i++][j] = cur++;
            }
            i--;
            j--;
            while (j >= 0 && res[i][j] == 0) {
                res[i][j--] = cur++;
            }
            j++;
            i--;
            while (i >= 0 && res[i][j] == 0) {
                res[i--][j] = cur++;
            }
            i++;
            j++;
        }
        return res;
    }
}