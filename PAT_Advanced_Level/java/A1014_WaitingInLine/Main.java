package A1014_WaitingInLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.LinkedList;
import java.util.Queue;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer in = new StreamTokenizer(bf);
        in.nextToken();
        int n = (int) in.nval;
        in.nextToken();
        int m = (int) in.nval;
        in.nextToken();
        int k = (int) in.nval;
        in.nextToken();
        int q = (int) in.nval;
        customer[] c = new customer[k];

        int cursor = 0;
        for (int i = 0; i < k; i++) {
            in.nextToken();
            c[i] = new customer((int) in.nval);
        }

        Queue<Integer>[] queue = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            queue[i] = new LinkedList<>();
        }

        for (int time = 480; time < 1020; time++) {
            //送客
            for (int i = 0; i < n; i++) {
                if (!queue[i].isEmpty()) {
                    int j = queue[i].peek();
                    if (c[j].leave_time == time) {
                        queue[i].poll();
                    }
                }
            }
            //入队
            for (int j = 1; j <= m; j++) {
                for (int i = 0; i < n; i++) {
                    if (queue[i].size() < j) {
                        if (cursor < k) {
                            queue[i].offer(cursor);
                            cursor++;
                        }
                    }
                }
            }
            //迎客
            for (int i = 0; i < n; i++) {
                if (!queue[i].isEmpty()) {
                    int j = queue[i].peek();
                    if (c[j].leave_time == 0) {
                        c[j].leave_time = time + c[j].process_time;
                    }
                }
            }
        }

        while (q-- > 0) {
            in.nextToken();
            int i = (int) in.nval - 1;
            if (c[i].leave_time == 0) {
                System.out.println("Sorry");
            } else {
                System.out.printf("%02d:%02d\n", c[i].leave_time / 60, c[i].leave_time % 60);
            }
        }
    }
}

class customer {
    int process_time, leave_time = 0;

    public customer(int process_time) {
        this.process_time = process_time;
    }
}
