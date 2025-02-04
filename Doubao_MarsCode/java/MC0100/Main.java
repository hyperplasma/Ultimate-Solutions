package MC0100;

import java.util.*;

/**
 * 100. 统计班级中的说谎者
 */
public class Main {
    public static int solution(int[] A) {
        int n = A.length;
        int[] sorted = Arrays.copyOf(A, n);
        Arrays.sort(sorted);

        int cnt = 0;
        for (int score : A) {
            int numLessOrEqual = countLessOrEqual(sorted, score);
            int numGreater = n - numLessOrEqual;
            if (numLessOrEqual > numGreater) {
                cnt++;
            }
        }
        return cnt;
    }

    private static int countLessOrEqual(int[] sorted, int target) {
        int low = 0, high = sorted.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (sorted[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low; // low指向第一个大于target的位置，因此小于等于target的数量是low
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(solution(new int[]{100, 100, 100}) == 3);
        System.out.println(solution(new int[]{2, 1, 3}) == 2);
        System.out.println(solution(new int[]{30, 1, 30, 30}) == 3);
        System.out.println(solution(new int[]{19, 27, 73, 55, 88}) == 3);
        System.out.println(solution(new int[]{19, 27, 73, 55, 88, 88, 2, 17, 22}) == 5);
    }
}
