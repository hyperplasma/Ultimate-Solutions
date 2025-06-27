package PAT_A1080_Graduate_Admission;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 测试点4超时
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] line = reader.readLine().split(" ");
        int N = Integer.parseInt(line[0]);   // number of applicants
        int M = Integer.parseInt(line[1]);   // number of schools
        int K = Integer.parseInt(line[2]);   // number of choices

        int[] schoolQuota = new int[M];     // quota in a certain school
        line = reader.readLine().split(" ");
        // quota in String to int
        for (int i = 0; i < M; i++) {
            schoolQuota[i] = Integer.parseInt(line[i]);
        }

        int[] lineInt;     // to save applicants data in integer
        int len = K + 2;    // number of integers in a line
        ArrayList<Student> students = new ArrayList<>();    // to save all applicants

        for (int i = 0; i < N; i++) {
            line = reader.readLine().split(" ");
            lineInt = new int[len];
            // String to int
            for (int j = 0; j < len; j++) {
                lineInt[j] = Integer.parseInt(line[j]);
            }
            int[] choices = Arrays.copyOfRange(lineInt, 2, len);
            Student student = new Student(i, lineInt[0], lineInt[1], choices);
            students.add(student);
        }

        // sort applicants according to their final grade and grade of ge
        students.sort((o1, o2) -> {
            if (o1.finalGrade != o2.finalGrade) {
                return o2.finalGrade - o1.finalGrade;
            }
            return o2.ge - o1.ge;
        });

        // to save final admission result
        ArrayList<ArrayList<Student>> admissionResult = new ArrayList<>();

        // init of admission result
        for (int i = 0; i < M; i++) {
            ArrayList<Student> certainSchoolResult = new ArrayList<>();
            admissionResult.add(certainSchoolResult);
        }


        for (int i = 0; i < N; i++) {
            Student temp = students.get(i);
            for (int choice : temp.choices) {
                if (schoolQuota[choice] > 0) {
                    schoolQuota[choice]--;
                    admissionResult.get(choice).add(temp);
                    break;
                }
                if (schoolQuota[choice] == 0) {
                    ArrayList<Student> schoolResult = admissionResult.get(choice);
                    int num = schoolResult.size();      // number of  applicants being admitted
                    if (num != 0) {
                        // if someone's final grade and grade of ge both equal last applicant's
                        // he should be admitted to the same school too even there is no quota
                        if (temp.finalGrade == schoolResult.get(num - 1).finalGrade
                                && temp.ge == schoolResult.get(num - 1).ge) {
                            admissionResult.get(choice).add(temp);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < M; i++) {
            if (!admissionResult.get(i).isEmpty()) {
                // sort a certain school's applicants being admitted according to their ID
                admissionResult.get(i).sort(Comparator.comparingInt(o -> o.id));
                // print applicants' ID
                for (int j = 0; j < admissionResult.get(i).size(); j++) {
                    System.out.print(admissionResult.get(i).get(j).id);
                    if (j == admissionResult.get(i).size() - 1) {
                        System.out.println();
                        break;
                    }
                    System.out.print(" ");
                }
            } else {
                System.out.println();
            }
        }
    }
}

class Student {
    int id;
    int ge;
    int gi;
    int finalGrade;
    int[] choices;

    public Student(int id, int ge, int gi, int[] choices) {
        this.id = id;
        this.ge = ge;
        this.gi = gi;
        finalGrade = ge + gi;
        this.choices = choices;
    }
}