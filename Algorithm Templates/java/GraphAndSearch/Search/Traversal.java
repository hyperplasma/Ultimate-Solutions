package GraphAndSearch.Search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 遍历
 */
public class Traversal {
    public static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * BFS遍历迷宫
     */
    public static void bfsMaze(int[][] maze, int[] u) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(u);
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            System.out.println(cur[0] + " " + cur[1]);
            if (cur[0] == maze.length - 1 && cur[1] == maze[0].length - 1) {
                return;
            }
            for (int[] dir : dirs) {
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == 0) {
                    maze[x][y] = 1;
                    q.offer(new int[]{x, y});
                }
            }
        }
    }
}

