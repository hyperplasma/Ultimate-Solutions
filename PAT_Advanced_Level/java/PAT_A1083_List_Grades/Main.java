package PAT_A1083_List_Grades;

import java.io.*;
import java.util.*;

public class Main {
    static final int N = 110;

    static class Person implements Comparable<Person> {
        String name, id;
        int grade;

        @Override
        public int compareTo(Person t) {
            return t.grade - this.grade;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Person[] p = new Person[N];
        for (int i = 0; i < n; i++) {
            p[i] = new Person();
            String[] parts = br.readLine().split(" ");
            p[i].name = parts[0];
            p[i].id = parts[1];
            p[i].grade = Integer.parseInt(parts[2]);
        }

        String[] parts = br.readLine().split(" ");
        int g1 = Integer.parseInt(parts[0]);
        int g2 = Integer.parseInt(parts[1]);

        List<Person> filtered = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (p[i].grade >= g1 && p[i].grade <= g2) {
                filtered.add(p[i]);
            }
        }

        if (filtered.isEmpty()) {
            System.out.println("NONE");
        } else {
            Collections.sort(filtered);
            for (Person person : filtered) {
                System.out.println(person.name + " " + person.id);
            }
        }

        br.close();
    }
}