package PAT_A1048_Find_Coins;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 测试点3、4超时
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] first = bufferedReader.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int m = Integer.parseInt(first[1]);
        int[] val = new int[n];
        String[] sec = bufferedReader.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            val[i] = Integer.parseInt(sec[i]);
        }

        Arrays.sort(val);
        int low = 0, high = n - 1;
        while (low < high) {
            if (val[low] + val[high] > m) {
                high--;
            } else if (val[low] + val[high] < m) {
                low++;
            } else if (val[low] + val[high] == m) {
                System.out.println(val[low] + " " + val[high]);
                return;
            }
        }
        System.out.println("No Solution");
    }
}

