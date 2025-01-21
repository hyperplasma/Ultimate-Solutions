package PAT_A1173_How_Many_Ways_to_Buy_a_Piece_of_Land;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 测试点2、6、7超时
 */
public class Main {
    static final int N = 10010;
    static int n, m, res = 0;
    static int[] w = new int[N];

    static int dfs(int k, int m) {
        int res = 0;

        if (k <= n && m - w[k] >= 0) {
            res += 1 + dfs(k + 1, m - w[k]);
        }

        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; ++i) {
            w[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; ++i) {
            res += dfs(i, m);
        }

        System.out.println(res);
    }
}