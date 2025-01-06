package A1161_MergingLinkedLists;

import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int address;
        int data;
        int next;

        Node(int address, int data, int next) {
            this.address = address;
            this.data = data;
            this.next = next;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int head1 = Integer.parseInt(st.nextToken());
        int head2 = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        Map<Integer, Node> nodes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int addr = Integer.parseInt(st.nextToken());
            int data = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());
            nodes.put(addr, new Node(addr, data, next));
        }

        List<Integer> list1 = buildList(head1, nodes);
        List<Integer> list2 = buildList(head2, nodes);
        if (list2.size() > list1.size()) {
            List<Integer> temp = list1;
            list1 = list2;
            list2 = temp;
        }

        Collections.reverse(list2);

        List<Integer> res = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < list1.size(); i++) {
            res.add(list1.get(i));
            if ((i + 1) % 2 == 0 && j < list2.size()) {
                res.add(list2.get(j++));
            }
        }

        for (int i = 0; i < res.size(); i++) {
            Node cur = nodes.get(res.get(i));
            if (i < res.size() - 1) {
                System.out.printf("%05d %d %05d\n",
                        cur.address, cur.data, res.get(i + 1));
            } else {
                System.out.printf("%05d %d -1\n",
                        cur.address, cur.data);
            }
        }
    }

    static List<Integer> buildList(int head, Map<Integer, Node> nodes) {
        List<Integer> list = new ArrayList<>();
        int current = head;
        while (current != -1) {
            list.add(current);
            Node node = nodes.get(current);
            current = node.next;
        }
        return list;
    }
}