package PAT_A1129_Recommendation_System;

import java.io.*;
import java.util.*;

public class Main {
    static final int N = 50010;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);

        int[] itemFrequency = new int[N];
        List<Integer> recommendations = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        String[] items = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int currentItem = Integer.parseInt(items[i]);

            if (i > 0) {
                sb.append(currentItem).append(":");
                for (Integer recommendation : recommendations) {
                    sb.append(" ").append(recommendation);
                }
                sb.append("\n");
            }

            itemFrequency[currentItem]++;

            if (!recommendations.contains(currentItem)) {
                recommendations.add(currentItem);
            }

            recommendations.sort((a, b) -> {
                if (itemFrequency[a] != itemFrequency[b]) {
                    return Integer.compare(itemFrequency[b], itemFrequency[a]);
                } else {
                    return Integer.compare(a, b);
                }
            });

            if (recommendations.size() > k) {
                recommendations.remove(recommendations.size() - 1);
            }
        }

        System.out.print(sb);
        br.close();
    }
}