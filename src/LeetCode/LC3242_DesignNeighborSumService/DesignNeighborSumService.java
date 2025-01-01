package LeetCode.LC3242_DesignNeighborSumService;

import java.util.Map;
import java.util.HashMap;

/**
 * <a href="https://leetcode-cn.com/problems/design-neighbor-sum-service/">Design Neighbor Sum Service</a>
 */
public class DesignNeighborSumService {
    public static void main(String[] args) {
        int[][] grid = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        NeighborSum obj = new NeighborSum(grid);
        int value = 5;
        int param_1 = obj.adjacentSum(value);
        int param_2 = obj.diagonalSum(value);
        System.out.println(param_1);
        System.out.println(param_2);
    }
}

class NeighborSum {
    private int[][] grid;
    private Map<Integer, int[]> map;    // <num, pos[]{r, c}>
    private final int[][][] dirs = {
            {{0, 1}, {0, -1}, {1, 0}, {-1, 0}},  // adjacent
            {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}}  // diagonal
    };

    public NeighborSum(int[][] grid) {
        this.grid = grid;
        this.map = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                map.put(grid[i][j], new int[]{i, j});
            }
        }
    }

    public int adjacentSum(int value) {
        return getSum(value, 0);
    }

    public int diagonalSum(int value) {
        return getSum(value, 1);
    }

    private int getSum(int value, int type) {
        int[] pos = map.get(value);
        int x = pos[0], y = pos[1];
        int sum = 0;

        for (int[] dir : dirs[type]) {
            int nx = x + dir[0], ny = y + dir[1];
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                sum += grid[nx][ny];
            }
        }

        return sum;
    }
}