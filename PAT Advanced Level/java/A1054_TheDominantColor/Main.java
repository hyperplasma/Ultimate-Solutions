package A1054_TheDominantColor;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int n = Integer.parseInt(splits[1]);

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            splits = br.readLine().split(" ");
            for (String s : splits) {
                map.merge(s, 1, Integer::sum);
            }
        }

        int max = 0;
        String flag = "";
        for (String key : map.keySet()) {
            Integer value = map.get(key);
            if (value > max) {
                max = value;
                flag = key;
            }
        }
        System.out.println(flag);
    }
}
