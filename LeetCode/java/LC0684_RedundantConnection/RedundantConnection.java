package LC0684_RedundantConnection;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/redundant-connection/">Redundant Connection</a>
 * 深度优先搜索；广度优先搜索；并查集；图
 */
public class RedundantConnection {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] edges = new int[][]{{1, 2}, {1, 3}, {2, 3}};
        System.out.println(Arrays.toString(solution.findRedundantConnection(edges)));
    }
}

class Solution {

    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];

        for (int i = 1; i <= edges.length; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if (find(parent, a) == find(parent, b)) {
                return edge;
            } else {
                union(parent, a, b);
            }
        }

        return null;
    }

    public int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    public void union(int[] parent, int x, int y) {
        parent[find(parent, x)] = find(parent, y);
    }
}