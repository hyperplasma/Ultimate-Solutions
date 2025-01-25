package LC2412_Minimum_Money_Required_before_Transactions;

/**
 * <a href="https://leetcode.cn/problems/minimum-money-required-before-transactions/">Minimum Money Required before Transactions</a>
 * 贪心；数组；排序
 */
public class MinimumMoneyRequiredBeforeTransactions {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumMoney(new int[][]{{2, 1}, {3, 2}, {10, 3}}));
    }
}

class Solution {
    public long minimumMoney(int[][] transactions) {
        long totalLose = 0;
        int res = 0;
        for (int[] t : transactions) {
            int cost = t[0];
            int cashback = t[1];
            totalLose += Math.max(cost - cashback, 0);
            res = Math.max(res, Math.min(cost, cashback));
        }
        return totalLose + res;
    }
}