package A1101_QuickSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 测试点1、2、3、4、5超时
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine().trim());

        int[] arr = new int[n];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] leftMax = new int[n];
        int[] rightMin = new int[n];

        leftMax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        rightMin[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }

        List<Integer> pivots = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if ((i == 0 || arr[i] > leftMax[i - 1]) && (i == n - 1 || arr[i] < rightMin[i + 1])) {
                pivots.add(arr[i]);
            }
        }

        Collections.sort(pivots);

        System.out.println(pivots.size());
        for (int i = 0; i < pivots.size(); i++) {
            if (i > 0) System.out.print(" ");
            System.out.print(pivots.get(i));
        }
        System.out.println();
    }
}
