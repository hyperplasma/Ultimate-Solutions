package LC2920_Maximum_Points_after_Collecting_Coins_from_All_Nodes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/maximum-points-after-collecting-coins-from-all-nodes/">Maximum Points after Collecting Coins from All Nodes</a>
 * 位运算；树；深度优先搜索；数组；动态规划
 */
public class MaximumPointsAfterCollectingCoinsFromAllNodes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumPoints(new int[][]{{0, 1}, {1, 2}, {2, 3}}, new int[]{10, 10, 3, 3}, 5));
    }
}

class Solution {
    public int maximumPoints(int[][] edges, int[] coins, int k) {
        int n = coins.length;
        List<List<Integer>> children = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            children.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            children.get(edge[0]).add(edge[1]);
            children.get(edge[1]).add(edge[0]);
        }
        int[][] memo = new int[n][14];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, -1, 0, coins, k, children, memo);
    }

    private int dfs(int node, int parent, int f, int[] coins, int k, List<List<Integer>> children, int[][] memo) {
        if (memo[node][f] != -1) {
            return memo[node][f];
        }
        int res0 = (coins[node] >> f) - k;
        int res1 = coins[node] >> (f + 1);
        for (int child : children.get(node)) {
            if (child == parent) {
                continue;
            }
            res0 += dfs(child, node, f, coins, k, children, memo);
            if (f + 1 < 14) {
                res1 += dfs(child, node, f + 1, coins, k, children, memo);
            }
        }
        memo[node][f] = Math.max(res0, res1);
        return memo[node][f];
    }
}