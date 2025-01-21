package PAT_A1067_Sort_with_Swap;

import java.util.Scanner;

public class Main {
    static final int N = 100010;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] pos = new int[N];

        for (int i = 0; i < n; ++i) {
            int x = scanner.nextInt();
            pos[x] = i;
        }

        int cnt = 0;
        for (int i = 1; i < n; ) {
            while (pos[0] != 0) {
                swap(pos, 0, pos[0]);
                cnt++;
            }

            while (i < n && pos[i] == i) i++;
            if (i < n) {
                swap(pos, 0, i);
                cnt++;
            }
        }
        System.out.println(cnt);

        scanner.close();
    }

    private static void swap(int[] pos, int a, int b) {
        int temp = pos[a];
        pos[a] = pos[b];
        pos[b] = temp;
    }
}