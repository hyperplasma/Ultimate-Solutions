package PAT_A1034_Head_of_a_Gang;

import java.util.*;

public class Main {
    static int n, K;
    static Map<String, List<Pair>> g = new HashMap<>();
    static Map<String, Integer> total = new HashMap<>();
    static Map<String, Boolean> st = new HashMap<>();

    static class Pair {
        String node;
        int weight;

        Pair(String node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static int dfs(String node, List<String> gang) {
        st.put(node, true);
        gang.add(node);

        int sum = 0;
        for (Pair p : g.get(node)) {
            String curNode = p.node;
            sum += p.weight;

            if (!st.getOrDefault(curNode, false)) sum += dfs(curNode, gang);
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        K = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String a = sc.next();
            String b = sc.next();
            int t = sc.nextInt();

            g.putIfAbsent(a, new ArrayList<>());
            g.putIfAbsent(b, new ArrayList<>());

            g.get(a).add(new Pair(b, t));
            g.get(b).add(new Pair(a, t));

            total.put(a, total.getOrDefault(a, 0) + t);
            total.put(b, total.getOrDefault(b, 0) + t);
        }

        List<Map.Entry<String, Integer>> res = new ArrayList<>();
        for (String node : g.keySet()) {
            if (!st.getOrDefault(node, false)) {
                List<String> gang = new ArrayList<>();
                int sum = dfs(node, gang) / 2;

                if (gang.size() > 2 && sum > K) {
                    String boss = gang.get(0);
                    for (String member : gang) {
                        if (total.get(member) > total.get(boss)) {
                            boss = member;
                        }
                    }
                    res.add(new AbstractMap.SimpleEntry<>(boss, gang.size()));
                }
            }
        }

        res.sort(Map.Entry.comparingByKey());
        System.out.println(res.size());
        for (Map.Entry<String, Integer> entry : res) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        sc.close();
    }
}