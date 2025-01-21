package PAT_A1055_The_Worlds_Richest;

import java.io.*;
import java.util.*;

/**
 * 测试点1、2超时
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int n = Integer.parseInt(splits[0]);
        int m = Integer.parseInt(splits[1]);

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            splits = br.readLine().split(" ");
            String name = splits[0];
            int age = Integer.parseInt(splits[1]);
            int num = Integer.parseInt(splits[2]);
            students.add(new Student(name, age, num));
        }

        students.sort(Comparator.comparingInt(o -> o.age));
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i <= m; i++) {
            List<Student> list = new ArrayList<>();
            splits = br.readLine().split(" ");
            int rage = Integer.parseInt(splits[0]);
            int min = Integer.parseInt(splits[1]);
            int max = Integer.parseInt(splits[2]);
            builder.append(String.format("Case #%d:\n", i));
            for (Student student : students) {
                if (student.age <= max && student.age >= min) {
                    list.add(student);
                } else if (student.age > max) {
                    break;
                }
            }

            Collections.sort(list);
            int k = 0;
            while (k < list.size() && k < rage) {
                builder.append(list.get(k));
                k++;
            }
            if (list.isEmpty()) {
                builder.append("None\n");
            }
        }
        System.out.print(builder.toString().trim());
    }
}

class Student implements Comparable<Student> {
    String name;
    int age;
    int num;

    public Student(String name, int age, int num) {
        this.name = name;
        this.age = age;
        this.num = num;
    }

    @Override
    public String toString() {
        return name + " " + age + " " + num + "\n";
    }

    @Override
    public int compareTo(Student o) {
        if (this.num != o.num) {
            return o.num - this.num;
        } else if (this.age != o.age) {
            return this.age - o.age;
        } else {
            return this.name.compareTo(o.name);
        }
    }
}
