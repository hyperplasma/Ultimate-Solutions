package A1057_Stack;

import java.io.*;
import java.util.*;

/**
 * 测试点1、2、3超时
 */
public class Main {
    static int n;
    static Stack<Integer> s = new Stack<>();
    static TreeMap<Integer, Integer> sortedMap = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i < n; i++) {
            String command = reader.readLine().trim();
            if (command.startsWith("Push")) {
                int x = Integer.parseInt(command.split(" ")[1]);
                s.push(x);
                sortedMap.put(x, sortedMap.getOrDefault(x, 0) + 1);
            } else if (command.equals("Pop")) {
                if (s.isEmpty()) {
                    System.out.println("Invalid");
                } else {
                    int x = s.pop();
                    System.out.println(x);
                    if (sortedMap.get(x) == 1) {
                        sortedMap.remove(x);
                    } else {
                        sortedMap.put(x, sortedMap.get(x) - 1);
                    }
                }
            } else if (command.equals("PeekMedian")) {
                if (s.isEmpty()) {
                    System.out.println("Invalid");
                } else {
                    int medianIndex = (s.size() + 1) / 2;
                    int cnt = 0;
                    for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
                        cnt += entry.getValue();
                        if (cnt >= medianIndex) {
                            System.out.println(entry.getKey());
                            break;
                        }
                    }
                }
            }
        }
        reader.close();
    }
}
