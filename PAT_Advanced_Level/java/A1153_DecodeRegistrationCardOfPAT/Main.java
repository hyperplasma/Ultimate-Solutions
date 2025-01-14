package A1153_DecodeRegistrationCardOfPAT;

import java.io.*;
import java.util.*;

/**
 * 测试点2、3、4超时
 */
public class Main {
    static class Student {
        String cardNum;
        int score;
        char level;
        int site;
        String date;
        int testeeNum;

        Student(String cardNum, int score) {
            this.cardNum = cardNum;
            this.score = score;
            this.level = cardNum.charAt(0);
            this.site = Integer.parseInt(cardNum.substring(1, 4));
            this.date = cardNum.substring(4, 10);
            this.testeeNum = Integer.parseInt(cardNum.substring(10));
        }
    }

    static class Site implements Comparable<Site> {
        int site;
        int count;

        Site(int site, int count) {
            this.site = site;
            this.count = count;
        }

        @Override
        public int compareTo(Site other) {
            if (this.count != other.count) {
                return other.count - this.count;
            } else {
                return this.site - other.site;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

//        List<Student> students = new ArrayList<>();
        Map<Integer, List<Student>> sitesMap = new HashMap<>();
        Map<Character, List<Student>> levelsMap = new HashMap<>();
        Map<String, Map<Integer, Integer>> dateMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            Student student = new Student(inputs[0], Integer.parseInt(inputs[1]));
//            students.add(student);

            sitesMap.computeIfAbsent(student.site, k -> new ArrayList<>()).add(student);

            levelsMap.computeIfAbsent(student.level, k -> new ArrayList<>()).add(student);

            dateMap.computeIfAbsent(student.date, k -> new HashMap<>())
                    .merge(student.site, 1, Integer::sum);
        }

        for (int q = 1; q <= M; q++) {
            inputs = br.readLine().split(" ");
            int type = Integer.parseInt(inputs[0]);
            String term = inputs[1];

            System.out.printf("Case %d: %d %s\n", q, type, term);

            switch (type) {
                case 1: // Query by level
                    List<Student> levelStudents = levelsMap.getOrDefault(term.charAt(0), new ArrayList<>());
                    if (levelStudents.isEmpty()) {
                        System.out.println("NA");
                    } else {
                        levelStudents.sort((a, b) -> {
                            if (a.score != b.score) {
                                return b.score - a.score;
                            } else {
                                return a.cardNum.compareTo(b.cardNum);
                            }
                        });
                        for (Student s : levelStudents) {
                            System.out.printf("%s %d\n", s.cardNum, s.score);
                        }
                    }
                    break;

                case 2: // Query by site
                    int siteNum = Integer.parseInt(term);
                    List<Student> siteStudents = sitesMap.getOrDefault(siteNum, new ArrayList<>());
                    if (siteStudents.isEmpty()) {
                        System.out.println("NA");
                    } else {
                        int total = siteStudents.stream().mapToInt(s -> s.score).sum();
                        System.out.printf("%d %d\n", siteStudents.size(), total);
                    }
                    break;

                case 3: // Query by date
                    Map<Integer, Integer> siteCounts = dateMap.getOrDefault(term, new HashMap<>());
                    if (siteCounts.isEmpty()) {
                        System.out.println("NA");
                    } else {
                        List<Site> counts = new ArrayList<>();
                        for (Map.Entry<Integer, Integer> entry : siteCounts.entrySet()) {
                            counts.add(new Site(entry.getKey(), entry.getValue()));
                        }
                        Collections.sort(counts);
                        for (Site sc : counts) {
                            System.out.printf("%d %d\n", sc.site, sc.count);
                        }
                    }
                    break;
            }
        }
    }
}
