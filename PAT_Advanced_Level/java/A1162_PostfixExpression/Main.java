package A1162_PostfixExpression;

import java.io.*;
import java.util.*;

public class Main {
    static final int N = 30;
    static int[] l = new int[N];
    static int[] r = new int[N];
    static String[] e = new String[N];
    static boolean[] hasParent = new boolean[N];
    static StringBuilder res = new StringBuilder();

    static void dfs(int node) {
        if (node != -1) {
            res.append("(");

            boolean isOperator = (l[node] == -1 && r[node] != -1);
            dfs(l[node]);
            if (isOperator) {
                res.append(e[node]);
            }
            dfs(r[node]);
            if (!isOperator) {
                res.append(e[node]);
            }

            res.append(")");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Arrays.fill(l, -1);
        Arrays.fill(r, -1);

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String value = st.nextToken();
            int lChild = Integer.parseInt(st.nextToken());
            int rChild = Integer.parseInt(st.nextToken());
            e[i] = value;

            if (lChild != -1) {
                l[i] = lChild;
                hasParent[lChild] = true;
            }
            if (rChild != -1) {
                r[i] = rChild;
                hasParent[rChild] = true;
            }
        }

        int root = 1;
        while (hasParent[root]) {
            root++;
        }

        dfs(root);

        System.out.println(res.toString());
    }
}