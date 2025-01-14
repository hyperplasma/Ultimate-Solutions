package A1086_TreeTraversalsAgain;

import java.util.Scanner;
import java.util.Stack;
import java.util.Vector;

public class Main {
    static final int N = 40;
    static int n;
    static int root;
    static int[] l = new int[N];
    static int[] r = new int[N];
    static Vector<Integer> postorder = new Vector<>();

    static void dfs(int u) {
        if (u == 0) return;

        dfs(l[u]);
        dfs(r[u]);
        postorder.add(u);
    }

    static void print() {
        for (int i = 0; i < postorder.size(); ++i) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(postorder.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();

        Stack<Integer> stk = new Stack<>();
        int lastNode = 0;
        String lastOp = "";
        for (int i = 0; i < 2 * n; ++i) {
            String op = scanner.next();
            if ("Push".equals(op)) {
                int node = scanner.nextInt();
                if (lastNode == 0) {
                    root = node;
                } else {
                    if ("Push".equals(lastOp)) {
                        l[lastNode] = node;
                    } else {
                        r[lastNode] = node;
                    }
                }
                lastNode = node;
                stk.push(node);
            } else {
                int node = stk.peek();
                stk.pop();
                lastNode = node;
            }
            lastOp = op;
        }

        dfs(root);
        print();
    }
}