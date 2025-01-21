package PAT_A1105_Spiral_Matrix;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 测试点6超时
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());
        int[] a = new int[n];

        String[] input = reader.readLine().trim().split(" ");
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(a);
        for (int i = 0; i < n / 2; i++) {
            int temp = a[i];
            a[i] = a[n - i - 1];
            a[n - i - 1] = temp;
        }

        int row = 0, col = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                row = n / i;
                col = i;
            }
        }

        int[][] g = new int[row][col];
        boolean[][] visited = new boolean[row][col];
        int[][] d = {
            {0, 1, 0, -1},
            {1, 0, -1, 0}
        };

        int cnt = 0, k = 0;
        int x = 0, y = 0;
        while (cnt < n) {
            g[x][y] = a[cnt++];
            visited[x][y] = true;

            int nx = x + d[0][k], ny = y + d[1][k];
            if (nx < 0 || nx >= row || ny < 0 || ny >= col || visited[nx][ny]) {
                k = (k + 1) % 4;
                nx = x + d[0][k];
                ny = y + d[1][k];
            }
            x = nx;
            y = ny;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (j > 0) System.out.print(" ");
                System.out.print(g[i][j]);
            }
            System.out.println();
        }
    }
}
