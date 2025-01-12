package MC0013;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 13. 构造特定数组的逆序拼接
 */
public class Main {
    public static int[] solution(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = n; j >= i; j--) {
                list.add(j);
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.equals(solution(3), new int[]{3, 2, 1, 3, 2, 3}));
        System.out.println(Arrays.equals(solution(4), new int[]{4, 3, 2, 1, 4, 3, 2, 4, 3, 4}));
        System.out.println(Arrays.equals(solution(5), new int[]{5, 4, 3, 2, 1, 5, 4, 3, 2, 5, 4, 3, 5, 4, 5}));
    }
}