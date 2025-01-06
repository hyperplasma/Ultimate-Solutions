package A1159_StructureOfABinaryTree;

import java.util.Scanner;

public class Main {
    static final int N = 1010;

    static int n, m;
    static int[] l = new int[N], r = new int[N], w = new int[N];
    static int[] p = new int[N], depth = new int[N];
    static int[] post = new int[N], in = new int[N], inPos = new int[N];
    static boolean isFull = true;

    static int build(int inL, int inR, int postL, int postR, int d) {
        int root = post[postR];
        depth[root] = d;

        int k = inPos[root];
        int childCnt = 0;
        if (inL < k) {
            l[root] = build(inL, k - 1, postL, postL + (k - 1 - inL), d + 1);
            p[l[root]] = root;
            childCnt++;
        }
        if (k < inR) {
            r[root] = build(k + 1, inR, postL + (k - 1 - inL) + 1, postR - 1, d + 1);
            p[r[root]] = root;
            childCnt++;
        }
        if (childCnt == 1) {
            isFull = false;
        }

        return root;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            post[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            in[i] = scanner.nextInt();
            inPos[in[i]] = i;
        }

        int root = build(0, n - 1, 0, n - 1, 0);
        p[root] = -1;

        m = scanner.nextInt();
        scanner.nextLine();
        String s;
        StringBuilder sb;
        while (m-- > 0) {
            s = scanner.nextLine();
            sb = new StringBuilder();

            boolean flag;
            if (s.charAt(s.length() - 1) == 't') {
                for (int i = 0; i < s.length() && Character.isDigit(s.charAt(i)); i++) {
                    sb.append(s.charAt(i));
                }
                int a = Integer.parseInt(sb.toString());
                flag = (a == root);
            } else if (s.charAt(0) == 'I') {
                flag = isFull;
            } else {
                int a, b, i = 0;
                for (; i < s.length() && Character.isDigit(s.charAt(i)); i++) {
                    sb.append(s.charAt(i));
                }
                a = Integer.parseInt(sb.toString());
                sb = new StringBuilder();
                while (i < s.length() && !Character.isDigit(s.charAt(i))) {
                    i++;
                }
                for (; i < s.length() && Character.isDigit(s.charAt(i)); i++) {
                    sb.append(s.charAt(i));
                }
                b = Integer.parseInt(sb.toString());

                if (s.charAt(s.length() - 1) == 's') {
                    flag = (p[a] == p[b]);
                } else if (s.charAt(s.length() - 1) == 'l') {
                    flag = (depth[a] == depth[b]);
                } else if (s.contains("parent")) {
                    flag = (p[b] == a);
                } else if (s.contains("right")) {
                    flag = (r[b] == a);
                } else {
                    flag = (l[b] == a);
                }
            }

            if (flag) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

        scanner.close();
    }
}