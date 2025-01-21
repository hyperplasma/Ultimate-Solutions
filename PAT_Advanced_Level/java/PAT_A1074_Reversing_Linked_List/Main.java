package PAT_A1074_Reversing_Linked_List;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 测试点5超时
 */
public class Main {
    static final int N = 100010;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split(" ");
        int h = Integer.parseInt(firstLine[0]);
        int n = Integer.parseInt(firstLine[1]);
        int m = Integer.parseInt(firstLine[2]);

        int[] e = new int[N];
        int[] ne = new int[N];

        for (int i = 0; i < n; i++) {
            String[] nodeInfo = reader.readLine().split(" ");
            int address = Integer.parseInt(nodeInfo[0]);
            int data = Integer.parseInt(nodeInfo[1]);
            int next = Integer.parseInt(nodeInfo[2]);
            e[address] = data;
            ne[address] = next;
        }

        List<Integer> q = new ArrayList<>();
        for (int i = h; i != -1; i = ne[i]) {
            q.add(i);
        }

        for (int i = 0; i + m - 1 < q.size(); i += m) {
            Collections.reverse(q.subList(i, i + m));
        }

        for (int i = 0; i < q.size(); i++) {
            System.out.printf("%05d %d ", q.get(i), e[q.get(i)]);
            if (i + 1 == q.size()) {
                System.out.println("-1");
            } else {
                System.out.printf("%05d\n", q.get(i + 1));
            }
        }

        reader.close();
    }
}
