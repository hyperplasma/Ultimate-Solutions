package A1109_GroupPhoto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    static final int N = 10010;
    static int n, m;
    static Person[] p = new Person[N];

    static class Person {
        String name;
        int h;

        Person(String name, int h) {
            this.name = name;
            this.h = h;
        }
    }

    static class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person a, Person b) {
            if (a.h != b.h) return b.h - a.h;
            else return a.name.compareTo(b.name);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for (int i = 0; i < n; i++) {
            String[] personInfo = br.readLine().split(" ");
            p[i] = new Person(personInfo[0], Integer.parseInt(personInfo[1]));
        }

        Arrays.sort(p, 0, n, new PersonComparator());

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            int len = n / m;
            if (i == 0) {
                len += n % m;
            }

            StringBuilder res = new StringBuilder();
            for (int j = 0; j < len; j++) {
                if (j % 2 == 0) res.append(p[cnt++].name).append(" ");
                else res.insert(0, p[cnt++].name + " ");
            }

            while (res.length() > 0 && res.charAt(res.length() - 1) == ' ') {
                res.deleteCharAt(res.length() - 1);
            }
            System.out.println(res);
        }
    }
}