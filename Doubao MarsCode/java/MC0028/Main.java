package MC0028;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 28. 我好想逃却逃不掉
 */
public class Main {
    static int[] dx = {-1, 1, 0, 0}; // 上下左右移动的行偏移
    static int[] dy = {0, 0, -1, 1}; // 上下左右移动的列偏移

    public static int solution(int N, int M, char[][] data) {
        // 创建visited数组来标记已访问的位置
        boolean[][] canReachExit = new boolean[N][M];

        // 首先找到出口位置
        int exitX = -1, exitY = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (data[i][j] == 'O') {
                    exitX = i;
                    exitY = j;
                    break;
                }
            }
        }

        // 从出口开始进行BFS
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{exitX, exitY});
        canReachExit[exitX][exitY] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0], y = curr[1];

            // 检查所有可能到达当前位置的点
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (canReachExit[i][j]) continue;

                    // 检查从位置(i,j)是否可以到达当前位置
                    if (canMove(i, j, x, y, data, N, M)) {
                        canReachExit[i][j] = true;
                        queue.offer(new int[]{i, j});
                    }
                }
            }
        }

        // 统计所有无法到达出口的位置数量
        int dangerousCount = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!canReachExit[i][j]) {
                    dangerousCount++;
                }
            }
        }

        return dangerousCount;
    }

    // 检查从(fromX, fromY)是否可以移动到(toX, toY)
    private static boolean canMove(int fromX, int fromY, int toX, int toY, char[][] data, int N, int M) {
        char cell = data[fromX][fromY];

        // 如果是传送器，检查是否传送到目标位置
        if (cell == 'U' && fromX > 0 && fromX - 1 == toX && fromY == toY) return true;
        if (cell == 'D' && fromX < N - 1 && fromX + 1 == toX && fromY == toY) return true;
        if (cell == 'L' && fromY > 0 && fromX == toX && fromY - 1 == toY) return true;
        if (cell == 'R' && fromY < M - 1 && fromX == toX && fromY + 1 == toY) return true;

        // 如果是普通地板，检查是否可以走到相邻位置
        if (cell == '.') {
            for (int i = 0; i < 4; i++) {
                int nextX = fromX + dx[i];
                int nextY = fromY + dy[i];
                if (nextX == toX && nextY == toY &&
                        nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        // 测试用例1
        char[][] pattern1 = {
                {'.', '.', '.', '.', '.'},
                {'.', 'R', 'R', 'D', '.'},
                {'.', 'U', '.', 'D', 'R'},
                {'.', 'U', 'L', 'L', '.'},
                {'.', '.', '.', '.', 'O'}
        };
        System.out.println("Test case 1: " + (solution(5, 5, pattern1) == 10));

        // 测试用例2
        char[][] pattern2 = {
                {'.', 'R', '.', 'O'},
                {'U', '.', 'L', '.'},
                {'.', 'D', '.', '.'},
                {'.', '.', 'R', 'D'}
        };
        System.out.println("Test case 2: " + (solution(4, 4, pattern2) == 2));

        // 测试用例3
        char[][] pattern3 = {
                {'.', 'U', 'O'},
                {'L', '.', 'R'},
                {'D', '.', '.'}
        };
        System.out.println("Test case 3: " + (solution(3, 3, pattern3) == 8));

        // 测试用例4
        char[][] pattern4 = {
                {'.', 'R', '.', 'O'},
                {'U', '.', 'L', '.'},
                {'.', 'D', '.', '.'},
                {'.', '.', 'R', 'D'}
        };
        System.out.println("Test case 4: " + (solution(4, 4, pattern4) == 2));
    }
}