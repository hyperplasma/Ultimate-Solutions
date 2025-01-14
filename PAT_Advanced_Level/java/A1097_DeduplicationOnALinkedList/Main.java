package A1097_DeduplicationOnALinkedList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 测试点3、4超时
 */
public class Main {
    static final int N = 100010;
    static int h, n;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static boolean[] st = new boolean[N];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        h = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");
            int addr = Integer.parseInt(line[0]);
            int key = Integer.parseInt(line[1]);
            int next = Integer.parseInt(line[2]);
            e[addr] = key;
            ne[addr] = next;
        }

        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();

        for (int i = h; i != -1; i = ne[i]) {
            int v = Math.abs(e[i]);
            if (st[v]) {
                b.add(i);
            } else {
                st[v] = true;
                a.add(i);
            }
        }

        for (int i = 0; i < a.size(); i++) {
            System.out.printf("%05d %d ", a.get(i), e[a.get(i)]);
            if (i + 1 == a.size()) {
                System.out.println("-1");
            } else {
                System.out.printf("%05d\n", a.get(i + 1));
            }
        }
        for (int i = 0; i < b.size(); i++) {
            System.out.printf("%05d %d ", b.get(i), e[b.get(i)]);
            if (i + 1 == b.size()) {
                System.out.println("-1");
            } else {
                System.out.printf("%05d\n", b.get(i + 1));
            }
        }
    }
}