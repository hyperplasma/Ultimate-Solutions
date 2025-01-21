package PAT_A1042_Shuffling_Machine;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static final int N = 60;  // 常量N，数组长度

    // 打印洗牌后的牌
    private static void print(int x) {
        if (x <= 13) System.out.print("S" + x);
        else if (x <= 26) System.out.print("H" + (x - 13));
        else if (x <= 39) System.out.print("C" + (x - 26));
        else if (x <= 52) System.out.print("D" + (x - 39));
        else System.out.print("J" + (x - 52));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(reader.readLine().trim());  // 读取洗牌次数

        int[] q = new int[N];
        int[] p = new int[N];
        int[] w = new int[N];

        // 读取洗牌位置
        String[] positions = reader.readLine().trim().split("\\s+");
        for (int i = 1; i <= 54; i++) {
            q[i] = Integer.parseInt(positions[i - 1]);
        }

        // 初始化牌的位置
        for (int i = 1; i <= 54; i++) {
            p[i] = i;
        }

        // 进行洗牌
        while (k-- > 0) {
            System.arraycopy(p, 0, w, 0, N);
            for (int i = 1; i <= 54; i++) {
                p[q[i]] = w[i];
            }
        }

        // 输出洗牌后的结果
        for (int i = 1; i <= 54; i++) {
            print(p[i]);
            if (i != 54) System.out.print(" ");
        }
    }
}
