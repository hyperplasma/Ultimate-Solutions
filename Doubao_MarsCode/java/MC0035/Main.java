package MC0035;

import java.util.*;

/**
 * 35. 小S的倒排索引
 */
public class Main {
    public static List<Integer> solution(List<Integer> a, List<Integer> b) {
        if (a.isEmpty() || b.isEmpty()) {
            return Collections.emptyList();
        }

        Set<Integer> set = new HashSet<>(a);
        List<Integer> res = new ArrayList<>();
        for (int i = b.size() - 1; i >= 0; i--) {
            if (set.contains(b.get(i))) {
                res.add(b.get(i));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(solution(Arrays.asList(1, 2, 3, 7), Arrays.asList(2, 5, 7)).equals(Arrays.asList(7, 2)));
        System.out.println(solution(Arrays.asList(1, 4, 8, 10), Arrays.asList(2, 4, 8, 10)).equals(Arrays.asList(10, 8, 4)));
        System.out.println(solution(Arrays.asList(3, 5, 9), Arrays.asList(1, 4, 6)).equals(Collections.emptyList()));
        System.out.println(solution(Arrays.asList(1, 2, 3), Arrays.asList(1, 2, 3)).equals(Arrays.asList(3, 2, 1)));
    }
}