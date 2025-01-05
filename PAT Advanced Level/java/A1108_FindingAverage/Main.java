package A1108_FindingAverage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] cal = new double[100];
        List<String> invalidStrs = new ArrayList<>();

        int cnt = 0;
        int num = Integer.parseInt(sc.nextLine());

        String[] lines = sc.nextLine().trim().split(" ");

        for (String line : lines) {
            if (isNormal(line)) {
                cal[cnt++] = Double.parseDouble(line);
            } else {
                invalidStrs.add(line);
            }
        }

        for (String str : invalidStrs) {
            System.out.println("ERROR: " + str + " is not a legal number");
        }

        double sum = 0, res;
        for (double v : cal) {
            sum += v;
        }
        if (cnt == 1) {
            res = sum / cnt;
            System.out.printf("The average of %d number is %.2f", cnt, res);
        } else if (cnt > 1) {
            res = sum / cnt;
            System.out.printf("The average of %d numbers is %.2f", cnt, res);
        } else {
            System.out.println("The average of 0 numbers is Undefined");
        }
    }

    public static boolean isNormal(String str) {
        try {
            if (Double.parseDouble(str) <= 1000 && Double.parseDouble(str) >= -1000) {
                return pointLegal(str);
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean pointLegal(String str) {
        char[] chars = str.toCharArray();
        int indexOfPoint;
        int length = str.length();

        if (str.contains(".")) {
            indexOfPoint = str.indexOf(".");
            if (indexOfPoint == 0) {
                return false;
            }
            if (indexOfPoint > 0 && chars[indexOfPoint - 1] == '-') {
                return false;
            }
            return length - indexOfPoint <= 3;
        }
        return true;
    }
}

