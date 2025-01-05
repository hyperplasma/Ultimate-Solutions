package A1130_InfixExpression;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int n = Integer.parseInt(inputs[0]);

        int[] l = new int[30];
        int[] r = new int[30];
        String[] w = new String[30];
        boolean[] hasFather = new boolean[30];
        Arrays.fill(l, -1);
        Arrays.fill(r, -1);
        Arrays.fill(hasFather, false);

        for (int i = 1; i <= n; i++) {
            String[] data = br.readLine().split(" ");
            w[i] = data[0];
            int lChild = Integer.parseInt(data[1]);
            int rChild = Integer.parseInt(data[2]);

            if (lChild != -1) {
                l[i] = lChild;
                hasFather[lChild] = true;
            }
            if (rChild != -1) {
                r[i] = rChild;
                hasFather[rChild] = true;
            }
        }

        int root = 1;
        while (hasFather[root]) {
            root++;
        }

        StringBuilder res = new StringBuilder();
        dfs(root, l, r, w, res);

        if (res.length() > 0 && res.charAt(0) == '(') {
            res.deleteCharAt(0);
        }
        if (res.length() > 0 && res.charAt(res.length() - 1) == ')') {
            res.deleteCharAt(res.length() - 1);
        }

        System.out.println(res);
    }

    private static void dfs(int u, int[] l, int[] r, String[] w, StringBuilder res) {
        if (u != -1) {
            int cnt = 0;
            if (l[u] != -1) {
                cnt++;
            }
            if (r[u] != -1) {
                cnt++;
            }

            if (cnt > 0) {
                res.append("(");
            }
            dfs(l[u], l, r, w, res);

            res.append(w[u]);

            dfs(r[u], l, r, w, res);
            if (cnt > 0) {
                res.append(")");
            }
        }
    }
}