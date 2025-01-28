package LC0119_Pascals_Triangle_II;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/pascals-triangle-ii/">Pascal's Triangle II</a>
 * 数组；动态规划
 */
public class PascalsTriangleII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getRow(3));
    }
}

class Solution {
    /**
     * C(n, m) = C(n, m - 1) * (n - m + 1) / m
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }
}