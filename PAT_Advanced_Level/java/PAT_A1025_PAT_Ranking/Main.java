package PAT_A1025_PAT_Ranking;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Student implements Comparable<Student> {
    String id;
    int grade;
    int locationNumber;
    int localRank;
    int finalRank;

    Student(String id, int grade, int locationNumber) {
        this.id = id;
        this.grade = grade;
        this.locationNumber = locationNumber;
    }

    @Override
    public int compareTo(Student t) {
        if (this.grade != t.grade) {
            return t.grade - this.grade; // Descending order
        }
        return this.id.compareTo(t.id);
    }
}

/**
 * 测试点3超时
 */
public class Main {

    static final int N = 110;
    static List<Student>[] grades = new ArrayList[N];
    static List<Student> all = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < N; i++) {
            grades[i] = new ArrayList<>();
        }

        int n = Integer.parseInt(br.readLine());
        for (int i = 1; i <= n; i++) {
            int k = Integer.parseInt(br.readLine());

            for (int j = 0; j < k; j++) {
                String[] input = br.readLine().split(" ");
                String id = input[0];
                int grade = Integer.parseInt(input[1]);
                grades[i].add(new Student(id, grade, i));
            }

            Collections.sort(grades[i]);
            for (int j = 0; j < grades[i].size(); j++) {
                if (j == 0 || grades[i].get(j).grade != grades[i].get(j - 1).grade) {
                    grades[i].get(j).localRank = j + 1;
                } else {
                    grades[i].get(j).localRank = grades[i].get(j - 1).localRank;
                }
                all.add(grades[i].get(j));
            }
        }

        Collections.sort(all);
        for (int i = 0; i < all.size(); i++) {
            if (i == 0 || all.get(i).grade != all.get(i - 1).grade) {
                all.get(i).finalRank = i + 1;
            } else {
                all.get(i).finalRank = all.get(i - 1).finalRank;
            }
        }

        System.out.println(all.size());
        for (Student s : all) {
            System.out.println(s.id + " " + s.finalRank + " " + s.locationNumber + " " + s.localRank);
        }
    }
}