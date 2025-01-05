package A1128_NQueensPuzzle;

import java.io.*;

/**
 * 测试点3超时
 */
public class Main {
    static final int N = 1010;

    static boolean checkConflict(int[] queens, int col) {
        for (int i = 1; i < col; i++) {
            if (queens[i] == queens[col] || Math.abs(queens[i] - queens[col]) == col - i)
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());

        while (K-- > 0) {
            String[] inputs = br.readLine().split(" ");
            int N = Integer.parseInt(inputs[0]);

            int[] queens = new int[N + 1];
            boolean valid = true;
            for (int i = 1; i <= N; i++) {
                queens[i] = Integer.parseInt(inputs[i]);
                if (checkConflict(queens, i)) {
                    valid = false;
                    break;
                }
            }
            System.out.println(valid ? "YES" : "NO");
        }

        br.close();
    }
}