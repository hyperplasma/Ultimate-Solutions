package A1091_AcuteStroke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 测试点0、1、4、5内存超限
 */
public class Main {
    static final int M = 1286, N = 128, L = 60;
    static int m, n, l, T;
    static int[][][] g = new int[L][M][N]; // [l] [m] [n]
    static int[][] d = {
        {1, 0, 0}, {-1, 0, 0},
        {0, 1, 0}, {0, -1, 0},
        {0, 0, 1}, {0, 0, -1}
    };

    static class Node {
        int x, y, z;

        Node(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int BFS(Node u) {
        Queue<Node> q = new LinkedList<>();
        q.offer(u);
        g[u.x][u.y][u.z] = 0;

        int cnt = 1;
        while (!q.isEmpty()) {
            Node p = q.poll();

            for (int i = 0; i < 6; ++i) {
                Node v = new Node(p.x + d[i][0], p.y + d[i][1], p.z + d[i][2]);
                if (v.x >= 0 && v.x < l && v.y >= 0 && v.y < m && v.z >= 0 && v.z < n && g[v.x][v.y][v.z] != 0) {
                    cnt++;
                    g[v.x][v.y][v.z] = 0;
                    q.offer(v);
                }
            }
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        l = Integer.parseInt(input[2]);
        T = Integer.parseInt(input[3]);

        for (int i = 0; i < l; ++i) {
            for (int j = 0; j < m; ++j) {
                String[] line = br.readLine().split(" ");
                for (int k = 0; k < n; ++k) {
                    g[i][j][k] = Integer.parseInt(line[k]);
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < l; ++i) {
            for (int j = 0; j < m; ++j) {
                for (int k = 0; k < n; ++k) {
                    if (g[i][j][k] != 0) {
                        int cnt = BFS(new Node(i, j, k));
                        if (cnt >= T) sum += cnt;
                    }
                }
            }
        }

        System.out.println(sum);
    }
}