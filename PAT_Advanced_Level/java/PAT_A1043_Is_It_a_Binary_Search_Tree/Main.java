package PAT_A1043_Is_It_a_Binary_Search_Tree;

import java.util.*;

public class Main {
    static final int N = 1010;
    static int n;
    static int[] pre = new int[N];
    static int[] in = new int[N];
    static List<Integer> post = new ArrayList<>();

    public static boolean build(int inL, int inR, int preL, int preR, int flag) {
        if (inL > inR) return true;

        int k;
        if (flag == 0) {
            for (k = inL; k <= inR; ++k)
                if (in[k] == pre[preL]) break;

            if (k > inR) return false;
        } else {
            for (k = inR; k >= inL; --k)
                if (in[k] == pre[preL]) break;

            if (k < inL) return false;
        }

        boolean res = true;
        if (!build(inL, k - 1, preL + 1, preL + 1 + (k - 1 - inL), flag))
            res = false;
        if (!build(k + 1, inR, preL + 1 + (k - 1 - inL) + 1, preR, flag))
            res = false;

        post.add(pre[preL]);
        return res;
    }

    public static void print() {
        for (int i = 0; i < post.size(); ++i) {
            if (i > 0) System.out.print(" ");
            System.out.print(post.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; ++i) {
            pre[i] = sc.nextInt();
            in[i] = pre[i];
        }
        Arrays.sort(in, 0, n);

        // Try to build the BST with ascending in-order
        if (build(0, n - 1, 0, n - 1, 0)) {
            System.out.println("YES");
            print();
        } else {
            // Try to build the BST with descending in-order
            for (int i = 0; i < n / 2; i++) {
                int temp = in[i];
                in[i] = in[n - 1 - i];
                in[n - 1 - i] = temp;
            }
            post.clear();
            if (build(0, n - 1, 0, n - 1, 1)) {
                System.out.println("YES");
                print();
            } else {
                System.out.println("NO");
            }
        }
    }
}
