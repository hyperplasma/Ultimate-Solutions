package PAT_A1020_Tree_Traversals;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static final int N = 40;
    static int n;
    static int[] postOrder = new int[N];
    static int[] inOrder = new int[N];
    static Map<Integer, Integer> l = new HashMap<>();
    static Map<Integer, Integer> r = new HashMap<>();
    static Map<Integer, Integer> inPos = new HashMap<>();

    public static int build(int postL, int postR, int inL, int inR) {
        int root = postOrder[postR];
        int k = inPos.get(root);
        if (k > inL) {
            l.put(root, build(postL, postL + (k - 1 - inL), inL, k - 1));
        }
        if (k < inR) {
            r.put(root, build(postL + k - inL, postR - 1, k + 1, inR));
        }
        return root;
    }

    public static void bfs(int root) {
        int[] Q = new int[N];
        int front = -1, rear = -1;
        Q[++rear] = root;

        while (front != rear) {
            int p = Q[++front];
            if (l.containsKey(p)) Q[++rear] = l.get(p);
            if (r.containsKey(p)) Q[++rear] = r.get(p);
        }

        for (int i = 0; i < n; ++i) {
            System.out.print(Q[i]);
            if (i != n - 1) {
                System.out.print(" ");
            } else {
                System.out.println();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; ++i) {
            inOrder[i] = Integer.parseInt(st.nextToken());
            inPos.put(inOrder[i], i);
        }

        int root = build(0, n - 1, 0, n - 1);
        bfs(root);
    }
}