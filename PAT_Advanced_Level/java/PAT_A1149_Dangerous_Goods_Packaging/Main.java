package PAT_A1149_Dangerous_Goods_Packaging;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] incompatible1 = new int[n];
        int[] incompatible2 = new int[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            incompatible1[i] = Integer.parseInt(st.nextToken());
            incompatible2[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> goods = new HashSet<>();
        for (int i = 0; i < m; i++) {
            goods.clear();

            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());

            for (int j = 0; j < K; j++) {
                goods.add(Integer.parseInt(st.nextToken()));
            }

            boolean isCompatible = true;
            for (int j = 0; j < n; j++) {
                if (goods.contains(incompatible1[j]) && goods.contains(incompatible2[j])) {
                    isCompatible = false;
                    break;
                }
            }

            System.out.println(isCompatible ? "Yes" : "No");
        }
    }
}