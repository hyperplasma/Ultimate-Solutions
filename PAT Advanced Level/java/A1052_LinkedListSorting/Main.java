package A1052_LinkedListSorting;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] split = br.readLine().split(" ");
        int n = Integer.parseInt(split[0]);
        int headAddress = Integer.parseInt(split[1]);

        Node[] nodes = new Node[100005];
        for (int i = 0; i < n; i++) {
            split = br.readLine().split(" ");
            int address = Integer.parseInt(split[0]);
            int data = Integer.parseInt(split[1]);
            int next = Integer.parseInt(split[2]);
            nodes[address] = new Node(address, data, next);
        }

        int p = headAddress;
        List<Node> list = new ArrayList<Node>();
        while (p != -1) {
            list.add(nodes[p]);
            p = nodes[p].next;
        }

        Collections.sort(list);
        for (int i = list.size() - 1; i >= 0; i--) {
            list.get(i).next = p;
            p = list.get(i).address;
        }
        if (list.isEmpty()) {
            System.out.println("0" + " " + "-1");
        } else {
            System.out.println(list.size() + " " + String.format("%05d", list.get(0).address));
            for (Node data : list) {
                System.out.println(data);
            }
        }
    }
}

class Node implements Comparable<Node> {
    int address;
    int data;
    int next;

    public Node(int address, int data, int next) {
        this.address = address;
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        if (this.next != -1) {
            return String.format("%05d", address) + " " + data + " " + String.format("%05d", next);
        } else {
            return String.format("%05d", address) + " " + data + " " + String.format("%2d", next);
        }
    }

    @Override
    public int compareTo(Node o) {
        return this.data - o.data;
    }
}
