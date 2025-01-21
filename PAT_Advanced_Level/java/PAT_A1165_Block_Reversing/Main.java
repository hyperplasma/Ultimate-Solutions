package PAT_A1165_Block_Reversing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 测试点5超时
 */
public class Main {
    static final int N = 100010;

    static int n, k;
    static int head;
    static int[] e = new int[N];
    static int[] ne = new int[N];
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        head = Integer.parseInt(firstLine[0]);
        n = Integer.parseInt(firstLine[1]);
        k = Integer.parseInt(firstLine[2]);

        for (int i = 0; i < n; ++i) {
            String[] inputs = br.readLine().split(" ");
            int addr = Integer.parseInt(inputs[0]);
            int data = Integer.parseInt(inputs[1]);
            int next = Integer.parseInt(inputs[2]);
            e[addr] = data;
            ne[addr] = next;
        }

        for (int p = head; p != -1; p = ne[p]) {
            list.add(p);
        }

        for (int i = 0; i < list.size(); i += k) {
            int end = Math.min(i + k, list.size());
            Collections.reverse(list.subList(i, end));
        }

        Collections.reverse(list);

        for (int i = 0; i < list.size() - 1; ++i) {
            System.out.printf("%05d %d %05d\n", list.get(i), e[list.get(i)], list.get(i + 1));
        }
        System.out.printf("%05d %d -1\n", list.get(list.size() - 1), e[list.get(list.size() - 1)]);
    }
}
