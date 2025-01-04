package A1041_BeUnique;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


/**
 * 测试点4、5超时
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] sp = reader.readLine().split(" ");

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        for (int i = 1; i < sp.length; i++) {
            if (list1.contains(sp[i])) {
                list2.add(sp[i]);
            } else {
                list1.add(sp[i]);
            }
        }
        list1.removeAll(list2);
        if (!list1.isEmpty()) {
            System.out.print(list1.get(0));
        } else {
            System.out.print("None");
        }
    }
}
