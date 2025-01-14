package MC0005;

import java.util.*;

public class Main {
    public static int[] solution(int n, int max, int[] array) {
        TreeMap<Integer, Integer> map = new TreeMap<>((a, b) -> b - a);
        for (int i = 0; i < n; i++) {
            if (array[i] == 1) {
                array[i] = 14;
            }
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }

        var entrySet = map.entrySet();
        for (var card1 : entrySet) {
            if (card1.getValue() >= 3) {
                for (var card2 : entrySet) {
                    if (!card1.getKey().equals(card2.getKey()) && card2.getValue() >= 2) {
                        int res1 = card1.getKey() == 14 ? 1 : card1.getKey();
                        int res2 = card2.getKey() == 14 ? 1 : card2.getKey();

                        if (3 * res1 + 2 * res2 <= max) {
                            return new int[]{res1, res2};
                        }
                    }
                }
            }
        }

        return new int[]{0, 0};
    }

    public static void main(String[] args) {
        // Add your test cases here
        System.out.println(java.util.Arrays.equals(solution(9, 34, new int[]{6, 6, 6, 8, 8, 8, 5, 5, 1}), new int[]{8, 5}));
        System.out.println(java.util.Arrays.equals(solution(9, 37, new int[]{9, 9, 9, 9, 6, 6, 6, 6, 13}), new int[]{6, 9}));
        System.out.println(java.util.Arrays.equals(solution(9, 40, new int[]{1, 11, 13, 12, 7, 8, 11, 5, 6}), new int[]{0, 0}));
        System.out.println(java.util.Arrays.equals(solution(6, 50, new int[]{13, 13, 13, 1, 1, 1}), new int[]{1, 13}));
        System.out.println(java.util.Arrays.equals(solution(31, 42, new int[]{3, 3, 11, 12, 12, 2, 13, 5, 13, 1, 13, 8, 8, 1, 8, 13, 12, 9, 2, 11, 3, 5, 8, 11, 1, 11, 1, 5, 4, 2, 5}), new int[]{1, 13}));
    }
}