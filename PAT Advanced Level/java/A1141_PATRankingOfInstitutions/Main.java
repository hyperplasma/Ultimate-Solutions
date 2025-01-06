package A1141_PATRankingOfInstitutions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 测试点4、5超时
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Map<String, School> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] inputs = reader.readLine().split(" ");
            String s = inputs[0];
            int score = Integer.parseInt(inputs[1]);
            String id = inputs[2].toLowerCase();

            map.putIfAbsent(id, new School());
            School school = map.get(id);
            school.id = id;
            school.num++;

            if (s.charAt(0) == 'B') {
                school.total += score * 1.0 / 1.5;
            } else if (s.charAt(0) == 'A') {
                school.total += score * 1.0;
            } else {
                school.total += score * 1.5;
            }
        }

        List<School> list = new ArrayList<>(map.values());
        Collections.sort(list);

        System.out.println(list.size());

        list.get(0).r = 1;
        System.out.printf("%d %s %d %d\n", list.get(0).r, list.get(0).id, (int) list.get(0).total, list.get(0).num);
        for (int i = 1; i < list.size(); i++) {
            if ((int) list.get(i).total == (int) list.get(i - 1).total) {
                list.get(i).r = list.get(i - 1).r;
            } else {
                list.get(i).r = i + 1;
            }
            System.out.printf("%d %s %d %d\n", list.get(i).r, list.get(i).id, (int) list.get(i).total, list.get(i).num);
        }
    }
}

class School implements Comparable<School> {
    String id;
    double total = 0;
    int num = 0;
    int r;

    @Override
    public int compareTo(School t) {
        if ((int) this.total != (int) t.total) {
            return (int) t.total - (int) this.total;
        } else if (this.num != t.num) {
            return this.num - t.num;
        } else {
            return this.id.compareTo(t.id);
        }
    }
}