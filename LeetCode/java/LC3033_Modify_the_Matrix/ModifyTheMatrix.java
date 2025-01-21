package LC3033_Modify_the_Matrix;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/modify-the-matrix/">Modify The Matrix</a>
 * 数组；矩阵
 */
public class ModifyTheMatrix {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{-1, -1, -1}, {-1, -1, -1}};
        int[][] answer = solution.modifiedMatrix(matrix);
        System.out.println(Arrays.deepToString(answer));
    }
}

class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1) {
                    int max = -1;
                    for (int k = 0; k < m; k++) {
                        if (matrix[k][j] > max) {
                            max = matrix[k][j];
                        }
                    }
                    matrix[i][j] = max;
                }
            }
        }

        return matrix;
    }
}