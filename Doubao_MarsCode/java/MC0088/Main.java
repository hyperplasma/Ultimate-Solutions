package MC0088;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 88. 连续子串和的整除问题
 */
public class Main {
    public static int solution(int n, int b, List<Integer> sequence) {
        int res = 0;
        int prefixSum = 0;
        Map<Integer, Integer> count = new HashMap<>();  // 前缀和对b求余所得mod及其频次

        for (int num : sequence) {
            prefixSum += num;
            int mod = prefixSum % b;

            if (mod == 0) {
                res++;  // 若为0则该前缀和对应的连续子序列本身即符合条件
            }

            if (count.containsKey(mod)) {
                res += count.get(mod);
            }

            count.put(mod, count.getOrDefault(mod, 0) + 1);
        }

        return res;
    }

    public static void main(String[] args) {
        // You can add more test cases here
        System.out.println(solution(3, 3, List.of(1, 2, 3)) == 3);
        System.out.println(solution(5, 2, List.of(1, 2, 3, 4, 5)) == 6);
    }
}