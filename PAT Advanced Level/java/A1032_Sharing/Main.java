package A1032_Sharing;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试点5超时
 */
public class Main {
    private static final int N = 100010;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] input = reader.readLine().split(" ");
        int h1 = Integer.parseInt(input[0]);
        int h2 = Integer.parseInt(input[1]);
        int n = Integer.parseInt(input[2]);

        Map<Integer, Node> nodes = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            input = reader.readLine().split(" ");
            int addr = Integer.parseInt(input[0]);
            char data = input[1].charAt(0);
            int next = Integer.parseInt(input[2]);
            nodes.put(addr, new Node(addr, data, next));
        }

        boolean[] hash = new boolean[N];

        for (int p = h1; p != -1; p = nodes.get(p).next) {
            hash[p] = true;
        }

        int p;
        for (p = h2; p != -1; p = nodes.get(p).next) {
            if (hash[p]) {
                System.out.printf("%05d\n", p);
                break;
            }
        }

        if (p == -1) {
            System.out.println("-1");
        }
    }

    static class Node {
        int addr;
        char data;
        int next;

        Node(int addr, char data, int next) {
            this.addr = addr;
            this.data = data;
            this.next = next;
        }

        
    }
}