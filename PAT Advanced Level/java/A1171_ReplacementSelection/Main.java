package A1171_ReplacementSelection;

import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * 测试点3、4、5超时
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] firstLine = line.split(" ");
            int n = Integer.parseInt(firstLine[0]);
            int m = Integer.parseInt(firstLine[1]);

            PriorityQueue<Integer> mem = new PriorityQueue<>();
            PriorityQueue<Integer> tmp = new PriorityQueue<>();

            String[] nums = reader.readLine().split(" ");
            int last = 0;

            for (int i = 1; i <= n; ++i) {
                int x = Integer.parseInt(nums[i - 1]);

                if (i <= m) {
                    mem.add(x);
                    if (i == m) {
                        last = mem.poll();
                        System.out.print(last);
                    }
                } else {
                    if (x < last) {
                        tmp.add(x);
                    } else {
                        mem.add(x);
                    }

                    if (!mem.isEmpty()) {
                        last = mem.poll();
                        System.out.print(" " + last);
                    } else {
                        PriorityQueue<Integer> swap = mem;
                        mem = tmp;
                        tmp = swap;
                        System.out.println();

                        last = mem.poll();
                        System.out.print(last);
                    }
                }
            }

            while (!mem.isEmpty()) {
                System.out.print(" " + mem.poll());
            }

            if (!tmp.isEmpty()) {
                mem = tmp;
                System.out.println();

                boolean isFirst = true;
                while (!mem.isEmpty()) {
                    if (isFirst) {
                        isFirst = false;
                    } else {
                        System.out.print(" ");
                    }
                    System.out.print(mem.poll());
                }
                System.out.println();
            } else {
                System.out.println();
            }
        }
    }
}
