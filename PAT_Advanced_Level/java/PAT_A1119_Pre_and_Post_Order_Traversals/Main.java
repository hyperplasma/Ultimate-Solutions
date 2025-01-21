package PAT_A1119_Pre_and_Post_Order_Traversals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static final int N = 40;
    static int n;
    static int[] pre = new int[N], post = new int[N];
    static ArrayList<Integer> in = new ArrayList<>();
    static boolean isUnique = true;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine().trim());

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < n; ++i) {
            pre[i] = Integer.parseInt(tokenizer.nextToken());
        }

        tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < n; ++i) {
            post[i] = Integer.parseInt(tokenizer.nextToken());
        }

        dfs(0, n - 1, 0, n - 1);

        if (isUnique) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

        for (int i = 0; i < in.size(); ++i) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(in.get(i));
        }
        System.out.println();
    }

    static void dfs(int preL, int preR, int postL, int postR) {
        if (preL == preR) {
            in.add(pre[preL]);
            return;
        }

        if (pre[preL] == post[postR]) {
            int k;
            for (k = preL + 1; k <= preR; ++k) {
                if (pre[k] == post[postR - 1]) {
                    break;
                }
            }

            if (k > preL + 1) { // k号未紧挨着根(preL)，则k号必为右子树根，此时必存在左子树
                dfs(preL + 1, k - 1, postL, postL + (k - 1 - preL - 1)); // 区间长度一致
            } else {
                isUnique = false;
            }

            in.add(pre[preL]); // 中序：“左根右”
            dfs(k, preR, postL + (k - 1 - preL - 1) + 1, postR - 1); // 无论是否唯一，默认k号为右子树根
        }
    }
}