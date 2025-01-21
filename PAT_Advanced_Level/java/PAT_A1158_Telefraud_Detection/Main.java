package PAT_A1158_Telefraud_Detection;

import java.io.*;
import java.util.*;

public class Main {
    static final int N = 1010;
    static int k, n, m;
    static int[][] calls = new int[N][N];
    static List<Integer> suspects = new ArrayList<>();
    static int[] gang = new int[N];
    static int gangCount = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int caller = Integer.parseInt(st.nextToken());
            int receiver = Integer.parseInt(st.nextToken());
            int duration = Integer.parseInt(st.nextToken());
            calls[caller][receiver] += duration;
        }

        for (int i = 1; i <= n; i++) {
            int totalShortCalls = 0;
            int callbackCount = 0;

            for (int j = 1; j <= n; j++) {
                if (calls[i][j] > 0 && calls[i][j] <= 5) {
                    totalShortCalls++;
                    if (calls[j][i] > 0) {
                        callbackCount++;
                    }
                }
            }

            if (totalShortCalls > k && callbackCount <= totalShortCalls * 0.2) {
                suspects.add(i);
            }
        }

        if (suspects.isEmpty()) {
            System.out.println("None");
            return;
        }

        for (int suspect : suspects) {
            if (gang[suspect] == 0) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(suspect);

                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    if (gang[current] == 0) {
                        gang[current] = gangCount;
                        for (int otherSuspect : suspects) {
                            if (gang[otherSuspect] == 0 &&
                                    calls[current][otherSuspect] > 0 &&
                                    calls[otherSuspect][current] > 0) {
                                queue.offer(otherSuspect);
                            }
                        }
                    }
                }
                gangCount++;
            }
        }

        for (int i = 1; i < gangCount; i++) {
            List<Integer> gangMembers = new ArrayList<>();
            for (int suspect : suspects) {
                if (gang[suspect] == i) {
                    gangMembers.add(suspect);
                }
            }

            Collections.sort(gangMembers);
            if (!gangMembers.isEmpty()) {
                for (int j = 0; j < gangMembers.size(); j++) {
                    if (j > 0) {
                        System.out.print(" ");
                    }
                    System.out.print(gangMembers.get(j));
                }
                System.out.println();
            }
        }
    }
}