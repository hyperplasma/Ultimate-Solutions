package A1028_ListSorting;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

class Row {
    String id, name;
    int grade;

    Row(String id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstLine = reader.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int c = Integer.parseInt(firstLine[1]);

        Row[] rows = new Row[n];
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            String id = input[0];
            String name = input[1];
            int grade = Integer.parseInt(input[2]);
            rows[i] = new Row(id, name, grade);
        }

        if (c == 1) {
            Arrays.sort(rows, Comparator.comparing(row -> row.id));
        } else if (c == 2) {
            Arrays.sort(rows, (a, b) -> {
                if (!a.name.equals(b.name)) {
                    return a.name.compareTo(b.name);
                }
                return a.id.compareTo(b.id);
            });
        } else {
            Arrays.sort(rows, (a, b) -> {
                if (a.grade != b.grade) {
                    return Integer.compare(a.grade, b.grade);
                }
                return a.id.compareTo(b.id);
            });
        }

        for (Row row : rows) {
            System.out.println(row.id + " " + row.name + " " + row.grade);
        }
    }
}