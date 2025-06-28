package PAT_A1133_Splitting_a_Linked_List;

import java.io.*;
import java.util.*;

/**
 * 测试点5超时
 */
public class Main {
    static final int N = 100010;
    static Node[] nodes = new Node[N];
    static List<Node> L = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int head = Integer.parseInt(firstLine[0]);
        int n = Integer.parseInt(firstLine[1]);
        int k = Integer.parseInt(firstLine[2]);

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            int ad = Integer.parseInt(inputs[0]);
            int data = Integer.parseInt(inputs[1]);
            int next = Integer.parseInt(inputs[2]);
            int flag;

            if (data < 0) flag = 2;
            else if (data <= k) flag = 1;
            else flag = 0;

            nodes[ad] = new Node(ad, data, next, flag, 0);
        }

        int cnt = 1;
        for (int p = head; p != -1; p = nodes[p].next) {
            nodes[p].num = cnt++;
            L.add(nodes[p]);
        }
        Collections.sort(L);

        for (int i = 0; i < L.size() - 1; i++) {
            System.out.printf("%05d %d %05d\n", L.get(i).ad, L.get(i).data, L.get(i + 1).ad);
        }
        System.out.printf("%05d %d -1\n", L.get(L.size() - 1).ad, L.get(L.size() - 1).data);

        br.close();
    }
}

class Node implements Comparable<Node> {
    int ad, data, next;
    int flag;  // <0: 2，[0, k]: 1，>k: 0
    int num;

    Node(int ad, int data, int next, int flag, int num) {
        this.ad = ad;
        this.data = data;
        this.next = next;
        this.flag = flag;
        this.num = num;
    }

    @Override
    public int compareTo(Node t) {
        if (this.flag != t.flag) return t.flag - this.flag;
        else return this.num - t.num;
    }
}