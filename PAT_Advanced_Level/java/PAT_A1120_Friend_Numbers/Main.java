package PAT_A1120_Friend_Numbers;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            set.add(sum);
        }

        System.out.println(set.size());
        boolean isFirst = true;
        for (int num : set) {
            if (!isFirst) {
                System.out.print(" ");
            } else {
                isFirst = false;
            }
            System.out.print(num);
        }
        System.out.println();

        sc.close();
    }
}
