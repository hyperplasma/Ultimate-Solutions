package MC0049;

import java.util.*;

public class Main {

    public static List<String> solution(int n, List<String> s, List<Integer> x) {
        Map<String, Integer> merged = new HashMap<>();
        LinkedHashMap<String, Integer> orderMap = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String name = s.get(i);
            int amount = x.get(i);

            merged.put(name, merged.getOrDefault(name, 0) + amount);

            if (!orderMap.containsKey(name)) {
                orderMap.put(name, i);
            }
        }

        List<Map.Entry<String, Integer>> entries = new ArrayList<>(merged.entrySet());

        entries.sort((a, b) -> {
            int amountA = a.getValue();
            int amountB = b.getValue();

            if (amountA != amountB) {
                return Integer.compare(amountB, amountA);
            }

            return Integer.compare(orderMap.get(a.getKey()), orderMap.get(b.getKey()));
        });

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : entries) {
            result.add(entry.getKey());
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(4, Arrays.asList("a", "b", "c", "d"), Arrays.asList(1, 2, 2, 1)).equals(Arrays.asList("b", "c", "a", "d")));
        System.out.println(solution(3, Arrays.asList("x", "y", "z"), Arrays.asList(100, 200, 200)).equals(Arrays.asList("y", "z", "x")));
        System.out.println(solution(5, Arrays.asList("m", "n", "o", "p", "q"), Arrays.asList(50, 50, 30, 30, 20)).equals(Arrays.asList("m", "n", "o", "p", "q")));
    }
}