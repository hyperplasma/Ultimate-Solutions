package PAT_A1114_Family_Property;

import java.io.*;
import java.util.*;

/**
 * 测试点3、4超时
 */
public class Main {
    static final int N = 10010;
    static int[] p = new int[N];
    static Node[] nodes = new Node[N];
    static boolean[] flag = new boolean[N];

    static class Node {
        int id, dad, mom;
        int num, cnt, area;
        List<Integer> childs = new ArrayList<>();

        Node() {
            num = 1;
        }
    }

    static int find(int x) {
        if (p[x] != x) p[x] = find(p[x]);
        return p[x];
    }

    static void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa != pb) {
            if (pa > pb) {
                int temp = pa;
                pa = pb;
                pb = temp;
            }
            p[pb] = pa;
            nodes[pa].num += nodes[pb].num;
            nodes[pa].cnt += nodes[pb].cnt;
            nodes[pa].area += nodes[pb].area;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        for (int i = 0; i < N; i++) {
            p[i] = i;
            nodes[i] = new Node();
            nodes[i].id = i;
        }

        int n = Integer.parseInt(reader.readLine());
        List<Integer> ppl = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = reader.readLine().split(" ");
            int id = Integer.parseInt(parts[0]);
            nodes[id].id = id;
            ppl.add(id);

            int dad = Integer.parseInt(parts[1]);
            int mom = Integer.parseInt(parts[2]);
            int cNum = Integer.parseInt(parts[3]);
            nodes[id].dad = dad;
            nodes[id].mom = mom;
            for (int j = 0; j < cNum; j++) {
                int child = Integer.parseInt(parts[4 + j]);
                nodes[id].childs.add(child);
            }
            nodes[id].cnt = Integer.parseInt(parts[4 + cNum]);
            nodes[id].area = Integer.parseInt(parts[5 + cNum]);
        }

        for (int id : ppl) {
            flag[id] = true;

            if (nodes[id].dad != -1) {
                flag[nodes[id].dad] = true;
                union(id, nodes[id].dad);
            }
            if (nodes[id].mom != -1) {
                flag[nodes[id].mom] = true;
                union(id, nodes[id].mom);
            }

            for (int child : nodes[id].childs) {
                flag[child] = true;
                union(id, child);
            }
        }

        List<Node> res = new ArrayList<>();
        for (int a = 0; a < N; a++) {
            int pa = find(a);
            if (pa == a && flag[pa]) res.add(nodes[pa]);
        }

        res.sort((node1, node2) -> {
            if (node1.area * node2.num != node2.area * node1.num) {
                return node1.area * node2.num < node2.area * node1.num ? 1 : -1;
            } else {
                return Integer.compare(node1.id, node2.id);
            }
        });

        writer.println(res.size());
        for (Node i : res) {
            writer.printf("%04d %d %.3f %.3f\n", i.id, i.num, (double) i.cnt / i.num, (double) i.area / i.num);
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}