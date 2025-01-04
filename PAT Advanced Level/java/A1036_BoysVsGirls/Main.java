package A1036_BoysVsGirls;

import java.util.*;

public class Main {
    static class Student implements Comparable<Student> {
        private final String name;
        private final String ID;
        private final int grade;

        public Student(String name, String ID, int grade) {
            this.name = name;
            this.ID = ID;
            this.grade = grade;
        }

        @Override
        public int compareTo(Student o) {
            return o.grade - this.grade;
        }

        @Override
        public String toString() {
            return name + " " + ID;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> maleList = new ArrayList<>();
        ArrayList<Student> femaleList = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            String gender = scanner.next();
            String ID = scanner.next();
            int grade = scanner.nextInt();
            if (gender.equals("F")) {
                femaleList.add(new Student(name, ID, grade));
            } else if (gender.equals("M")) {
                maleList.add(new Student(name, ID, grade));
            }
        }
        Collections.sort(maleList);
        Collections.sort(femaleList);
        if (!maleList.isEmpty() && !femaleList.isEmpty()) {
            System.out.println(femaleList.get(0));
            System.out.println(maleList.get(maleList.size() - 1));
            System.out.println(femaleList.get(0).grade - maleList.get(maleList.size() - 1).grade);
        } else if (maleList.isEmpty() && !femaleList.isEmpty()) {
            System.out.println(femaleList.get(0));
            System.out.println("Absent");
            System.out.println("NA");
        } else if (!maleList.isEmpty()) {
            System.out.println("Absent");
            System.out.println(maleList.get(maleList.size() - 1));
            System.out.println("NA");
        } else {
            System.out.println("Absent");
            System.out.println("Absent");
            System.out.println("NA");
        }
    }
}
