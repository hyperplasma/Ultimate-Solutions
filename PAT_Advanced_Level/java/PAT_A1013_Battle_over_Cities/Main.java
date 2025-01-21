package PAT_A1013_Battle_over_Cities;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] init = reader.readLine().split(" ");
        int n = Integer.parseInt(init[0]);
        int m = Integer.parseInt(init[1]);
        int k = Integer.parseInt(init[2]);
        City[] arr = new City[n + 1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = new City(i);
        }

        for (int i = 0; i < m; i++) {
            String[] str = reader.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);
            City p = arr[x];
            while (p.next != null) p = p.next;
            p.next = new City(y);
            City q = arr[y];
            while (q.next != null) q = q.next;
            q.next = new City(x);
        }

        String[] connect = reader.readLine().split(" ");
        for (int j = 0; j < k; j++) {
            boolean[] visit = new boolean[n + 1];
            int ocp = Integer.parseInt(connect[j]);
            visit[ocp] = true;
            int subConnectBranch = 0;
            for (int i = 1; i < n + 1; i++) {
                if (!visit[i]) {
                    subConnectBranch++;
                    visit[i] = true;
                    dfs(visit, i, arr, ocp);
                }
            }
            System.out.println(subConnectBranch - 1);
        }
    }

    public static void dfs(boolean[] visit, int id, City[] arr, int ocp) {
        City p = arr[id];
        while (p.next != null) {
            p = p.next;
            if (p.id != ocp && !visit[p.id]) {
                visit[p.id] = true;
                dfs(visit, p.id, arr, ocp);
            }
        }
    }

    static class City {
        int id;
        City next;

        public City(int id) {
            this.id = id;
        }
    }
}
