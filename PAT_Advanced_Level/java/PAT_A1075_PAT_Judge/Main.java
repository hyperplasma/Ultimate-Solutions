package PAT_A1075_PAT_Judge;

import java.io.*;
import java.util.*;

/**
 * 测试点4超时
 */
public class Main {
    static final int N = 10010, M = 7;
    static int n, Q, m;
    static int[] fullScore = new int[M];
    static Map<Integer, Student> mp = new HashMap<>();
    static List<Student> v = new ArrayList<>();

    static class Student implements Comparable<Student> {
        int id;
        int[] score;
        int pNum;
        int total;
        int r;
        boolean flag;
        boolean[] isSubmitted;
        boolean[] hasP;

        public Student(int id) {
            this.id = id;
            this.score = new int[M];
            this.isSubmitted = new boolean[M];
            this.hasP = new boolean[M];
            this.flag = false;
            this.pNum = 0;
            this.total = 0;
        }

        @Override
        public int compareTo(Student t) {
            if (this.total != t.total) {
                return t.total - this.total;
            } else if (this.pNum != t.pNum) {
                return t.pNum - this.pNum;
            } else {
                return this.id - t.id;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        n = Integer.parseInt(parts[0]);
        Q = Integer.parseInt(parts[1]);
        m = Integer.parseInt(parts[2]);

        String[] fullScoreParts = br.readLine().split(" ");
        for (int i = 1; i <= Q; ++i) {
            fullScore[i] = Integer.parseInt(fullScoreParts[i - 1]);
        }

        for (int i = 0; i < m; ++i) {
            parts = br.readLine().split(" ");
            int id = Integer.parseInt(parts[0]);
            int pid = Integer.parseInt(parts[1]);
            int score = Integer.parseInt(parts[2]);

            if (!mp.containsKey(id)) {
                mp.put(id, new Student(id));
            }

            Student stu = mp.get(id);
            if (score != -1) {
                stu.score[pid] = Math.max(score, stu.score[pid]);
                stu.isSubmitted[pid] = true;
                if (!stu.hasP[pid] && score == fullScore[pid]) {
                    stu.pNum++;
                    stu.hasP[pid] = true;
                }
                stu.flag = true;
            } else {
                stu.isSubmitted[pid] = true;
                stu.score[pid] = Math.max(0, stu.score[pid]);
            }
        }

        for (Student stu : mp.values()) {
            if (stu.flag) {
                for (int i = 1; i <= Q; ++i) {
                    stu.total += stu.score[i];
                }
                v.add(stu);
            }
        }

        Collections.sort(v);

        v.get(0).r = 1;

        for (int i = 0; i < v.size(); ++i) {
            if (i > 0) {
                if (v.get(i).total == v.get(i - 1).total) v.get(i).r = v.get(i - 1).r;
                else v.get(i).r = i + 1;
            }

            System.out.printf("%d %05d %d", v.get(i).r, v.get(i).id, v.get(i).total);
            for (int j = 1; j <= Q; ++j) {
                if (!v.get(i).isSubmitted[j]) System.out.print(" -");
                else System.out.print(" " + v.get(i).score[j]);
            }
            System.out.println();
        }

        br.close();
    }
}