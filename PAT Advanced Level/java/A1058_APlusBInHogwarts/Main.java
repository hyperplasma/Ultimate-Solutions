package A1058_APlusBInHogwarts;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] parts = br.readLine().split(" ");
        String[] first = parts[0].split("\\.");
        String[] second = parts[1].split("\\.");

        int a = Integer.parseInt(first[0]);
        int b = Integer.parseInt(first[1]);
        int c = Integer.parseInt(first[2]);
        int d = Integer.parseInt(second[0]);
        int e = Integer.parseInt(second[1]);
        int f = Integer.parseInt(second[2]);

        a += d;
        b += e;
        c += f;

        b += c / 29;
        c %= 29;

        a += b / 17;
        b %= 17;

        System.out.printf("%d.%d.%d\n", a, b, c);
    }
}