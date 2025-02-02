package LC0598_Range_Addition_II;

/**
 * <a href="https://leetcode.cn/problems/range-addition-ii/">Range Addition II</a>
 * 数组；数学
 */
public class RangeAdditionII {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxCount(3, 3, new int[][]{{2, 2}, {3, 3}}));
    }
}

class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        int mina = m, minb = n;
        for (int[] op : ops) {
            mina = Math.min(mina, op[0]);
            minb = Math.min(minb, op[1]);
        }
        return mina * minb;
    }
}