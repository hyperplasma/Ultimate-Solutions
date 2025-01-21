package PAT_A1137_Final_Grading;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 测试点3超时
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        HashMap<String, Student> map = new HashMap<>();
        List<Student> list = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            String id = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            map.putIfAbsent(id, new Student());
            map.get(id).id = id;
            map.get(id).gProgram = score;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String id = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            map.putIfAbsent(id, new Student());
            map.get(id).id = id;
            map.get(id).gMid = score;
            map.get(id).hasMid = true;
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String id = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            map.putIfAbsent(id, new Student());
            map.get(id).id = id;
            map.get(id).gFinal = score;
            map.get(id).hasFinal = true;
        }

        for (Student stu : map.values()) {
            if (stu.gProgram >= 200) {
                if (stu.gMid > stu.gFinal) {
                    stu.gTotal = stu.gMid * 0.4 + stu.gFinal * 0.6 + 0.5;
                } else {
                    stu.gTotal = stu.gFinal;
                }

                if (stu.gTotal >= 60) {
                    list.add(stu);
                }
            }
        }

        Collections.sort(list);

        for (Student stu : list) {
            System.out.printf("%s %d %d %d %d\n", stu.id, stu.gProgram, stu.gMid, stu.gFinal, (int) stu.gTotal);
        }

        br.close();
    }
}

class Student implements Comparable<Student> {
    String id;
    int gProgram;
    int gMid = -1;
    int gFinal = -1;
    double gTotal;
    boolean hasMid = false;
    boolean hasFinal = false;

    @Override
    public int compareTo(Student t) {
        if ((int) gTotal != (int) t.gTotal) {
            return (int) t.gTotal - (int) gTotal;
        } else {
            return id.compareTo(t.id);
        }
    }
}
