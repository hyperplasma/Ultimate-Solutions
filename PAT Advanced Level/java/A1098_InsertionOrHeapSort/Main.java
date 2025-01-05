package A1098_InsertionOrHeapSort;

import java.util.Scanner;

public class Main {
    static final int N = 110;
    static int n;
    static int[] a = new int[N];
    static int[] b = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            b[i] = sc.nextInt();
        }

        int p = 2;
        while (p <= n && b[p] >= b[p - 1]) {
            p++;
        }
        int k = p;
        while (p <= n && a[p] == b[p]) {
            p++;
        }
        if (p == n + 1) {
            System.out.println("Insertion Sort");
            while (k > 1 && b[k] < b[k - 1]) {
                swap(b, k, k - 1);
                k--;
            }
        } else {
            System.out.println("Heap Sort");
            p = n;
            while (b[1] <= b[p]) {
                p--;
            }
            swap(b, 1, p);
            down(1, p - 1);
        }

        System.out.print(b[1]);
        for (int i = 2; i <= n; i++) {
            System.out.print(" " + b[i]);
        }
        System.out.println();
        sc.close();
    }

    private static void down(int u, int size) {
        int t = u;
        if (u * 2 <= size && b[t] < b[u * 2]) {
            t = u * 2;
        }
        if (u * 2 + 1 <= size && b[t] < b[u * 2 + 1]) {
            t = u * 2 + 1;
        }
        if (t != u) {
            swap(b, t, u);
            down(t, size);
        }
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
