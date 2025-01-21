package B1122;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        String[] inputs = reader.readLine().split(" ");

        for (String input : inputs) {
            Integer num = Integer.parseInt(input);
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }

        for (String input : inputs) {
            Integer num = Integer.parseInt(input);
            if (num % 2 != 0 && map.get(num) % 2 != 0) {
                System.out.println(num);
                break;
            }
        }
    }
}