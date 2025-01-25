package MC0070;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static int solution(int[][] inputArray) {
        Arrays.sort(inputArray, Comparator.comparingInt(a -> a[0]));

        int start = 0, end = 0, cnt = 0;
        for (int[] seg : inputArray) {
            if (seg[0] > end) {
                cnt += end - start + 1;
                start = seg[0];
                end = seg[1];
            } else if (seg[1] > end) {
                end = seg[1];
            }
        }
        cnt += end - start;
        // System.out.println(cnt);
        return cnt;
    }

    public static void main(String[] args) {
        //  You can add more test cases here
        int[][] testArray1 = {{1, 4}, {7, 10}, {3, 5}};
        int[][] testArray2 = {{1, 2}, {6, 10}, {11, 15}};

        System.out.println(solution(testArray1) == 9);
        System.out.println(solution(testArray2) == 12);
    }
}