package PAT_A1062_Talent_and_Virtue;

import java.io.*;
import java.util.*;

public class Main {
    static final int N = 100010;

    static int n, L, H;  // L: 最低标准 H: 划分线

    static class Person implements Comparable<Person> {
        int id, virtue, talent, total;  // virtue: 德，talent: 才

        public Person(int id, int virtue, int talent) {
            this.id = id;
            this.virtue = virtue;
            this.talent = talent;
            this.total = virtue + talent;
        }

        @Override
        public int compareTo(Person t) {
            if (this.total != t.total) {
                return t.total - this.total;
            } else if (this.virtue != t.virtue) {
                return t.virtue - this.virtue;
            } else {
                return this.id - t.id;
            }
        }
    }

    static List<Person>[] level = new List[4]; // 0：全过线，1：才不过德过，2：都不过线但才胜德，3：else

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 4; i++) {
            level[i] = new ArrayList<>();
        }

        for (int i = 0; i < n; ++i) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int virtue = Integer.parseInt(st.nextToken());
            int talent = Integer.parseInt(st.nextToken());
            Person p = new Person(id, virtue, talent);

            if (p.virtue >= L && p.talent >= L) {
                if (p.virtue >= H && p.talent >= H) {
                    level[0].add(p);
                } else if (p.virtue >= H) {
                    level[1].add(p);
                } else if (p.talent < H && p.virtue >= p.talent) {
                    level[2].add(p);
                } else {
                    level[3].add(p);
                }
            }
        }

        int num = 0;
        for (int i = 0; i < 4; ++i) {
            num += level[i].size();
            Collections.sort(level[i]);
        }

        System.out.println(num);
        for (int i = 0; i < 4; ++i) {
            for (Person p : level[i]) {
                System.out.printf("%08d %d %d\n", p.id, p.virtue, p.talent);
            }
        }

        br.close();
    }
}